package com.example.genai.techniques;

import com.openai.models.ReasoningEffort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AzureOpenAIConfigTest {
    @ParameterizedTest
    @ValueSource(strings = {"https://example.openai.azure.com", "https://example.openai.azure.com/",
            " https://example.openai.azure.com/// ", "https://example.openai.azure.com/openai/v1",
            "https://example.openai.azure.com/openai/v1/"})
    void normalizesResourceRootsAndAlreadyNormalizedEndpoints(String endpoint) {
        var config = new AzureOpenAIConfig(endpoint, null, null);
        assertEquals("https://example.openai.azure.com/openai/v1", config.endpoint());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "not a url", "http://example.openai.azure.com", "/openai/v1",
            "https://user:password@example.openai.azure.com", "https://example.openai.azure.com?api-key=secret",
            "https://example.openai.azure.com/#fragment", "https://example.openai.azure.com/openai/deployments/demo"})
    void rejectsMissingOrUnsafeEndpoints(String endpoint) {
        assertThrows(IllegalArgumentException.class, () -> new AzureOpenAIConfig(endpoint, null, null));
    }

    @Test
    void usesLunaForChatAndAnEmbeddingModelForEmbeddings() {
        var config = AzureOpenAIConfig.fromEnvironment(Map.of(
                "AZURE_OPENAI_ENDPOINT", "https://example.openai.azure.com"));
        assertEquals("gpt-5.6-luna", config.chatDeployment());
        assertEquals("text-embedding-3-small", config.embeddingDeployment());
        var request = config.chatOptions(200).addUserMessage("Hello").build();
        assertEquals("gpt-5.6-luna", request.model().asString());
        assertEquals(ReasoningEffort.NONE, request.reasoningEffort().orElseThrow());
        assertEquals(200L, request.maxCompletionTokens().orElseThrow());
        assertTrue(request.maxTokens().isEmpty());
        assertTrue(request.temperature().isEmpty());
        assertTrue(request.topP().isEmpty());
    }

    @Test
    void honorsIndependentDeploymentOverridesAndBlankDefaults() {
        var config = AzureOpenAIConfig.fromEnvironment(Map.of(
                "AZURE_OPENAI_ENDPOINT", "https://example.openai.azure.com/",
                "AZURE_OPENAI_DEPLOYMENT", " custom-chat ",
                "AZURE_OPENAI_EMBEDDING_DEPLOYMENT", " custom-embedding "));
        assertEquals("custom-chat", config.chatOptions(300).addUserMessage("Hello").build().model().asString());
        assertEquals("custom-embedding", config.embeddingDeployment());
        var defaults = new AzureOpenAIConfig(config.endpoint(), " ", "");
        assertEquals("gpt-5.6-luna", defaults.chatDeployment());
        assertEquals("text-embedding-3-small", defaults.embeddingDeployment());
    }

    @Test
    void rejectsNonPositiveCompletionBudgets() {
        var config = new AzureOpenAIConfig("https://example.openai.azure.com", null, null);
        assertThrows(IllegalArgumentException.class, () -> config.chatOptions(0));
        assertThrows(IllegalArgumentException.class, () -> config.chatOptions(-1));
    }
}