package com.example;

import com.openai.credential.BearerTokenCredential;
import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.model.openai.autoconfigure.OpenAiChatProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

class BasicChatApplicationTest {

    @Test
    void sendsLunaWithoutReasoningOrLegacyTokenLimit() throws Exception {
        var environment = new StandardEnvironment();
        new YamlPropertySourceLoader().load("sample", new ClassPathResource("application.yml"))
                .forEach(source -> environment.getPropertySources().addLast(source));
        var properties = Binder.get(environment)
                .bind("spring.ai.openai.chat", OpenAiChatProperties.class).get();

        assertThat(properties.getReasoningEffort()).isEqualTo("none");
        assertThat(properties.getMaxCompletionTokens()).isEqualTo(500);
        assertThat(properties.getMaxTokens()).isNull();
        assertThat(properties.getTemperature()).isNull();

        var mapper = JsonMapper.builder().build();
        var request = new AtomicReference<JsonNode>();
        var authorization = new AtomicReference<String>();
        var apiKey = new AtomicReference<String>();
        var server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/openai/v1/chat/completions", exchange -> {
            request.set(mapper.readTree(exchange.getRequestBody()));
            authorization.set(exchange.getRequestHeaders().getFirst("Authorization"));
            apiKey.set(exchange.getRequestHeaders().getFirst("api-key"));
            byte[] response = """
                    {"id":"chatcmpl-test","object":"chat.completion","created":1,
                     "model":"gpt-5.6-luna","choices":[{"index":0,
                     "message":{"role":"assistant","content":"OK"},"finish_reason":"stop"}],
                     "usage":{"prompt_tokens":1,"completion_tokens":1,"total_tokens":2,
                     "completion_tokens_details":{"reasoning_tokens":0}}}
                    """.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length);
            try (var body = exchange.getResponseBody()) {
                body.write(response);
            }
        });
        server.start();
        var application = new BasicChatApplication();
        var client = application.azureOpenAiClient(BearerTokenCredential.create(() -> "test-only"),
                "http://127.0.0.1:" + server.getAddress().getPort() + "/");
        try {
            properties.setApiKey("must-not-use-this-key");
            properties.setMaxRetries(0);
            var model = application.azureChatModel(properties, client);
            assertThat(ChatClient.create(model).prompt("Hello").call().content()).isEqualTo("OK");
            assertThat(authorization.get()).isEqualTo("Bearer test-only");
            assertThat(apiKey.get()).isNull();
            assertThat(request.get().path("reasoning_effort").asText()).isEqualTo("none");
            assertThat(request.get().path("max_completion_tokens").asInt()).isEqualTo(500);
            assertThat(request.get().has("max_tokens")).isFalse();
            assertThat(request.get().has("temperature")).isFalse();
        } finally {
            client.close();
            server.stop(0);
        }
    }
}