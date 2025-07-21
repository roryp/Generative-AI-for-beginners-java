package com.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Basic Chat Application with Azure OpenAI
 * 
 * This is a simple end-to-end example that demonstrates:
 * 1. How to load environment variables from a .env file
 * 2. How to configure Spring Boot with Azure OpenAI
 * 3. How to create a ChatClient and send prompts
 * 4. How to receive and display responses
 * 
 * Key Spring Boot Concepts for Beginners:
 * - @SpringBootApplication: Main annotation that enables auto-configuration
 * - @Bean: Creates objects that Spring manages (dependency injection)
 * - CommandLineRunner: Runs code after Spring Boot starts up
 * 
 * This application will run once, send a prompt to Azure OpenAI,
 * display the response, and then exit.
 */
@SpringBootApplication
public class BasicChatApplication {

    public static void main(String[] args) {
        System.out.println("Starting Basic Chat with Azure OpenAI...");
        
        // Load environment variables from .env file if it exists
        // This approach works better with VS Code and various IDEs than relying on system env vars
        // .env files are easier to manage and don't affect your entire system
        loadEnvironmentVariables();
        
        // Start the Spring Boot application
        // Spring will automatically configure Azure OpenAI based on application.yml and env variables
        SpringApplication.run(BasicChatApplication.class, args);
    }
    
    /**
     * CommandLineRunner that executes after the Spring Boot application starts
     * This demonstrates a simple chat interaction with Azure OpenAI
     * 
     * Spring Boot Magic: The ChatClient.Builder parameter is automatically injected by Spring
     * based on the configuration in application.yml - you don't need to create it manually!
     */
    @Bean
    CommandLineRunner runner(ChatClient.Builder chatClientBuilder) {
        return args -> {
            System.out.println("Connecting to Azure OpenAI...");
            
            // Create ChatClient with default system message
            // System messages define the AI's personality and behavior for the entire conversation
            ChatClient chatClient = chatClientBuilder
                .defaultSystem("You are a helpful AI assistant. Provide clear, concise answers.")
                .build();
            
            // Send a test prompt to verify the connection works
            String prompt = "What is AI in a short sentence? Max 100 words.";
            System.out.println("Sending prompt: " + prompt);
            
            try {
                // Call Azure OpenAI and get response
                // This is the Spring AI way - much simpler than using raw HTTP calls!
                // .prompt() starts building a prompt
                // .user() adds the user's message
                // .call() sends the request and waits for response
                // .content() extracts just the text content from the AI response
                String response = chatClient.prompt()
                    .user(prompt)
                    .call()
                    .content();
                
                // Display the response with clear formatting
                System.out.println("\nAI Response:");
                System.out.println("================");
                System.out.println(response);
                System.out.println("================");
                System.out.println("\nSuccess! Azure OpenAI connection is working correctly.");
                
            } catch (Exception e) {
                // Handle common configuration and connection errors with helpful guidance
                System.err.println("\nError connecting to Azure OpenAI:");
                System.err.println("Error: " + e.getMessage());
                System.err.println("\nTroubleshooting tips:");
                System.err.println("1. Check that AZURE_AI_KEY is set in your .env file or environment variables");
                System.err.println("2. Verify AZURE_AI_ENDPOINT is set in your .env file or environment variables");
                System.err.println("3. Ensure your model deployment name is correct in application.yml");
                System.err.println("4. Confirm your Azure OpenAI resource is active and has quota available");
                System.err.println("5. Check that your .env file is in the project root directory");
                System.err.println("6. Verify your Azure OpenAI key hasn't expired");
            }
        };
    }
    /**
     * Load environment variables from .env file and set them as system properties
     * This ensures they're available to Spring Boot regardless of how the app is run
     * 
     * Why this matters for beginners:
     * - .env files keep secrets out of your code (never commit API keys!)
     * - Different environments (dev, test, prod) can have different .env files
     * - Much easier than setting system environment variables manually
     * - Works consistently across different operating systems and IDEs
     */
    private static void loadEnvironmentVariables() {
        try {
            // Create Dotenv loader with configuration
            // .directory(".") looks in the current directory (project root)
            // .ignoreIfMissing() won't crash if no .env file exists
            Dotenv dotenv = Dotenv.configure()
                .directory(".")
                .ignoreIfMissing()
                .load();
            
            // Set all .env variables as system properties so Spring can access them
            // Spring Boot automatically reads system properties for configuration
            dotenv.entries().forEach(entry -> {
                String key = entry.getKey();
                String value = entry.getValue();
                
                // Only set if not already defined (allows command line overrides)
                // This means you can still override via -D command line parameters
                if (System.getProperty(key) == null) {
                    System.setProperty(key, value);
                }
            });
            
            System.out.println("Environment variables loaded from .env file");
            
            // Show configuration status for debugging
            // This helps beginners see what's actually loaded
            String endpoint = dotenv.get("AZURE_AI_ENDPOINT");
            String apiKey = dotenv.get("AZURE_AI_KEY");
            
            System.out.println("Endpoint: " + (endpoint != null ? endpoint : "NOT SET"));
            System.out.println("API Key: " + (apiKey != null ? "SET (hidden for security)" : "NOT SET"));
            
            // Warn if critical configuration is missing
            if (endpoint == null || apiKey == null) {
                System.err.println("WARNING: Missing required environment variables!");
                System.err.println("   Please check your .env file has AZURE_AI_ENDPOINT and AZURE_AI_KEY");
                System.err.println("   Example .env file:");
                System.err.println("   AZURE_AI_ENDPOINT=https://your-resource.openai.azure.com/");
                System.err.println("   AZURE_AI_KEY=your-api-key-here");
            }
            
        } catch (Exception e) {
            // Fallback to system environment variables if .env file doesn't work
            System.out.println("No .env file found or error loading it");
            System.out.println("   Using system environment variables instead");
            
            // Check if system environment variables are available as backup
            String sysEndpoint = System.getenv("AZURE_AI_ENDPOINT");
            String sysApiKey = System.getenv("AZURE_AI_KEY");
            
            System.out.println("System Endpoint: " + (sysEndpoint != null ? sysEndpoint : "NOT SET"));
            System.out.println("System API Key: " + (sysApiKey != null ? "SET (hidden for security)" : "NOT SET"));
            
            if (sysEndpoint == null || sysApiKey == null) {
                System.err.println("WARNING: No environment variables found in system either!");
                System.err.println("   You need to either:");
                System.err.println("   1. Create a .env file in the project root, or");
                System.err.println("   2. Set AZURE_AI_ENDPOINT and AZURE_AI_KEY as system environment variables");
            }
        }
    }


}
