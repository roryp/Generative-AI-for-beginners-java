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
 * to only run integration tests when an Azure AI Foundry endpoint is configured
 * and the user is signed in (keyless auth).
 *
 * Note: Requires the AZURE_OPENAI_ENDPOINT environment variable and 'az login'
 * for the AI-powered story generation tests to execute successfully.
 */
@SpringBootTest
@TestPropertySource(properties = {
    "azure.openai.deployment=gpt-4o-mini"
})
class StoryServiceTest {

    @Autowired
    private StoryService storyService;

    @Test
    @EnabledIf("isFoundryAvailable")
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
     * Helper method to check if an Azure AI Foundry endpoint is configured for
     * conditional test execution.
     */
    static boolean isFoundryAvailable() {
        String endpoint = System.getenv("AZURE_OPENAI_ENDPOINT");
        if (endpoint == null || endpoint.isBlank()) {
            System.out.println("Azure AI Foundry not available for testing: AZURE_OPENAI_ENDPOINT not set");
            return false;
        }
        return true;
    }
}
