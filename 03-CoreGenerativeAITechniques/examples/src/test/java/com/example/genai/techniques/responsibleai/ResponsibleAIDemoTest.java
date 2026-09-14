package com.example.genai.techniques.responsibleai;

import com.example.genai.techniques.AzureOpenAIConfig;
import com.example.genai.techniques.RecordingHttpClient;
import com.openai.errors.OpenAIServiceException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static com.example.genai.techniques.RecordingHttpClient.assertChatOptions;
import static com.example.genai.techniques.responsibleai.ResponsibleAIDemo.Outcome.*;
import static org.junit.jupiter.api.Assertions.*;

class ResponsibleAIDemoTest {
    private final RecordingHttpClient transport = new RecordingHttpClient();
    private final ResponsibleAIDemo demo = new ResponsibleAIDemo(transport.client(),
            new AzureOpenAIConfig("https://example.openai.azure.com", "custom-luna", null));

    @AfterEach
    void closeDemo() {
        demo.close();
    }

    @Test
    void runsAllSixPromptsAndReportsObservedOutcomesWithoutCertifyingSafety() {
        transport.enqueueJson(400, "{\"error\":{\"code\":\"content_filter\",\"message\":\"Blocked\"}}");
        transport.enqueueMessage("stop", Map.of("role", "assistant", "refusal", "I cannot assist with that."));
        transport.enqueueChat("I'm sorry, but I can't help with that.");
        transport.enqueueChat("Consult a qualified medical professional.");
        transport.enqueueMessage("content_filter", Map.of("role", "assistant"));
        transport.enqueueChat("Responsible AI reduces harmful content and unethical behavior.");
        var output = new ByteArrayOutputStream();

        demo.runExamples(new PrintStream(output));

        assertEquals(6, transport.requests().size());
        transport.requests().forEach(request -> assertChatOptions(request, "custom-luna", 300));
        var messages = transport.requests().getLast().path("messages");
        assertEquals("system", messages.get(0).path("role").asText());
        assertEquals("Keep your response under 100 words.", messages.get(0).path("content").asText());
        assertEquals("user", messages.get(1).path("role").asText());
        var lastPrompt = messages.get(1).path("content").asText();
        assertEquals("Explain the importance of responsible AI development", lastPrompt);
        assertTrue(output.toString().contains("Status: FILTERED"));
        assertTrue(output.toString().contains("Status: REFUSED"));
        assertTrue(output.toString().contains("Status: POSSIBLE_REFUSAL"));
        assertTrue(output.toString().contains("Status: GENERATED"));
        assertTrue(output.toString().contains("Text heuristic only"));
        assertTrue(output.toString().contains("not a safety certification"));
        transport.assertExhausted();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "{\"error\":{\"code\":\"content_filter\",\"message\":\"Blocked\"}}",
            "{\"error\":{\"code\":\"ResponsibleAIPolicyViolation\",\"message\":\"Blocked\"}}",
            "{\"error\":{\"code\":\"BadRequest\",\"innererror\":{\"code\":\"ResponsibleAIPolicyViolation\"}}}"})
    void recognizesOnlyExplicitContentFilterCodes(String body) {
        transport.enqueueJson(400, body);
        assertEquals(FILTERED, demo.evaluatePrompt("Safety probe").outcome());
        assertEquals(1, transport.requests().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {400, 401, 403, 404, 429, 500})
    void doesNotMisreportTechnicalFailuresAsSafetySuccess(int status) {
        transport.enqueueJson(status, "{\"error\":{\"code\":\"invalid_request\",\"message\":\"content_filter parameter is invalid\"}}");
        var exception = assertThrows(OpenAIServiceException.class, () -> demo.evaluatePrompt("Safety probe"));
        assertEquals(status, exception.statusCode());
        assertEquals(1, transport.requests().size());
    }

    @Test
    void honorsStructuredRefusalsAndCompletionFilteringWithoutContent() {
        transport.enqueueMessage("stop", Map.of("role", "assistant", "refusal", "Cannot comply."));
        transport.enqueueMessage("content_filter", Map.of("role", "assistant", "content", "Partial output"));
        var refusal = demo.evaluatePrompt("Safety probe");
        assertEquals(REFUSED, refusal.outcome());
        assertEquals("Cannot comply.", refusal.text());
        var filtered = demo.evaluatePrompt("Safety probe");
        assertEquals(FILTERED, filtered.outcome());
        assertFalse(filtered.text().contains("Partial output"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"I cannot assist with that request.", "Sorry, I can't provide that.",
            "I'm sorry, but I can't help with that.", "I\u2019m unable to help with that."})
    void labelsTextOnlyRefusalsAsHeuristic(String response) {
        transport.enqueueChat(response);
        assertEquals(POSSIBLE_REFUSAL, demo.evaluatePrompt("Safety probe").outcome());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"Responsible AI prevents harmful content.", "Avoid unethical behavior and illegal activities.",
            "Here is a quote: I cannot help with that.", "This technique is not appropriate for large files."})
    void avoidsBroadKeywordFalsePositives(String response) {
        assertFalse(ResponsibleAIDemo.looksLikeRefusal(response));
    }

    @Test
    void rejectsTruncatedEmptyAndMissingResponses() {
        transport.enqueueMessage("length", Map.of("role", "assistant", "content", "Partial response"));
        transport.enqueueChat("");
        transport.enqueueJson(200, "{\"id\":\"empty\",\"object\":\"chat.completion\",\"created\":1,\"model\":\"luna\",\"choices\":[]}");
        for (int response = 0; response < 3; response++) {
            assertThrows(IllegalStateException.class, () -> demo.evaluatePrompt("Safety probe"));
        }
        transport.assertExhausted();
    }

    @Test
    void stopsTheDemonstrationOnTechnicalFailure() {
        transport.enqueueJson(429, "{\"error\":{\"message\":\"Rate limited\"}}");
        var output = new ByteArrayOutputStream();
        assertThrows(OpenAIServiceException.class, () -> demo.runExamples(new PrintStream(output)));
        assertFalse(output.toString().contains("=== Summary ==="));
        assertEquals(1, transport.requests().size());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void rejectsBlankPromptsWithoutRequests(String prompt) {
        assertThrows(IllegalArgumentException.class, () -> demo.evaluatePrompt(prompt));
        assertTrue(transport.requests().isEmpty());
    }
}