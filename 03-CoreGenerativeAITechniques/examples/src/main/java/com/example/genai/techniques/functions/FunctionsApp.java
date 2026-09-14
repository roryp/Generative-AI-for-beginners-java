package com.example.genai.techniques.functions;

import com.example.genai.techniques.AzureOpenAIConfig;
import com.example.genai.techniques.ChatResponses;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.openai.client.OpenAIClient;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionToolChoiceOption;
import com.openai.models.chat.completions.ChatCompletionToolMessageParam;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Pattern;

/** Function calling with typed arguments, simulated weather, and a real arithmetic parser. */
public class FunctionsApp {
    private static final Pattern PERCENT_OF = Pattern.compile(
            "^([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+))\\s*%\\s*of\\s*([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+))$",
            Pattern.CASE_INSENSITIVE);
        private static final Pattern PERCENT_LITERAL = Pattern.compile(
            "(\\d+(?:\\.\\d*)?|\\.\\d+)\\s*%(?!\\s*[\\d.])");

    /** Runs the weather and calculator demonstrations, each using two chat requests. */
    public static void main(String[] args) {
        var config = AzureOpenAIConfig.fromEnvironment();
        OpenAIClient client = config.createClient();
        try {
            runExamples(client, config, System.out);
        } finally {
            client.close();
        }
    }

    static void runExamples(OpenAIClient client, AzureOpenAIConfig config, PrintStream output) {
        output.println("=== Weather Function Example (simulated data) ===");
        runFunctionExample(client, config, WeatherArguments.class, "get_weather",
                "You are a weather assistant. Use get_weather, and clearly label its data as simulated, not live weather.",
                "What's the weather like in Seattle? Use celsius.", output);
        output.println("\n=== Calculator Function Example ===");
        runFunctionExample(client, config, CalculationArguments.class, "calculate",
                "You are a math assistant. Use calculate for mathematical operations.",
                "What's 15% of 240?", output);
    }

    static void runFunctionExample(OpenAIClient client, AzureOpenAIConfig config, Class<?> toolType,
                                   String toolName, String systemPrompt, String question, PrintStream output) {
        var request = config.chatOptions(300)
                .addSystemMessage(systemPrompt)
                .addUserMessage(question)
                .addTool(toolType)
                .toolChoice(ChatCompletionToolChoiceOption.Auto.REQUIRED)
                .parallelToolCalls(false)
                .build();
        var response = client.chat().completions().create(request);
        if (response.choices().isEmpty()) {
            throw new IllegalStateException("The model returned no tool-call choice.");
        }
        var choice = response.choices().getFirst();
        if (!ChatCompletion.Choice.FinishReason.TOOL_CALLS.equals(choice.finishReason())) {
            throw new IllegalStateException("Expected tool_calls, received " + choice.finishReason());
        }
        var toolCalls = choice.message().toolCalls()
                .filter(calls -> !calls.isEmpty())
                .orElseThrow(() -> new IllegalStateException("The model returned no tool calls."));
        var followUp = config.chatOptions(300)
                .messages(request.messages())
                .addMessage(choice.message());
        var callIds = new HashSet<String>();
        for (var toolCall : toolCalls) {
            if (!toolCall.isFunction()) {
                throw new IllegalArgumentException("Only function tools are supported by this example.");
            }
            var functionCall = toolCall.asFunction();
            if (functionCall.id().isBlank() || !callIds.add(functionCall.id())) {
                throw new IllegalArgumentException("Tool calls must have unique, nonblank IDs.");
            }
            var function = functionCall.function();
            if (!toolName.equals(function.name())) {
                throw new IllegalArgumentException("Unexpected function: " + function.name());
            }
            Object result = switch (function.name()) {
                case "get_weather" -> weather(function.arguments(WeatherArguments.class));
                case "calculate" -> calculate(function.arguments(CalculationArguments.class));
                default -> throw new IllegalArgumentException("Unknown function: " + function.name());
            };
            output.println("Function: " + function.name());
            output.println("Function result: " + result);
            followUp.addMessage(ChatCompletionToolMessageParam.builder()
                    .toolCallId(functionCall.id())
                    .contentAsJson(result)
                    .build());
        }
        output.println("AI: " + ChatResponses.text(client.chat().completions().create(followUp.build())));
    }

    static WeatherResult weather(WeatherArguments arguments) {
        if (arguments.city() == null || arguments.city().isBlank()) {
            throw new IllegalArgumentException("A city is required.");
        }
        String unit = arguments.unit() == null ? "celsius" : arguments.unit().strip().toLowerCase(Locale.ROOT);
        if (!unit.equals("celsius") && !unit.equals("fahrenheit")) {
            throw new IllegalArgumentException("Weather unit must be celsius or fahrenheit.");
        }
        double temperature = unit.equals("fahrenheit") ? 22 * 9.0 / 5 + 32 : 22;
        return new WeatherResult(arguments.city().strip(), temperature, unit, "partly cloudy", "simulated");
    }

    static BigDecimal calculate(CalculationArguments arguments) {
        if (arguments.expression() == null || arguments.expression().isBlank()
                || arguments.expression().length() > 200) {
            throw new IllegalArgumentException("Provide an arithmetic expression of 1 to 200 characters.");
        }
        String expression = arguments.expression().strip();
        var percentage = PERCENT_OF.matcher(expression);
        if (percentage.matches()) {
            expression = "(" + percentage.group(1) + ") / 100 * (" + percentage.group(2) + ")";
        }
        expression = PERCENT_LITERAL.matcher(expression).replaceAll("($1 / 100)");
        double result = new ExpressionBuilder(expression).build().evaluate();
        if (!Double.isFinite(result)) {
            throw new IllegalArgumentException("The calculation must have a finite result.");
        }
        return BigDecimal.valueOf(result).stripTrailingZeros();
    }

    /** JSON arguments for the simulated weather tool. */
    @JsonTypeName("get_weather")
    @JsonClassDescription("Return simulated weather for a city. This is sample data, not a live weather API.")
    public record WeatherArguments(
            @JsonPropertyDescription("The city name") String city,
            @JsonPropertyDescription("Temperature unit: celsius or fahrenheit") String unit) {
    }

    /** JSON arguments for a calculator supporting arithmetic and expressions such as 15% of 240. */
    @JsonTypeName("calculate")
    @JsonClassDescription("Evaluate arithmetic, such as 2 + 3 * 4 or 15% of 240. No code execution or variables.")
    public record CalculationArguments(
            @JsonPropertyDescription("An arithmetic expression, at most 200 characters. "
                + "Write percentages as division by 100, for example (15 / 100) * 240.") String expression) {
    }

    /** Explicitly labeled simulated data returned to the model as JSON. */
    public record WeatherResult(String city, double temperature, String unit, String condition, String source) {
    }
}
