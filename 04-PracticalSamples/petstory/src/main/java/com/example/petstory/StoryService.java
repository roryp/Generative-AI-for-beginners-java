package com.example.petstory;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.chat.completions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * Service class that handles story generation using GitHub Models via OpenAI SDK.
 * This service communicates with GitHub Models to generate creative,
 * family-friendly pet stories based on user descriptions.
 */
@Service
public class StoryService {

    private static final Logger logger = LoggerFactory.getLogger(StoryService.class);
    private final OpenAIClient openAIClient;
    private final String modelName;

    public StoryService(@Value("${github.models.endpoint:https://models.github.ai/inference}") String endpoint,
                       @Value("${github.models.model:openai/gpt-4.1-nano}") String modelName) {
        this.modelName = modelName;
        
        String githubToken = System.getenv("GITHUB_TOKEN");
        if (githubToken == null || githubToken.isBlank()) {
            throw new IllegalStateException("GITHUB_TOKEN environment variable must be set with models:read scope");
        }
        
        this.openAIClient = OpenAIOkHttpClient.builder()
                .baseUrl(endpoint)
                .apiKey(githubToken)
                .build();
        
        logger.info("StoryService initialized with GitHub Models endpoint: {} and model: {}", endpoint, modelName);
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
                    .maxCompletionTokens(500)
                    .temperature(0.8)
                    .build();

            logger.debug("Sending request to GitHub Models for story generation");
            ChatCompletion response = openAIClient.chat().completions().create(params);
            
            if (response.choices().isEmpty()) {
                logger.error("Empty response received from GitHub Models");
                throw new RuntimeException("Empty response from GitHub Models service");
            }
            
            String result = response.choices().get(0).message().content().orElse("");
            
            if (result.trim().isEmpty()) {
                logger.error("Empty content received from GitHub Models");
                throw new RuntimeException("Empty content from GitHub Models service");
            }
            
            logger.debug("Generated story of length: {}", result.length());
            return result.trim();
            
        } catch (Exception e) {
            logger.error("Error generating story for description: {}", description, e);
            throw new RuntimeException("Failed to generate story: " + e.getMessage(), e);
        }
    }
}
