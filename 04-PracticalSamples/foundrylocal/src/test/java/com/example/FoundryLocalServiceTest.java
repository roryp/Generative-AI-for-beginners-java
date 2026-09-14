package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FoundryLocalServiceTest {
    private static final String MODEL_ID = "Phi-4-mini-instruct-cuda-gpu:5";
    private static final String MODEL = """
            {"id":"%s","object":"model","created":0,"owned_by":"foundry-local"}
            """.formatted(MODEL_ID);
    private static final String ERROR = """
            {"error":{"message":"Model unavailable","type":"server_error","code":"server_error"}}
            """;

    private final ObjectMapper mapper = new ObjectMapper();
    private final AtomicReference<JsonNode> chatRequest = new AtomicReference<>();
    private final AtomicReference<String> chatMethod = new AtomicReference<>();
    private final AtomicInteger modelRequests = new AtomicInteger();
    private final AtomicInteger chatRequests = new AtomicInteger();
    private HttpServer server;
    private FoundryLocalService service;
    private String baseUrl;
    private volatile String modelsBody = "{\"object\":\"list\",\"data\":[" + MODEL + "]}";
    private volatile int modelsStatus = 200;
    private volatile String chatBody = completion("\"4\"");
    private volatile int chatStatus = 200;

    @BeforeEach
    void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/v1/models", exchange -> {
            modelRequests.incrementAndGet();
            respond(exchange, modelsStatus, modelsBody);
        });
        server.createContext("/v1/chat/completions", exchange -> {
            chatRequests.incrementAndGet();
            chatMethod.set(exchange.getRequestMethod());
            chatRequest.set(mapper.readTree(exchange.getRequestBody()));
            respond(exchange, chatStatus, chatBody);
        });
        server.start();
        baseUrl = "http://127.0.0.1:" + server.getAddress().getPort() + "/v1";
    }

    @AfterEach
    void stopServer() {
        if (service != null) {
            service.close();
        }
        server.stop(0);
    }

    @Test
    void discoversModelAndSendsOpenAiCompatibleRequest() {
        initialize("");

        assertThat(service.chat("What is 2 + 2?")).isEqualTo("4");
        assertThat(modelRequests.get()).isEqualTo(1);
        assertThat(chatRequests.get()).isEqualTo(1);
        assertThat(chatMethod.get()).isEqualTo("POST");
        JsonNode request = chatRequest.get();
        assertThat(request.path("model").asText()).isEqualTo(MODEL_ID);
        assertThat(request.at("/messages/0/role").asText()).isEqualTo("user");
        assertThat(request.at("/messages/0/content").asText()).isEqualTo("What is 2 + 2?");
        assertThat(request.path("max_tokens").asInt()).isEqualTo(150);
        assertThat(request.path("temperature").asDouble()).isZero();
    }

    @Test
    void explicitModelSkipsDiscoveryAndAcceptsTrailingSlash() {
        modelsStatus = 503;
        service = new FoundryLocalService(baseUrl + "/", "  " + MODEL_ID + "  ");
        service.init();

        assertThat(service.chat("Hello")).isEqualTo("4");
        assertThat(modelRequests.get()).isZero();
        assertThat(chatRequest.get().path("model").asText()).isEqualTo(MODEL_ID);
    }

    @Test
    void rejectsEmptyModelList() {
        modelsBody = "{\"object\":\"list\",\"data\":[]}";

        assertThatThrownBy(() -> initialize(""))
                .isInstanceOf(IllegalStateException.class).hasMessageContaining("No model found");
        assertThat(chatRequests.get()).isZero();
    }

    @Test
    void requiresExplicitChoiceForMultipleModels() {
        modelsBody = "{\"object\":\"list\",\"data\":[" + MODEL + ","
                + MODEL.replace(MODEL_ID, "qwen3-0.6b") + "]}";

        assertThatThrownBy(() -> initialize(""))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("More than one model").hasMessageContaining("foundry.local.model");
        assertThat(chatRequests.get()).isZero();
    }

    @Test
    void reportsDiscoveryHttpFailureWithoutRetries() {
        modelsStatus = 503;
        modelsBody = ERROR;

        assertThatThrownBy(() -> initialize(""))
                .isInstanceOf(IllegalStateException.class).hasMessageContaining(baseUrl + "/models")
                .hasCauseInstanceOf(RuntimeException.class);
        assertThat(modelRequests.get()).isEqualTo(1);
    }

    @Test
    void rejectsMalformedModelResponse() {
        modelsBody = "not-json";

        assertThatThrownBy(() -> initialize(""))
                .isInstanceOf(IllegalStateException.class).hasMessageContaining("Unable to list models");
    }

    @Test
    void reportsInferenceHttpFailureWithoutRetries() {
        initialize(MODEL_ID);
        chatStatus = 500;
        chatBody = ERROR;

        assertThatThrownBy(() -> service.chat("Hello"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(baseUrl).hasMessageContaining(MODEL_ID)
                .hasCauseInstanceOf(RuntimeException.class);
        assertThat(chatRequests.get()).isEqualTo(1);
    }

    @Test
    void rejectsMissingChoices() {
        initialize(MODEL_ID);
        chatBody = """
                {"id":"chatcmpl-local","object":"chat.completion","created":0,"model":"%s","choices":[]}
                """.formatted(MODEL_ID);

        assertThatThrownBy(() -> service.chat("Hello"))
                .isInstanceOf(IllegalStateException.class).hasMessageContaining("no response choices");
    }

    @ParameterizedTest
    @ValueSource(strings = {"null", "\"\"", "\"   \""})
    void rejectsMissingOrBlankText(String content) {
        initialize(MODEL_ID);
        chatBody = completion(content);

        assertThatThrownBy(() -> service.chat("Hello"))
                .isInstanceOf(IllegalStateException.class).hasMessageContaining("no response text");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\n"})
    void rejectsBlankPromptWithoutSendingRequest(String prompt) {
        initialize(MODEL_ID);

        assertThatThrownBy(() -> service.chat(prompt)).isInstanceOf(IllegalArgumentException.class);
        assertThat(chatRequests.get()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "https://example.openai.azure.com/v1",
            "https://api.openai.com/v1",
            "http://192.168.1.10:5273/v1",
            "http://127.0.0.1:5273",
            "http://127.0.0.1:5273/v1?api-key=unused",
            "http://user:unused@127.0.0.1:5273/v1"
    })
    void rejectsNonLocalOrInvalidEndpoints(String endpoint) {
        assertThatThrownBy(() -> new FoundryLocalService(endpoint, MODEL_ID))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("loopback HTTP URL");
    }

    @Test
    @ExtendWith(OutputCaptureExtension.class)
    void runnerPrintsActualResponseAndUsesConfiguredPrompt(CapturedOutput output) throws Exception {
        initialize(MODEL_ID);

        new Application().foundryLocalRunner(service, "Reply with four.").run();

        assertThat(output.getOut()).contains("Response from Foundry Local:", "4");
        assertThat(chatRequest.get().at("/messages/0/content").asText()).isEqualTo("Reply with four.");
    }

    @Test
    void runnerPropagatesInferenceFailure() {
        initialize(MODEL_ID);
        chatStatus = 500;
        chatBody = ERROR;

        assertThatThrownBy(() -> new Application().foundryLocalRunner(service, "Hello").run())
                .isInstanceOf(IllegalStateException.class).hasMessageContaining("Foundry Local request failed");
    }

        @Test
        @EnabledIfSystemProperty(named = "foundry.local.live", matches = "true")
        @ExtendWith(OutputCaptureExtension.class)
        void liveApplicationAnswersGroundedQuestion(CapturedOutput output) {
        String endpoint = System.getProperty("foundry.local.base-url");
        String modelId = System.getProperty("foundry.local.model");
        assertThat(endpoint).as("Set -Dfoundry.local.base-url to the running local server").isNotBlank();
        assertThat(modelId).as("Set -Dfoundry.local.model to the loaded local model ID").isNotBlank();

        Application.main(new String[] {
            "--foundry.local.base-url=" + endpoint,
            "--foundry.local.model=" + modelId,
            "--foundry.local.prompt=Read this fact: The capital of France is Paris. "
                + "Based only on that fact, what is the capital of France? Reply with only the city name."
        });

        assertThat(output.getOut())
            .contains("Foundry Local endpoint: " + endpoint, "Foundry Local model: " + modelId)
            .containsPattern("Response from Foundry Local:\\R\\s*Paris[.!]?\\s*\\R=+");
        }

    private void initialize(String model) {
        service = new FoundryLocalService(baseUrl, model);
        service.init();
    }

    private static String completion(String content) {
        return """
                {"id":"chatcmpl-local","object":"chat.completion","created":0,"model":"%s",
                 "choices":[{"index":0,"finish_reason":"stop","message":{"role":"assistant","content":%s}}]}
                """.formatted(MODEL_ID, content);
    }

    private static void respond(HttpExchange exchange, int status, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(status, bytes.length);
        try (var output = exchange.getResponseBody()) {
            output.write(bytes);
        }
    }
}