package com.example.genai.techniques.completions;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.*;
import com.azure.core.credential.AccessToken;
import com.azure.core.credential.TokenCredential;
import com.azure.core.credential.TokenRequestContext;

import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LLM Completions Example
 * 
 * This example demonstrates core generative AI techniques using large language models
 * including basic completions, multi-turn conversations, and interactive chat.
 * 
 * Features:
 * - Simple text completion
 * - Multi-turn conversation management
 * - Interactive chat with conversation history
 * - Token and temperature configuration
 */
public class LLMCompletionsApp {
    // Define the model once to use consistently across all examples
    // gpt-4.1-nano is a cost-effective model good for learning and experimentation
    private static final String MODEL = "gpt-4.1-nano";
    
    public static void main(String[] args) {
        // GitHub Models endpoint - provides free access to various AI models for learning
        String endpoint = "https://models.inference.ai.azure.com";
        // PAT = Personal Access Token - this authenticates us with GitHub Models
        String pat = System.getenv("GITHUB_TOKEN");
        
        if (pat == null || pat.isBlank()) {
            System.err.println("Please set GITHUB_TOKEN environment variable");
            System.err.println("Get your token from: https://github.com/settings/tokens");
            System.exit(1);
        }

        try {
            // Create the OpenAI client using Azure's SDK
            // This client will handle all our communication with the AI model
            OpenAIClient client = new OpenAIClientBuilder()
                    .endpoint(endpoint)
                    .credential(new StaticTokenCredential(pat)) // Custom credential class (defined below)
                    .buildClient();

            // Example 1: Simple completion
            simpleCompletion(client);
            
            // Example 2: Multi-turn conversation
            multiTurnChat(client);
            
            // Example 3: Interactive chat
            interactiveChat(client);

            // Force proper cleanup to avoid thread lingering warnings
            System.exit(0);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Demonstrates simple text completion with system prompts
     */
    private static void simpleCompletion(OpenAIClient client) {
        System.out.println("\n=== Simple Completion ===");
        
        // Create a conversation with two types of messages:
        // 1. System message: Sets the AI's personality and behavior
        // 2. User message: The actual question or prompt we want answered
        List<ChatRequestMessage> messages = List.of(
            new ChatRequestSystemMessage("You are a concise Java expert who explains concepts clearly and practically."),
            new ChatRequestUserMessage("Explain Java streams in one paragraph with a simple example.")
        );
        
        // Configure the AI's response behavior
        ChatCompletionsOptions options = new ChatCompletionsOptions(messages)
            .setModel(MODEL)
            .setMaxTokens(200)        // Limit response length (1 token ≈ 0.75 words)
            .setTemperature(0.7);     // Controls creativity: 0.0=focused, 1.0=creative
            
        try {
            // Send the request to the AI model and get the response
            ChatCompletions response = client.getChatCompletions(MODEL, options);
            // Extract the actual text content from the AI's response
            // getChoices().get(0) gets the first (and usually only) response option
            System.out.println("AI: " + response.getChoices().get(0).getMessage().getContent());
        } catch (Exception e) {
            System.err.println("Simple completion failed: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates multi-turn conversation with conversation history
     */
    private static void multiTurnChat(OpenAIClient client) {
        System.out.println("\n=== Multi-turn Conversation ===");
        
        // Use ArrayList so we can add messages as the conversation progresses
        // This maintains the conversation context - the AI remembers previous messages
        List<ChatRequestMessage> messages = new ArrayList<>();
        messages.add(new ChatRequestSystemMessage("You are a helpful Java tutor who provides clear explanations and examples."));
        messages.add(new ChatRequestUserMessage("What is a HashMap in Java?"));
        
        try {
            // First turn - ask initial question
            ChatCompletionsOptions options = new ChatCompletionsOptions(messages)
                .setModel(MODEL)
                .setMaxTokens(300);
                
            ChatCompletions response = client.getChatCompletions(MODEL, options);
            String firstResponse = response.getChoices().get(0).getMessage().getContent();
            System.out.println("AI: " + firstResponse);
            
            // CRITICAL: Add AI's response to conversation history
            // This is how the AI remembers what it said before
            messages.add(new ChatRequestAssistantMessage(firstResponse));
            messages.add(new ChatRequestUserMessage("How is HashMap different from TreeMap? Give me a practical example."));
            
            // Second turn - the AI now knows the context from the first question
            options = new ChatCompletionsOptions(messages)
                .setModel(MODEL)
                .setMaxTokens(400);
                
            response = client.getChatCompletions(MODEL, options);
            System.out.println("\nAI: " + response.getChoices().get(0).getMessage().getContent());
            
        } catch (Exception e) {
            System.err.println("Multi-turn chat failed: " + e.getMessage());
        }
    }
    
    /**
     * Interactive chat session with user input
     */
    private static void interactiveChat(OpenAIClient client) {
        System.out.println("\n=== Interactive Chat (type 'exit' to quit) ===");
        
        List<ChatRequestMessage> messages = new ArrayList<>();
        messages.add(new ChatRequestSystemMessage("You are a friendly and helpful AI assistant specializing in programming and technology."));
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            while (true) {
                System.out.print("\nYou: ");
                String input = scanner.nextLine();
                
                // Check if user wants to exit the chat
                if ("exit".equalsIgnoreCase(input.trim())) {
                    System.out.println("Goodbye!");
                    break;
                }
                
                // Skip empty inputs to avoid wasting API calls
                if (input.trim().isEmpty()) {
                    continue;
                }
                
                // Add user's message to the ongoing conversation
                messages.add(new ChatRequestUserMessage(input));
                
                ChatCompletionsOptions options = new ChatCompletionsOptions(messages)
                    .setModel(MODEL)
                    .setMaxTokens(500)
                    .setTemperature(0.8);   // Slightly higher creativity for chat
                    
                ChatCompletions response = client.getChatCompletions(MODEL, options);
                String aiResponse = response.getChoices().get(0).getMessage().getContent();
                
                System.out.println("AI: " + aiResponse);
                // Important: Add AI's response to maintain conversation context
                messages.add(new ChatRequestAssistantMessage(aiResponse));
                
                // Memory management: Prevent token limit overflow
                // Most AI models have limits on total conversation length
                if (messages.size() > 20) {
                    // Keep system message and last 18 messages to maintain recent context
                    List<ChatRequestMessage> trimmedMessages = new ArrayList<>();
                    trimmedMessages.add(messages.get(0)); // System message
                    trimmedMessages.addAll(messages.subList(messages.size() - 18, messages.size()));
                    messages = trimmedMessages;
                }
            }
        } catch (Exception e) {
            System.err.println("Interactive chat failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Custom implementation of TokenCredential for GitHub Models authentication.
     * This is a simplified version that just wraps our GitHub token.
     * In production, you'd use more sophisticated credential management.
     */
    private static final class StaticTokenCredential implements TokenCredential {
        private final String token;
        
        StaticTokenCredential(String token) {
            this.token = token;
        }

        @Override
        public Mono<AccessToken> getToken(TokenRequestContext tokenRequestContext) {
            // Return our token wrapped in an AccessToken object
            // OffsetDateTime.MAX means this token never expires (for demo purposes)
            return Mono.just(new AccessToken(token, OffsetDateTime.MAX));
        }
    }
}
