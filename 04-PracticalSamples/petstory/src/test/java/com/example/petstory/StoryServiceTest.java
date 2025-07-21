package com.example.petstory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the StoryService component.
 * Tests story generation functionality with various input scenarios including
 * valid descriptions, empty inputs, and null values. Uses conditional testing
 * to only run integration tests when GitHub Models service is available and
 * GITHUB_TOKEN is properly configured.
 * 
 * Note: Requires GITHUB_TOKEN environment variable with models:read scope
 * for the AI-powered story generation tests to execute successfully.
 */
@SpringBootTest
@TestPropertySource(properties = {
    "github.models.endpoint=https://models.github.ai/inference",
    "github.models.model=openai/gpt-4.1-nano"
})
class StoryServiceTest {

    @Autowired
    private StoryService storyService;

    @Test
    @EnabledIf("isGitHubModelsAvailable")
    void testGenerateStory() {
        // Given
        String description = "A playful golden retriever named Max";
        
        // When
        String story = storyService.generateStory(description);
        
        // Then
        assertNotNull(story);
        assertFalse(story.trim().isEmpty());
        assertTrue(story.length() > 50); // Should be a substantial story
        System.out.println("Generated story: " + story);
    }

    @Test
    void testGenerateStoryWithEmptyDescription() {
        // Given
        String emptyDescription = "";
        
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            storyService.generateStory(emptyDescription);
        });
    }

    @Test
    void testGenerateStoryWithNullDescription() {
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            storyService.generateStory(null);
        });
    }

    /**
     * Helper method to check if GitHub Models is available for conditional test execution
     */
    static boolean isGitHubModelsAvailable() {
        String githubToken = System.getenv("GITHUB_TOKEN");
        if (githubToken == null || githubToken.isBlank()) {
            System.out.println("GitHub Models not available for testing: GITHUB_TOKEN not set");
            return false;
        }
        
        try {
            // Try to create a simple client to validate token and connectivity
            java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
            java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                    .uri(java.net.URI.create("https://models.github.ai/inference"))
                    .timeout(java.time.Duration.ofSeconds(10))
                    .header("Authorization", "Bearer " + githubToken)
                    .GET()
                    .build();
            
            java.net.http.HttpResponse<String> response = client.send(request, 
                    java.net.http.HttpResponse.BodyHandlers.ofString());
            return response.statusCode() != 401 && response.statusCode() != 403;
        } catch (Exception e) {
            System.out.println("GitHub Models not available for testing: " + e.getMessage());
            return false;
        }
    }
}
