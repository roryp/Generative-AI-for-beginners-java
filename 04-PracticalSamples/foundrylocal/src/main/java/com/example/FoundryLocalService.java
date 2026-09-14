package com.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.models.Model;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.Duration;
import java.util.List;

/**
 * Calls Foundry Local's OpenAI-compatible REST API on this machine.
 */
@Service
public class FoundryLocalService implements AutoCloseable {
    private final String baseUrl;
    private final OpenAIClient openAIClient;
    private String model;

    /**
     * Creates a bounded, local-only client; no cloud credentials are needed.
     */
    public FoundryLocalService(
            @Value("${foundry.local.base-url:http://127.0.0.1:5273/v1}") String baseUrl,
            @Value("${foundry.local.model:}") String model) {
        this.baseUrl = validateBaseUrl(baseUrl);
        this.model = model == null ? "" : model.strip();
        this.openAIClient = OpenAIOkHttpClient.builder()
                .baseUrl(this.baseUrl)
                .apiKey("not-needed")
                .timeout(Duration.ofSeconds(120))
                .maxRetries(0)
                .build();
    }

    /**
     * Selects the advertised model when no explicit model ID was configured.
     */
    @PostConstruct
    public void init() {
        try {
            if (model.isBlank()) {
                model = detectModel();
            }
        } catch (RuntimeException failure) {
            close();
            throw failure;
        }

        System.out.println("Foundry Local endpoint: " + baseUrl);
        System.out.println("Foundry Local model: " + model);
    }

    private static String validateBaseUrl(String baseUrl) {
        URI endpoint = URI.create(baseUrl);
        String host = endpoint.getHost();
        boolean loopback = "127.0.0.1".equals(host)
                || "localhost".equalsIgnoreCase(host) || "[::1]".equals(host);
        if (!"http".equalsIgnoreCase(endpoint.getScheme()) || !loopback
                || endpoint.getUserInfo() != null || endpoint.getQuery() != null
                || endpoint.getFragment() != null
                || !("/v1".equals(endpoint.getPath()) || "/v1/".equals(endpoint.getPath()))) {
            throw new IllegalArgumentException(
                    "foundry.local.base-url must be a loopback HTTP URL ending in /v1, "
                    + "for example http://127.0.0.1:5273/v1. Cloud endpoints are not supported.");
        }
        return baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
    }

    private String detectModel() {
        List<Model> models;
        try {
            models = openAIClient.models().list().data();
        } catch (RuntimeException failure) {
            throw new IllegalStateException("Unable to list models at " + baseUrl
                    + "/models. Start the Foundry Local server and load a small local model.", failure);
        }
        if (models.isEmpty()) {
            throw new IllegalStateException("No model found at " + baseUrl
                    + ". Load a small local model before running this sample.");
        }
        if (models.size() != 1) {
            throw new IllegalStateException("More than one model is advertised at " + baseUrl
                    + ". Set foundry.local.model to the exact ID of your loaded local model.");
        }
        String detected = models.getFirst().id();
        if (detected.isBlank()) {
            throw new IllegalStateException("Foundry Local returned a blank model ID.");
        }
        return detected;
    }

    /**
     * Sends one prompt and returns nonblank text, or fails with local endpoint context.
     * Uses max_tokens because it is supported by Foundry Local's chat-completions API.
     */
    public String chat(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("The prompt must not be blank.");
        }
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)
                .addUserMessage(message)
                .maxTokens(150)
                .temperature(0.0)
                .build();

        ChatCompletion completion;
        try {
            completion = openAIClient.chat().completions().create(params);
        } catch (RuntimeException failure) {
            throw new IllegalStateException("Foundry Local request failed for model " + model
                    + " at " + baseUrl + ". Check that the model is loaded and fits in memory.", failure);
        }
        if (completion.choices().isEmpty()) {
            throw new IllegalStateException("Foundry Local returned no response choices.");
        }
        return completion.choices().getFirst().message().content()
                .filter(content -> !content.isBlank())
                .orElseThrow(() -> new IllegalStateException("Foundry Local returned no response text."));
    }

    /**
     * Releases the HTTP client's resources when the application exits.
     */
    @Override
    @PreDestroy
    public void close() {
        openAIClient.close();
    }
}
