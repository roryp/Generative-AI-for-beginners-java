package com.example.genai.techniques.completions;

import com.example.genai.techniques.AzureOpenAIConfig;
import com.example.genai.techniques.RecordingHttpClient;
import com.openai.client.OpenAIClient;
import com.openai.errors.RateLimitException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import static com.example.genai.techniques.RecordingHttpClient.assertChatOptions;
import static org.junit.jupiter.api.Assertions.*;

class LLMCompletionsAppTest {
    private final AzureOpenAIConfig config = new AzureOpenAIConfig(
            "https://example.openai.azure.com", "test-luna-deployment", null);
    private final RecordingHttpClient transport = new RecordingHttpClient();
    private final OpenAIClient client = transport.client();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @AfterEach
    void closeClient() {
        client.close();
    }

    @Test
    void runsEveryCompletionAndPreservesMultiTurnAndInteractiveHistory() {
        for (String reply : new String[]{"Stream explanation", "HashMap explanation", "TreeMap comparison",
                "The name is Ada", "You said Ada"}) {
            transport.enqueueChat(reply);
        }
        try (var scanner = new Scanner("\nMy name is Ada\nWhat is my name?\n ExIt \n")) {
            LLMCompletionsApp.runExamples(client, config, scanner, new PrintStream(output));
        }
        var requests = transport.requests();
        assertEquals(5, requests.size());
        long[] budgets = {200, 300, 400, 500, 500};
        for (int index = 0; index < requests.size(); index++) {
            assertChatOptions(requests.get(index), "test-luna-deployment", budgets[index]);
            assertEquals("https://example.openai.azure.com/openai/v1/chat/completions", transport.urls().get(index));
        }
        var multiTurn = requests.get(2).path("messages");
        assertEquals(4, multiTurn.size());
        assertEquals("assistant", multiTurn.get(2).path("role").asText());
        assertEquals("HashMap explanation", multiTurn.get(2).path("content").asText());
        var interactive = requests.get(4).path("messages");
        assertEquals(4, interactive.size());
        assertEquals("My name is Ada", interactive.get(1).path("content").asText());
        assertEquals("The name is Ada", interactive.get(2).path("content").asText());
        assertEquals("What is my name?", interactive.get(3).path("content").asText());
        assertTrue(output.toString().contains("AI: You said Ada"));
        assertTrue(output.toString().contains("Goodbye!"));
        transport.assertExhausted();
    }

    @Test
    void trimsOnlyCompleteOldTurnsAndPreservesTheSystemMessage() {
        var input = new StringBuilder();
        for (int turn = 1; turn <= 12; turn++) {
            input.append("Question ").append(turn).append('\n');
            transport.enqueueChat("Answer " + turn);
        }
        try (var scanner = new Scanner(input.toString())) {
            LLMCompletionsApp.interactiveChat(client, config, scanner, new PrintStream(output));
        }
        var history = transport.requests().getLast().path("messages");
        assertEquals(20, history.size());
        assertEquals("system", history.get(0).path("role").asText());
        assertEquals("Question 3", history.get(1).path("content").asText());
        assertEquals("Question 12", history.get(19).path("content").asText());
        for (int index = 1; index < history.size(); index++) {
            assertEquals(index % 2 == 1 ? "user" : "assistant", history.get(index).path("role").asText());
        }
        transport.assertExhausted();
    }

    @Test
    void exitsAtEofAndSkipsBlankInputWithoutRequests() {
        try (var scanner = new Scanner("  \n\n")) {
            LLMCompletionsApp.interactiveChat(client, config, scanner, new PrintStream(output));
        }
        assertTrue(transport.requests().isEmpty());
    }

    @Test
    void propagatesRateLimitsWithoutRetryingOrContinuing() {
        transport.enqueueJson(429, "{\"error\":{\"message\":\"Rate limited\",\"type\":\"rate_limit_error\"}}");
        try (var scanner = new Scanner("exit\n")) {
            assertThrows(RateLimitException.class,
                    () -> LLMCompletionsApp.runExamples(client, config, scanner, new PrintStream(output)));
        }
        assertEquals(1, transport.requests().size());
        assertFalse(output.toString().contains("AI:"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"length", "content_filter", "tool_calls"})
    void rejectsIncompleteResponses(String finishReason) {
        transport.enqueueMessage(finishReason, Map.of("role", "assistant", "content", "Partial answer"));
        try (var scanner = new Scanner("Hello\n")) {
            assertThrows(IllegalStateException.class,
                    () -> LLMCompletionsApp.interactiveChat(client, config, scanner, new PrintStream(output)));
        }
        assertFalse(output.toString().contains("AI:"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void rejectsEmptyText(String text) {
        transport.enqueueChat(text);
        try (var scanner = new Scanner("Hello\n")) {
            assertThrows(IllegalStateException.class,
                    () -> LLMCompletionsApp.interactiveChat(client, config, scanner, new PrintStream(output)));
        }
    }

    @Test
    void rejectsRefusalsAndMissingChoices() {
        transport.enqueueMessage("stop", Map.of("role", "assistant", "refusal", "Cannot answer"));
        transport.enqueueJson(200, "{\"id\":\"empty\",\"object\":\"chat.completion\",\"created\":1,\"model\":\"gpt-5.6-luna\",\"choices\":[]}");
        for (int response = 0; response < 2; response++) {
            try (var scanner = new Scanner("Hello\n")) {
                assertThrows(IllegalStateException.class,
                        () -> LLMCompletionsApp.interactiveChat(client, config, scanner, new PrintStream(output)));
            }
        }
        transport.assertExhausted();
    }
}