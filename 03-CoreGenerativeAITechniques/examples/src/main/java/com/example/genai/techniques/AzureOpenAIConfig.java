package com.example.genai.techniques;

import com.azure.identity.AuthenticationUtil;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.credential.BearerTokenCredential;
import com.openai.models.ReasoningEffort;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

import java.net.URI;
import java.time.Duration;
import java.util.Map;

/** Shared Azure v1 configuration for the chapter's standalone examples. */
public record AzureOpenAIConfig(String endpoint, String chatDeployment, String embeddingDeployment) {
    /** Validates configuration without acquiring credentials or making requests. */
    public AzureOpenAIConfig {
        endpoint = normalizeEndpoint(endpoint);
        chatDeployment = deploymentOrDefault(chatDeployment, "gpt-5.6-luna");
        embeddingDeployment = deploymentOrDefault(embeddingDeployment, "text-embedding-3-small");
    }

    /** Reads deployment overrides and the required Azure resource endpoint. */
    public static AzureOpenAIConfig fromEnvironment() {
        return fromEnvironment(System.getenv());
    }

    static AzureOpenAIConfig fromEnvironment(Map<String, String> environment) {
        return new AzureOpenAIConfig(environment.get("AZURE_OPENAI_ENDPOINT"),
                environment.get("AZURE_OPENAI_DEPLOYMENT"),
                environment.get("AZURE_OPENAI_EMBEDDING_DEPLOYMENT"));
    }

    /** Creates a keyless client with token refresh, bounded timeout, and no automatic retries. */
    public OpenAIClient createClient() {
        return OpenAIOkHttpClient.builder()
                .baseUrl(endpoint)
                .credential(BearerTokenCredential.create(AuthenticationUtil.getBearerTokenSupplier(
                        new DefaultAzureCredentialBuilder().build(),
                        "https://cognitiveservices.azure.com/.default")))
                .timeout(Duration.ofSeconds(60))
                .maxRetries(0)
                .build();
    }

    /** Starts a chat request with the explicit settings supported by GPT-5.6 Luna. */
    public ChatCompletionCreateParams.Builder chatOptions(long maxCompletionTokens) {
        if (maxCompletionTokens <= 0) {
            throw new IllegalArgumentException("maxCompletionTokens must be positive");
        }
        return ChatCompletionCreateParams.builder()
                .model(chatDeployment)
                .reasoningEffort(ReasoningEffort.NONE)
                .maxCompletionTokens(maxCompletionTokens);
    }

    private static String deploymentOrDefault(String deployment, String fallback) {
        return deployment == null || deployment.isBlank() ? fallback : deployment.strip();
    }

    private static String normalizeEndpoint(String endpoint) {
        if (endpoint == null || endpoint.isBlank()) {
            throw new IllegalArgumentException("Set AZURE_OPENAI_ENDPOINT to your Azure OpenAI resource endpoint.");
        }
        URI uri;
        try {
            uri = URI.create(endpoint.strip());
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("AZURE_OPENAI_ENDPOINT must be a valid HTTPS resource URL.");
        }
        String path = uri.getPath() == null ? "" : uri.getPath().replaceAll("/+$", "");
        if (!"https".equalsIgnoreCase(uri.getScheme()) || uri.getHost() == null
                || uri.getUserInfo() != null || uri.getQuery() != null || uri.getFragment() != null
                || (!path.isEmpty() && !path.equals("/openai/v1"))) {
            throw new IllegalArgumentException(
                    "AZURE_OPENAI_ENDPOINT must be an HTTPS resource root or /openai/v1 URL, without credentials or query parameters.");
        }
        return "https://" + uri.getRawAuthority() + "/openai/v1";
    }
}