package com.example.githubmodels;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

/**
 * Simple GitHub Models demonstration application.
 * 
 * This basic example shows how to connect to GitHub Models using OpenAI Java SDK
 * and send a simple chat completion request. It demonstrates the minimal setup required
 * to get started with GitHub Models for AI-powered applications.
 * 
 * Prerequisites:
 * - GITHUB_TOKEN environment variable must be set with a token that has models:read scope
 *   To set this: export GITHUB_TOKEN=your_actual_token_here (Linux/macOS)
 *   Or: set GITHUB_TOKEN=your_actual_token_here (Windows CMD)
 *   Or: $env:GITHUB_TOKEN="your_actual_token_here" (Windows PowerShell)
 */
public class App {
    public static void main(String[] args) {
        // Get GitHub Personal Access Token from environment variable
        // This token authenticates your requests to GitHub Models
        String pat = System.getenv("GITHUB_TOKEN");
        // Allow overriding the default model via environment variable
        // gpt-4.1-nano is a lightweight, fast model good for simple tasks
        String modelId = System.getenv().getOrDefault("GITHUB_MODEL", "gpt-4.1-nano");

        // Validate that the GitHub token is properly set
        // Without this token, you cannot access GitHub Models
        if (pat == null || pat.isBlank()) {
            throw new IllegalStateException("Set GITHUB_TOKEN to a token with models:read scope.");
        }

        System.out.println("Using model: " + modelId);

        try {
            // Create the OpenAI client configured for GitHub Models
            // This uses the OpenAI Java SDK but points to GitHub's endpoint
            OpenAIClient client = OpenAIOkHttpClient.builder()
                    .apiKey(pat)                                              // Your GitHub token for authentication
                    .baseUrl("https://models.inference.ai.azure.com")        // GitHub Models endpoint (not OpenAI's)
                    .build();

            // Build the chat completion request with two types of messages:
            // 1. System message: Sets the AI's behavior and personality
            // 2. User message: The actual prompt or question you want answered
            ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                    .model(modelId)                                          // Which AI model to use
                    .addSystemMessage("You are a concise assistant.")       // AI personality/instructions
                    .addUserMessage("Say Hello World!")                     // Your actual question/request
                    .build();

            System.out.println("Sending request to GitHub Models...");
            // Send the request to the AI model and wait for response
            // This is a synchronous call - your program waits until the AI responds
            ChatCompletion response = client.chat().completions().create(params);
            
            // Extract the AI's response from the API response structure
            // .choices().get(0) gets the first (and usually only) response option
            // .message().content() gets the actual text content of the response
            // .orElse() provides a fallback if no content is returned
            System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
        } catch (Exception e) {
            // Handle various types of errors that might occur
            System.err.println("Error occurred: " + e.getMessage());
            System.err.println("This might be due to:");
            System.err.println("1. Invalid model name: " + modelId);
            System.err.println("2. Invalid GitHub token or insufficient permissions");
            System.err.println("3. GitHub Models service unavailable");
            System.err.println("4. Network connectivity issues");
            System.err.println("5. Rate limiting (too many requests)");
            
            throw new RuntimeException("Failed to connect to GitHub Models", e);
        }
    }
}
