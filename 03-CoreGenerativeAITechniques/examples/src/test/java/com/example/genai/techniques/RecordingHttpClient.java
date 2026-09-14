package com.example.genai.techniques;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openai.client.OpenAIClient;
import com.openai.client.OpenAIClientImpl;
import com.openai.core.ClientOptions;
import com.openai.core.RequestOptions;
import com.openai.core.http.Headers;
import com.openai.core.http.HttpClient;
import com.openai.core.http.HttpRequest;
import com.openai.core.http.HttpResponse;
import com.openai.credential.BearerTokenCredential;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;

/** An in-memory SDK transport: unexpected requests fail and no sockets are opened. */
public final class RecordingHttpClient implements HttpClient {
    private static final ObjectMapper JSON = new ObjectMapper();
    private final Queue<Reply> replies = new ArrayDeque<>();
    private final List<JsonNode> requests = new ArrayList<>();
    private final List<String> urls = new ArrayList<>();

    public OpenAIClient client() {
        return new OpenAIClientImpl(ClientOptions.builder()
                .httpClient(this)
                .baseUrl("https://example.openai.azure.com/openai/v1")
                .credential(BearerTokenCredential.create(() -> "offline-test-token"))
                .maxRetries(0)
                .build());
    }

    public void enqueueChat(String text) {
        enqueueMessage("stop", Map.of("role", "assistant", "content", text));
    }

    public void enqueueMessage(String finishReason, Map<String, Object> message) {
        enqueueJson(200, json(Map.of("id", "test-completion", "object", "chat.completion",
                "created", 1, "model", "gpt-5.6-luna", "choices", List.of(
                        Map.of("index", 0, "finish_reason", finishReason, "message", message)))));
    }

    public void enqueueJson(int status, String body) {
        replies.add(new Reply(status, body));
    }

    public List<JsonNode> requests() {
        return List.copyOf(requests);
    }

    public List<String> urls() {
        return List.copyOf(urls);
    }

    public void assertExhausted() {
        assertTrue(replies.isEmpty(), "The example did not consume every expected response");
    }

    public static void assertChatOptions(JsonNode request, String deployment, long budget) {
        assertEquals(deployment, request.path("model").asText());
        assertEquals("none", request.path("reasoning_effort").asText());
        assertEquals(budget, request.path("max_completion_tokens").asLong());
        assertFalse(request.has("max_tokens"));
        assertFalse(request.has("temperature"));
        assertFalse(request.has("top_p"));
    }

    public static String json(Object value) {
        try {
            return JSON.writeValueAsString(value);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    @Override
    public HttpResponse execute(HttpRequest request, RequestOptions options) {
        var body = new ByteArrayOutputStream();
        request.body().writeTo(body);
        try {
            requests.add(JSON.readTree(body.toByteArray()));
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
        urls.add(request.url());
        var reply = replies.poll();
        if (reply == null) {
            throw new AssertionError("Unexpected SDK request: " + request.url());
        }
        return new HttpResponse() {
            private final InputStream content = new ByteArrayInputStream(reply.body().getBytes(StandardCharsets.UTF_8));

            @Override
            public int statusCode() {
                return reply.status();
            }

            @Override
            public Headers headers() {
                return Headers.builder().put("content-type", "application/json").build();
            }

            @Override
            public InputStream body() {
                return content;
            }

            @Override
            public void close() {
            }
        };
    }

    @Override
    public CompletableFuture<HttpResponse> executeAsync(HttpRequest request, RequestOptions options) {
        throw new AssertionError("These examples must use synchronous requests");
    }

    @Override
    public void close() {
    }

    private record Reply(int status, String body) {
    }
}