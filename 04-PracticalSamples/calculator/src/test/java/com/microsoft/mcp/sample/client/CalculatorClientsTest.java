package com.microsoft.mcp.sample.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.mcp.sample.server.McpServerApplication;
import com.openai.client.OpenAIClient;
import com.openai.credential.BearerTokenCredential;
import com.sun.net.httpserver.HttpServer;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.transport.http.StreamableHttpMcpTransport;
import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientStreamableHttpTransport;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = McpServerApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {"server.address=127.0.0.1", "spring.main.banner-mode=off"})
class CalculatorClientsTest {

    @Value("${local.server.port}")
    private int port;

    @Test
    void healthAndInfoAdvertiseTheStreamableEndpoint() throws Exception {
        try (var client = HttpClient.newHttpClient()) {
            for (String path : List.of("/health", "/info")) {
                var response = client.send(HttpRequest.newBuilder(URI.create("http://127.0.0.1:" + port + path))
                    .timeout(Duration.ofSeconds(10)).GET().build(), HttpResponse.BodyHandlers.ofString());
                assertThat(response.statusCode()).isEqualTo(200);
                JsonNode body = new ObjectMapper().readTree(response.body());
                if ("/health".equals(path)) {
                    assertThat(body.path("status").asText()).isEqualTo("UP");
                } else {
                    assertThat(body.path("endpoint").asText()).isEqualTo("/mcp");
                    assertThat(body.path("availableTools").size()).isEqualTo(9);
                }
            }
        }
    }

    @Test
    void sdkClientDiscoversAndExecutesEveryTool() {
        var buffer = new ByteArrayOutputStream();
        try (var output = new PrintStream(buffer, true, StandardCharsets.UTF_8)) {
            new SDKClient(transport()).run(output);
        }
        String output = buffer.toString(StandardCharsets.UTF_8);
        assertThat(output).contains("Available Tools", "5.00 + 3.00 = 8.00", "10.00 - 4.00 = 6.00",
            "6.00 * 7.00 = 42.00", "20.00 / 4.00 = 5.00", "2.00 ^ 8.00 = 256.00",
            "16.00 = 4.00", "17.00 % 5.00 = 2.00", "|-5.50| = 5.50", "Basic Calculator MCP Service");
    }

    @Test
    void protocolReturnsDomainErrors() {
        try (var client = McpClient.sync(transport()).requestTimeout(Duration.ofSeconds(10)).build()) {
            client.initialize();
            var result = client.callTool(CallToolRequest.builder("divide")
                .arguments(Map.of("a", 1, "b", 0)).build());
            assertThat(result.content().toString()).contains("Cannot divide by zero");
            var squareRoot = client.callTool(CallToolRequest.builder("squareRoot")
                .arguments(Map.of("number", -1)).build());
            assertThat(squareRoot.content().toString()).contains("negative number");
        }
    }

    @Test
    void missingToolsAndProtocolErrorsAreNotSilentlyAccepted() {
        assertThrows(IllegalStateException.class, () -> SDKClient.requireCalculatorTools(Set.of("add")));
        var client = mock(McpSyncClient.class);
        when(client.callTool(any(CallToolRequest.class)))
            .thenReturn(CallToolResult.builder().isError(true).addTextContent("tool failed").build());
        assertThrows(IllegalStateException.class,
            () -> SDKClient.printResult(client, "add", Map.of("a", 1, "b", 2), System.out));
    }

    @Test
    void fullAiDemoExecutesToolsWithNoReasoningOnEveryRequest() throws Exception {
        try (var stub = new ChatStub(List.of(
                toolReply("add", Map.of("a", 24.5, "b", 17.3)), answerReply("41.8"),
                toolReply("squareRoot", Map.of("number", 144)), answerReply("12"),
                toolReply("help", Map.of()), answerReply("Eight arithmetic operations are available."),
                toolReply("power", Map.of("base", 2, "exponent", 8)),
                toolReply("divide", Map.of("a", 256, "b", 4)), answerReply("64")))) {
            String output = runAi(stub, LangChain4jClient.parseOptions(new String[] {"--demo"}, false), "");
            assertThat(output).contains("AI: 41.8", "AI: 12", "AI: 64", "Tool executed: add",
                "Tool executed: squareRoot", "Tool executed: help", "Tool executed: power", "Tool executed: divide");
            assertThat(stub.requests).hasSize(9);
            assertNoReasoning(stub);
            assertThat(stub.requests.get(1).path("messages").toString()).contains("41.80");
            assertThat(stub.requests.get(7).path("messages").toString()).contains("256.00");
            assertThat(stub.requests.get(8).path("messages").toString()).contains("256.00 / 4.00 = 64.00");
            assertThat(stub.authorizations).containsExactly("Bearer offline-1", "Bearer offline-2", "Bearer offline-3",
                "Bearer offline-4", "Bearer offline-5", "Bearer offline-6", "Bearer offline-7", "Bearer offline-8",
                "Bearer offline-9");
        }
    }

    @Test
    void interactiveBotUsesTheRealToolLoopAndExits() throws Exception {
        try (var stub = new ChatStub(List.of(toolReply("multiply", Map.of("a", 6, "b", 7)), answerReply("42")))) {
            String output = runAi(stub, LangChain4jClient.parseOptions(new String[0], true),
                "\nMultiply 6 by 7\nexit\nignored\n");
            assertThat(output).contains("Tool executed: multiply", "AI: 42").doesNotContain("ignored");
            assertThat(stub.requests).hasSize(2);
            assertThat(stub.requests.get(1).path("messages").toString()).contains("6.00 * 7.00 = 42.00");
            assertNoReasoning(stub);
        }
    }

    @Test
    void smokeTestFailsWhenTheModelSkipsTools() throws Exception {
        try (var stub = new ChatStub(List.of(answerReply("8")))) {
            var failure = assertThrows(IllegalStateException.class, () -> runAi(stub,
                LangChain4jClient.parseOptions(new String[] {"--prompt", "Add 5 and 3"}, true), ""));
            assertThat(failure).hasMessageContaining("without executing a calculator tool");
            assertThat(stub.requests).hasSize(1);
        }
    }

    @Test
    void quotaErrorsFailWithoutAutomaticRetries() throws Exception {
        try (var stub = new ChatStub(List.of(new Reply(429,
                Map.of("error", Map.of("message", "offline quota exhausted", "type", "rate_limit_exceeded",
                    "code", "rate_limit_exceeded")))))) {
            var failure = assertThrows(RuntimeException.class, () -> runAi(stub,
                LangChain4jClient.parseOptions(new String[] {"--prompt", "Add 5 and 3"}, false), ""));
            assertThat(failure).hasMessageContaining("429");
            assertThat(stub.requests).hasSize(1);
        }
    }

    private static void assertNoReasoning(ChatStub stub) {
        for (JsonNode request : stub.requests) {
            assertThat(request.path("model").asText()).isEqualTo("gpt-5.6-luna");
            assertThat(request.path("reasoning_effort").asText()).isEqualTo("none");
            assertThat(request.path("max_completion_tokens").asInt()).isEqualTo(1024);
            assertThat(request.has("max_tokens")).isFalse();
            assertThat(request.has("temperature")).isFalse();
            assertThat(request.path("tools").size()).isEqualTo(9);
        }
    }

    private String runAi(ChatStub stub, LangChain4jClient.RunOptions options, String input) throws Exception {
        OpenAIClient openAiClient = LangChain4jClient.createOpenAiClient(stub.endpoint(),
            BearerTokenCredential.create(() -> "offline-" + stub.tokenRequests.incrementAndGet()));
        var buffer = new ByteArrayOutputStream();
        try (var transport = new StreamableHttpMcpTransport.Builder().url("http://127.0.0.1:" + port + "/mcp")
                 .timeout(Duration.ofSeconds(10)).build();
             var mcpClient = new DefaultMcpClient.Builder().transport(transport)
                 .initializationTimeout(Duration.ofSeconds(10)).toolExecutionTimeout(Duration.ofSeconds(10)).build();
             var reader = new BufferedReader(new StringReader(input));
             var output = new PrintStream(buffer, true, StandardCharsets.UTF_8)) {
            Bot bot = LangChain4jClient.createBot(LangChain4jClient.createModel(openAiClient, Map.of()), mcpClient, output);
            LangChain4jClient.runConversation(bot, options, reader, output);
            return buffer.toString(StandardCharsets.UTF_8);
        } finally {
            openAiClient.close();
        }
    }

    private static Reply toolReply(String name, Map<String, Object> arguments) throws Exception {
        return completionReply(Map.of("role", "assistant", "tool_calls", List.of(Map.of(
            "id", "call_" + name, "type", "function", "function", Map.of("name", name,
                "arguments", new ObjectMapper().writeValueAsString(arguments))))), "tool_calls");
    }

    private static Reply answerReply(String answer) {
        return completionReply(Map.of("role", "assistant", "content", answer), "stop");
    }

    private static Reply completionReply(Map<String, Object> message, String finishReason) {
        return new Reply(200, Map.of("id", "chatcmpl-offline", "object", "chat.completion", "created", 1,
            "model", "gpt-5.6-luna", "choices", List.of(Map.of("index", 0, "message", message, "finish_reason", finishReason)),
            "usage", Map.of("prompt_tokens", 10, "completion_tokens", 5, "total_tokens", 15)));
    }

    private record Reply(int status, Map<String, Object> body) { }

    private static final class ChatStub implements AutoCloseable {
        private final HttpServer server;
        private final Queue<Reply> replies;
        private final List<JsonNode> requests = new CopyOnWriteArrayList<>();
        private final List<String> authorizations = new CopyOnWriteArrayList<>();
        private final List<Exception> failures = new CopyOnWriteArrayList<>();
        private final AtomicInteger tokenRequests = new AtomicInteger();

        private ChatStub(List<Reply> replies) throws Exception {
            this.replies = new ConcurrentLinkedQueue<>(replies);
            server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
            server.createContext("/openai/v1/chat/completions", exchange -> {
                try (exchange) {
                    var mapper = new ObjectMapper();
                    requests.add(mapper.readTree(exchange.getRequestBody()));
                    authorizations.add(exchange.getRequestHeaders().getFirst("Authorization"));
                    Reply reply = this.replies.remove();
                    byte[] body = mapper.writeValueAsBytes(reply.body());
                    exchange.getResponseHeaders().set("Content-Type", "application/json");
                    exchange.sendResponseHeaders(reply.status(), body.length);
                    exchange.getResponseBody().write(body);
                } catch (Exception failure) {
                    failures.add(failure);
                }
            });
            server.start();
        }

        private String endpoint() {
            return "http://127.0.0.1:" + server.getAddress().getPort();
        }

        @Override
        public void close() {
            server.stop(0);
            assertThat(failures).as("loopback OpenAI handler failures").isEmpty();
            assertThat(replies).as("unused stub responses").isEmpty();
        }
    }

    private HttpClientStreamableHttpTransport transport() {
        return HttpClientStreamableHttpTransport.builder("http://127.0.0.1:" + port)
            .endpoint("/mcp").connectTimeout(Duration.ofSeconds(10)).build();
    }
}