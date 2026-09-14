package com.example.genai.techniques.functions;

import com.example.genai.techniques.AzureOpenAIConfig;
import com.example.genai.techniques.RecordingHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openai.client.OpenAIClient;
import com.openai.errors.InternalServerException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.example.genai.techniques.RecordingHttpClient.assertChatOptions;
import static org.junit.jupiter.api.Assertions.*;

class FunctionsAppTest {
    private final AzureOpenAIConfig config = new AzureOpenAIConfig("https://example.openai.azure.com", null, null);
    private final RecordingHttpClient transport = new RecordingHttpClient();
    private final OpenAIClient client = transport.client();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @AfterEach
    void closeClient() {
        client.close();
    }

    @Test
    void runsBothToolsWithExplicitOptionsAndCorrelatedResults() throws Exception {
        enqueueCalls(toolCall("weather-1", "get_weather", "{\"city\":\"Seattle\",\"unit\":\"fahrenheit\"}"));
        transport.enqueueChat("Simulated Seattle weather is 71.6 F.");
        enqueueCalls(toolCall("calc-1", "calculate", "{\"expression\":\"15% of 240\"}"));
        transport.enqueueChat("15% of 240 is 36.");

        FunctionsApp.runExamples(client, config, new PrintStream(output));

        assertEquals(4, transport.requests().size());
        transport.requests().forEach(request -> assertChatOptions(request, "gpt-5.6-luna", 300));
        var first = transport.requests().getFirst();
        assertEquals("required", first.path("tool_choice").asText());
        assertFalse(first.path("parallel_tool_calls").asBoolean());
        var definition = first.path("tools").get(0).path("function");
        assertEquals("get_weather", definition.path("name").asText());
        assertTrue(definition.path("description").asText().contains("simulated"));
        assertTrue(definition.path("parameters").path("properties").has("city"));
        assertTrue(definition.path("parameters").path("properties").has("unit"));
        var weatherHistory = transport.requests().get(1).path("messages");
        assertEquals(4, weatherHistory.size());
        assertEquals("assistant", weatherHistory.get(2).path("role").asText());
        assertEquals("weather-1", weatherHistory.get(3).path("tool_call_id").asText());
        var weather = new ObjectMapper().readTree(weatherHistory.get(3).path("content").asText());
        assertEquals("Seattle", weather.path("city").asText());
        assertEquals(71.6, weather.path("temperature").asDouble(), 0.0001);
        assertEquals("fahrenheit", weather.path("unit").asText());
        assertEquals("simulated", weather.path("source").asText());
        assertFalse(transport.requests().get(1).has("tools"));
        assertEquals("calculate", transport.requests().get(2).path("tools").get(0).path("function").path("name").asText());
        var result = transport.requests().get(3).path("messages").get(3);
        assertEquals("calc-1", result.path("tool_call_id").asText());
        assertEquals(36, new ObjectMapper().readTree(result.path("content").asText()).asInt());
        assertTrue(output.toString().contains("AI: 15% of 240 is 36."));
        transport.assertExhausted();
    }

    @Test
    void sendsAllToolResultsInOneFollowUpAndAddsTheAssistantOnlyOnce() {
        enqueueCalls(toolCall("first", "calculate", "{\"expression\":\"2 + 3 * 4\"}"),
                toolCall("second", "calculate", "{\"expression\":\"10% of 50\"}"));
        transport.enqueueChat("The results are 14 and 5.");
        runCalculator();
        assertEquals(2, transport.requests().size());
        var history = transport.requests().getLast().path("messages");
        assertEquals(5, history.size());
        assertEquals(2, history.get(2).path("tool_calls").size());
        assertEquals("first", history.get(3).path("tool_call_id").asText());
        assertEquals("second", history.get(4).path("tool_call_id").asText());
        assertEquals("14", history.get(3).path("content").asText());
        assertEquals("5", history.get(4).path("content").asText());
        transport.assertExhausted();
    }

    @ParameterizedTest
        @CsvSource({"15% of 240,36", "12.5% of 80,10", "2 + 3 * 4,14", "(2 + 3) * 4,20", "-5% of 200,-10",
            "240 * 15%,36", "15% * 240,36", "80 * 12.5%,10", "-5% * 200,-10", "15%,0.15", "17 % 5,2"})
    void evaluatesArgumentsInsteadOfReturningAFixedValue(String expression, String expected) {
        assertEquals(0, new BigDecimal(expected).compareTo(
                FunctionsApp.calculate(new FunctionsApp.CalculationArguments(expression))));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "invalid", "1 / 0", "sqrt(-1)", "10^1000", "System.exit(0)"})
    void rejectsInvalidOrNonFiniteCalculations(String expression) {
        assertThrows(RuntimeException.class,
                () -> FunctionsApp.calculate(new FunctionsApp.CalculationArguments(expression)));
    }

    @Test
    void respectsWeatherArgumentsAndRejectsInvalidInputs() {
        var weather = FunctionsApp.weather(new FunctionsApp.WeatherArguments(" Paris ", null));
        assertEquals("Paris", weather.city());
        assertEquals(22, weather.temperature());
        assertEquals("celsius", weather.unit());
        assertEquals("simulated", weather.source());
        assertThrows(IllegalArgumentException.class,
                () -> FunctionsApp.weather(new FunctionsApp.WeatherArguments("", "celsius")));
        assertThrows(IllegalArgumentException.class,
                () -> FunctionsApp.weather(new FunctionsApp.WeatherArguments("Paris", "kelvin")));
        assertThrows(IllegalArgumentException.class,
                () -> FunctionsApp.calculate(new FunctionsApp.CalculationArguments("1".repeat(201))));
    }

    @ParameterizedTest
    @ValueSource(strings = {"{", "{}", "{\"expression\":null}", "{\"expression\":\"unknown\"}"})
    void rejectsBadToolArgumentsBeforeSendingAFollowUp(String arguments) {
        enqueueCalls(toolCall("bad", "calculate", arguments));
        assertThrows(RuntimeException.class, this::runCalculator);
        assertEquals(1, transport.requests().size());
    }

    @Test
    void rejectsUnregisteredToolsDuplicateIdsAndMissingCalls() {
        enqueueCalls(toolCall("unknown", "run_command", "{}"));
        assertThrows(IllegalArgumentException.class, this::runCalculator);
        enqueueCalls(toolCall("duplicate", "calculate", "{\"expression\":\"1+1\"}"),
                toolCall("duplicate", "calculate", "{\"expression\":\"2+2\"}"));
        assertThrows(IllegalArgumentException.class, this::runCalculator);
        enqueueCalls();
        assertThrows(IllegalStateException.class, this::runCalculator);
        transport.enqueueChat("An answer without the required tool.");
        assertThrows(IllegalStateException.class, this::runCalculator);
        assertEquals(4, transport.requests().size());
    }

    @Test
    void propagatesFollowUpFailures() {
        enqueueCalls(toolCall("calc", "calculate", "{\"expression\":\"15% of 240\"}"));
        transport.enqueueJson(500, "{\"error\":{\"message\":\"Unavailable\",\"type\":\"server_error\"}}");
        assertThrows(InternalServerException.class, this::runCalculator);
        assertEquals(2, transport.requests().size());
        assertFalse(output.toString().contains("AI:"));
    }

    private void runCalculator() {
        FunctionsApp.runFunctionExample(client, config, FunctionsApp.CalculationArguments.class, "calculate",
                "Use calculate.", "What is 15% of 240?", new PrintStream(output));
    }

    @SafeVarargs
    private void enqueueCalls(Map<String, Object>... calls) {
        transport.enqueueMessage("tool_calls", Map.of("role", "assistant", "tool_calls", List.of(calls)));
    }

    private Map<String, Object> toolCall(String id, String name, String arguments) {
        return Map.of("id", id, "type", "function", "function", Map.of("name", name, "arguments", arguments));
    }
}