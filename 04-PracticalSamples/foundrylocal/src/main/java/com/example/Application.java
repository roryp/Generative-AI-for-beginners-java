package com.example;

import org.springframework.beans.factory.annotation.Value;
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
        app.run(args).close();
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
    public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService,
            @Value("${foundry.local.prompt:In one sentence, explain one benefit of running a small language model locally.}")
            String prompt) {
        return args -> {
            System.out.println("=== Foundry Local Demo ===");
            System.out.println("Sending message: " + prompt);
            String response = foundryLocalService.chat(prompt);
            System.out.println("Response from Foundry Local:");
            System.out.println(response);
            System.out.println("=========================");
        };
    }
}