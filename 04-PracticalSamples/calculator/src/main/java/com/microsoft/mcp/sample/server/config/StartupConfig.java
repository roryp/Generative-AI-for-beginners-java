package com.microsoft.mcp.sample.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class that displays welcome and usage information at application startup.
 * 
 * This helps beginners understand:
 * - How their MCP server is configured
 * - What endpoints are available
 * - How to connect clients to the server
 * 
 * @Configuration tells Spring this class provides configuration beans
 * @Value injects properties from application.properties with default fallbacks
 */
@Configuration
public class StartupConfig {

    // Inject welcome message from properties, with a sensible default
    @Value("${calculator.service.welcome:Welcome to the Calculator MCP Service!}")
    private String welcomeMessage;
    
    // Optional usage message from properties
    @Value("${calculator.service.usage:}")
    private String usageMessage;
    
    /**
     * Display startup information when the application launches.
     * 
     * CommandLineRunner executes after Spring Boot completes startup.
     * This provides immediate feedback about the server's status and configuration.
     */
    @Bean
    public CommandLineRunner startupInfo() {
        return args -> {
            System.out.println("\n" + "=".repeat(80));
            System.out.println(welcomeMessage);
            System.out.println("=".repeat(80));
            
            if (usageMessage != null && !usageMessage.isEmpty()) {
                System.out.println("\nUsage Information:");
                System.out.println(usageMessage);
            }
            
            // Key information for beginners to connect their clients
            System.out.println("\nMCP Server Endpoints:");
            System.out.println("• Health Check: http://localhost:8080/health");
            System.out.println("• Service Info:  http://localhost:8080/info");
            System.out.println("• MCP Tools:     http://localhost:8080/v1/tools");
            System.out.println("• SSE Endpoint:  http://localhost:8080/sse");
            
            System.out.println("\nFor client examples, see:");
            System.out.println("• Direct MCP SDK: src/test/java/.../SDKClient.java");
            System.out.println("• LangChain4j:    src/test/java/.../LangChain4jClient.java");
            System.out.println("• Documentation:  README.MD");
            
            System.out.println("\nThe Calculator MCP service is now ready to accept tool calls!");
            System.out.println("=".repeat(80) + "\n");
        };
    }
}
