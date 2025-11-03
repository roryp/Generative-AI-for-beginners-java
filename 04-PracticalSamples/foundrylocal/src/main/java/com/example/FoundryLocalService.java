package com.example;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.chat.completions.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

/**
 * Service for connecting to locally running AI models via Foundry Local.
 * 
 * This demonstrates how to connect to AI models running on your own machine
 * instead of cloud services. Benefits include:
 * - No API costs - runs on your hardware
 * - Complete privacy - data never leaves your machine
 * - No internet dependency - works offline
 * - Full control over the model and its configuration
 * 
 * Key Spring Concepts:
 * - @Service: Makes this a Spring-managed component (singleton by default)
 * - @Value: Injects configuration values from application.properties
 * - @PostConstruct: Method runs automatically after Spring creates this object
 */
@Service
public class FoundryLocalService {
    
    // Configuration values injected from application.properties
    // The ":value" part provides a default if the property isn't set
    @Value("${foundry.local.base-url:http://localhost:5273}")
    private String baseUrl;  // Where your local AI server is running
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu}")
    private String model;    // Which local AI model to use
    
    // OpenAI client configured to talk to local server instead of OpenAI's servers
    private OpenAIClient openAIClient;
    
    /**
     * Initialize the OpenAI client to connect to local AI server.
     * 
     * @PostConstruct runs automatically after Spring creates this service.
     * This is better than constructor initialization because all @Value injections
     * are guaranteed to be completed before this method runs.
     */
    @PostConstruct
    public void init() {
        // Create OpenAI client but point it to local server instead of OpenAI
        // This works because local AI servers often implement OpenAI-compatible APIs
        System.out.println("Initializing Foundry Local client:");
        System.out.println("  Base URL: " + baseUrl);
        System.out.println("  Model: " + model);
        
        this.openAIClient = OpenAIOkHttpClient.builder()
                .baseUrl(baseUrl)                   // Local server endpoint (Foundry Local handles /v1 internally)
                .apiKey("not-needed")               // Local servers usually don't need real API keys
                .build();
        
        System.out.println("Client initialized successfully");
    }
    
    /**
     * Send a message to the local AI model and get a response.
     * 
     * This method demonstrates the same patterns you'd use with cloud AI services,
     * but everything runs locally on your machine.
     */
    public String chat(String message) {
        try {
            System.out.println("Creating chat completion request...");
            System.out.println("  Model: " + model);
            System.out.println("  Message: " + message);
            
            // Build the chat completion request
            // These parameters control how the AI responds
            ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                    .model(model)                    // Which local model to use
                    .addUserMessage(message)         // Your input message
                    .maxTokens(150)                  // Limit response length (saves processing time)
                    .temperature(0.7)                // Creativity level: 0.0=focused, 1.0=creative
                    .build();
            
            System.out.println("Sending request to Foundry Local...");
            
            // Send request to local AI server and wait for response
            // This uses the same API structure as cloud services for consistency
            ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
            
            System.out.println("Received response from Foundry Local");
            
            // Extract the AI's response from the API response structure
            // Local servers return the same format as cloud services
            if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
                return chatCompletion.choices().get(0).message().content().orElse("No response content found");
            }
            
            return "No response content found";
        } catch (Exception e) {
            // Common issues with local AI servers:
            // - Server not running (connection refused)
            // - Model not loaded (500 server error)
            // - Out of memory (GPU/RAM insufficient)
            // - Wrong model name (404 not found)
            // - Wrong API endpoint path (400 bad request)
            System.err.println("Detailed error information:");
            System.err.println("  Base URL: " + baseUrl);
            System.err.println("  Model: " + model);
            System.err.println("  Error type: " + e.getClass().getName());
            System.err.println("  Error message: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("  Cause: " + e.getCause().getMessage());
            }
            throw new RuntimeException("Error calling local AI model: " + e.getMessage() + 
                "\nCheck that your local AI server is running at: " + baseUrl +
                "\nTroubleshooting checklist:" +
                "\n1. Is Foundry Local running on " + baseUrl + "?" +
                "\n2. Is the AI model loaded and ready?" +
                "\n3. Check your application.properties for correct URL/model name" +
                "\n4. Verify you have enough RAM/GPU memory for the model" +
                "\n5. Look at the Foundry Local console for error messages", e);
        }
    }
}
