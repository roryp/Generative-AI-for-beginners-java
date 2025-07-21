package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main application for demonstrating local AI model integration with Foundry Local.
 * 
 * This is a console application (not a web app) that shows how to:
 * 1. Connect to locally running AI models
 * 2. Send test messages and receive responses
 * 3. Handle errors when local services aren't available
 * 
 * Key Concepts:
 * - Console Application: Runs once, performs a task, then exits
 * - Local AI Integration: Uses AI models running on your machine
 * - Dependency Injection: Spring automatically provides the FoundryLocalService
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // Create Spring Application but configure it as a console app, not a web server
        SpringApplication app = new SpringApplication(Application.class);
        // NONE = console application (no web server, no HTTP ports)
        // This is perfect for AI demos that just run once and exit
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    /**
     * Creates a command line runner that tests our local AI connection.
     * 
     * Spring Boot Magic: The FoundryLocalService parameter is automatically injected!
     * Spring finds our @Service class and provides it here - no manual instantiation needed.
     * 
     * This runs after Spring Boot finishes starting up.
     */
    @Bean
    public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
        return args -> {
            System.out.println("=== Foundry Local Demo ===");
            System.out.println("Calling Foundry Local service...");

            try {
                // Send a test message that will help us identify which model is running
                // This is a good diagnostic message for local AI setups
                String testMessage = "Hello! Can you tell me what you are and what model you're running?";
                System.out.println("Sending message: " + testMessage);

                // Call our service, which connects to the local AI model
                // This demonstrates the same pattern you'd use in a real application
                String response = foundryLocalService.chat(testMessage);
                
                System.out.println("Response from Foundry Local:");
                System.out.println(response);
                System.out.println("=========================");
                
            } catch (Exception e) {
                // Handle common issues when connecting to local AI servers
                System.err.println("Error calling Foundry Local: " + e.getMessage());
                System.err.println("Troubleshooting checklist:");
                System.err.println("1. Is Foundry Local running on http://localhost:5273?");
                System.err.println("2. Is the AI model loaded and ready?");
                System.err.println("3. Check your application.properties for correct URL/model name");
                System.err.println("4. Verify you have enough RAM/GPU memory for the model");
                System.err.println("5. Look at the Foundry Local console for error messages");
                e.printStackTrace();
            }
        };
    }
}