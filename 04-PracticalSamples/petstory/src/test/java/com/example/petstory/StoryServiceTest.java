package com.example.petstory;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.credential.BearerTokenCredential;
import com.openai.errors.OpenAIServiceException;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Captures real SDK HTTP requests on loopback without using Azure credentials.
 */
class StoryServiceTest {

    private static final byte[] PNG = Base64.getDecoder().decode(
            "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mP8/x8AAwMCAO+jRZkAAAAASUVORK5CYII=");
    private final JsonMapper mapper = JsonMapper.builder().build();
    private final List<JsonNode> requests = new CopyOnWriteArrayList<>();
    private HttpServer server;
    private OpenAIClient client;
    private StoryService service;
    private volatile int responseStatus = 200;
    private volatile byte[] responseBody;

    @BeforeEach
    void setUp() throws Exception {
        respondWithContent(" A friendly pet explores the garden. ");
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/openai/v1/chat/completions", exchange -> {
            try (exchange) {
                requests.add(mapper.readTree(exchange.getRequestBody()));
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(responseStatus, responseBody.length);
                exchange.getResponseBody().write(responseBody);
            }
        });
        server.start();
        client = OpenAIOkHttpClient.builder()
                .baseUrl("http://127.0.0.1:" + server.getAddress().getPort() + "/openai/v1/")
                .credential(BearerTokenCredential.create(() -> "offline-test-token"))
                .maxRetries(0)
                .timeout(Duration.ofSeconds(5))
                .build();
        service = new StoryService(client, "gpt-5.6-luna");
    }

    @AfterEach
    void tearDown() {
        if (client != null) {
            client.close();
        }
        if (server != null) {
            server.stop(0);
        }
    }

    @Test
    void imageAnalysisAndFinalStorySendNoReasoning() {
        String description = service.analyzeImage(PNG, "image/png");
        assertEquals("A friendly pet explores the garden.", description);
        respondWithContent(" A new adventure begins. ");
        assertEquals("A new adventure begins.", service.generateStory(description));

        assertEquals(2, requests.size());
        assertRequestOptions(requests.get(0), "gpt-5.6-luna", 300);
        assertRequestOptions(requests.get(1), "gpt-5.6-luna", 800);
        JsonNode imageParts = requests.get(0).path("messages").get(1).path("content");
        assertEquals("text", imageParts.get(0).path("type").asString());
        assertEquals("image_url", imageParts.get(1).path("type").asString());
        assertEquals("data:image/png;base64," + Base64.getEncoder().encodeToString(PNG),
                imageParts.get(1).path("image_url").path("url").asString());
        assertTrue(requests.get(1).path("messages").get(1).path("content").asString().endsWith(description));
    }

    @Test
    void deploymentOverrideAppliesToBothCalls() {
        service = new StoryService(client, "custom-vision-deployment");
        service.analyzeImage(PNG, "image/png");
        service.generateStory("A playful pet");
        assertRequestOptions(requests.get(0), "custom-vision-deployment", 300);
        assertRequestOptions(requests.get(1), "custom-vision-deployment", 800);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t\n"})
    void emptyDescriptionsDoNotSendRequests(String description) {
        assertThrows(IllegalArgumentException.class, () -> service.generateStory(description));
        assertTrue(requests.isEmpty());
    }

    @Test
    void longDescriptionsAreTruncatedBeforeSending() {
        service.generateStory("a".repeat(1001));
        assertEquals("Write a fun short story about a pet described as: " + "a".repeat(1000),
                requests.get(0).path("messages").get(1).path("content").asString());
    }

    @Test
    void imageDescriptionsFitTheStoryFormLimit() {
        respondWithContent("a".repeat(1001));
        assertEquals(1000, service.analyzeImage(PNG, "image/png").length());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t\n"})
    void emptyContentFailsBothCalls(String content) {
        respondWithContent(content);
        assertModelFailure(() -> service.analyzeImage(PNG, "image/png"), "Empty content");
        assertModelFailure(() -> service.generateStory("A playful pet"), "Empty content");
        assertEquals(2, requests.size());
    }

    @Test
    void emptyChoicesFailBothCalls() {
        responseBody = mapper.writeValueAsBytes(Map.of("id", "offline", "object", "chat.completion",
                "created", 1, "model", "gpt-5.6-luna", "choices", List.of()));
        assertModelFailure(() -> service.analyzeImage(PNG, "image/png"), "Empty response");
        assertModelFailure(() -> service.generateStory("A playful pet"), "Empty response");
    }

    @ParameterizedTest
    @ValueSource(ints = {400, 429, 500})
    void upstreamErrorsRetainTheirCauseForBothCalls(int status) {
        responseStatus = status;
        responseBody = mapper.writeValueAsBytes(Map.of("error", Map.of(
                "message", "Offline upstream failure", "type", "server_error", "code", "offline_failure")));
        RuntimeException imageFailure = assertThrows(RuntimeException.class,
                () -> service.analyzeImage(PNG, "image/png"));
        RuntimeException storyFailure = assertThrows(RuntimeException.class,
                () -> service.generateStory("A playful pet"));
        assertEquals(status, assertInstanceOf(OpenAIServiceException.class, imageFailure.getCause()).statusCode());
        assertEquals(status, assertInstanceOf(OpenAIServiceException.class, storyFailure.getCause()).statusCode());
        assertEquals(2, requests.size());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"text/plain", "image/svg+xml", "application/octet-stream"})
    void unsupportedImageTypesDoNotSendRequests(String contentType) {
        assertThrows(IllegalArgumentException.class, () -> service.analyzeImage(PNG, contentType));
        assertTrue(requests.isEmpty());
    }

    @Test
    void emptyAndOversizedImagesDoNotSendRequests() {
        assertThrows(IllegalArgumentException.class, () -> service.analyzeImage(null, "image/png"));
        assertThrows(IllegalArgumentException.class, () -> service.analyzeImage(new byte[0], "image/png"));
        assertThrows(IllegalArgumentException.class,
                () -> service.analyzeImage(new byte[10 * 1024 * 1024 + 1], "image/png"));
        assertTrue(requests.isEmpty());
    }

    private void respondWithContent(String content) {
        Map<String, String> message = content == null
                ? Map.of("role", "assistant") : Map.of("role", "assistant", "content", content);
        responseBody = mapper.writeValueAsBytes(Map.of("id", "offline", "object", "chat.completion",
                "created", 1, "model", "gpt-5.6-luna", "choices", List.of(Map.of(
                        "index", 0, "finish_reason", "stop", "message", message))));
    }

    private void assertRequestOptions(JsonNode request, String model, int tokenLimit) {
        assertEquals(model, request.path("model").asString());
        assertEquals("none", request.path("reasoning_effort").asString());
        assertEquals(tokenLimit, request.path("max_completion_tokens").asInt());
        assertFalse(request.has("max_tokens"));
        assertFalse(request.has("temperature"));
    }

    private void assertModelFailure(org.junit.jupiter.api.function.Executable call, String message) {
        RuntimeException failure = assertThrows(RuntimeException.class, call);
        assertNotNull(failure.getCause());
        assertTrue(failure.getCause().getMessage().contains(message));
    }
}
