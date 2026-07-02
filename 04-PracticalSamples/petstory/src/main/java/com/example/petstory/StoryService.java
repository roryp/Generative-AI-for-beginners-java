package com.example.petstory;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.credential.BearerTokenCredential;
import com.openai.models.chat.completions.*;
import com.azure.identity.AuthenticationUtil;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * Service class that handles story generation using Azure AI Foundry via the OpenAI SDK.
 * This service communicates with an Azure AI Foundry model to generate creative,
 * family-friendly pet stories based on user descriptions.
 */
@Service
public class StoryService {

    private static final Logger logger = LoggerFactory.getLogger(StoryService.class);
    private final OpenAIClient openAIClient;
    private final String modelName;

    public StoryService(@Value("${azure.openai.endpoint:}") String endpoint,
                       @Value("${azure.openai.deployment:gpt-4o-mini}") String modelName) {
        this.modelName = modelName;

        if (endpoint == null || endpoint.isBlank()) {
            endpoint = System.getenv("AZURE_OPENAI_ENDPOINT");
        }
        if (endpoint == null || endpoint.isBlank()) {
            throw new IllegalStateException(
                    "Set AZURE_OPENAI_ENDPOINT to your Azure AI Foundry endpoint. Provision it with 'azd up' "
                            + "(see 02-SetupDevEnvironment) and sign in with 'az login' (keyless auth).");
        }

        // Foundry's OpenAI-compatible endpoint lives under /openai/v1/.
        String baseUrl = (endpoint.endsWith("/") ? endpoint : endpoint + "/") + "openai/v1/";

        // Keyless authentication with Microsoft Entra ID (no API key).
        // DefaultAzureCredential uses your 'az login' session locally, or a managed identity in Azure.
        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();
        this.openAIClient = OpenAIOkHttpClient.builder()
                .baseUrl(baseUrl)
                .credential(BearerTokenCredential.create(
                        AuthenticationUtil.getBearerTokenSupplier(credential, "https://ai.azure.com/.default")))
                .build();

        logger.info("StoryService initialized with Azure AI Foundry endpoint: {} and deployment: {}", baseUrl, modelName);
    }

    public String generateStory(String description) {
        if (description == null || description.trim().isEmpty()) {
            logger.warn("Empty or null description provided");
            throw new IllegalArgumentException("Description cannot be empty");
        }
        
        if (description.length() > 1000) {
            logger.warn("Description too long, truncating: {} characters", description.length());
            description = description.substring(0, 1000);
        }
        
        try {
            logger.debug("Generating story for description: {}", description);
            
            String systemPrompt = "You are a creative storyteller who writes fun, family-friendly short stories about pets. " +
                                "Keep stories under 500 words and appropriate for all ages.";
            
            String userPrompt = "Write a fun short story about a pet described as: " + description;
            
            ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                    .model(modelName)
                    .addSystemMessage(systemPrompt)
                    .addUserMessage(userPrompt)
                    .maxCompletionTokens(800)
                    .temperature(0.8)
                    .build();

            logger.debug("Sending request to Azure AI Foundry for story generation");
            ChatCompletion response = openAIClient.chat().completions().create(params);
            
            if (response.choices().isEmpty()) {
                logger.error("Empty response received from the model");
                throw new RuntimeException("Empty response from the Azure AI Foundry model");
            }
            
            String result = response.choices().get(0).message().content().orElse("");
            
            if (result.trim().isEmpty()) {
                logger.error("Empty content received from the model");
                throw new RuntimeException("Empty content from the Azure AI Foundry model");
            }
            
            logger.debug("Generated story of length: {}", result.length());
            return result.trim();
            
        } catch (Exception e) {
            logger.error("Error generating story for description: {}", description, e);
            throw new RuntimeException("Failed to generate story: " + e.getMessage(), e);
        }
    }
}
