package com.microsoft.mcp.sample.client;

import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.McpClient;
import dev.langchain4j.mcp.client.transport.McpTransport;
import dev.langchain4j.mcp.client.transport.http.HttpMcpTransport;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.tool.ToolProvider;

import java.time.Duration;
import java.util.List;

/**
 * LangChain4j MCP Client Example
 * 
 * This demonstrates the power of combining AI models with MCP tools.
 * Unlike the SDKClient which requires explicit tool calls, this approach:
 * 
 * 1. Uses natural language prompts (like talking to a human)
 * 2. AI decides WHEN to call tools based on the conversation context
 * 3. AI decides WHICH tools to call and with WHAT parameters
 * 4. AI incorporates tool results into natural language responses
 * 
 * This is much more user-friendly and powerful than direct tool calling!
 * 
 * Key Learning Points:
 * - AI models can "reason" about when tools are needed
 * - No need to specify exact tool parameters - AI figures them out
 * - Results are automatically incorporated into conversational responses
 * - Same MCP server works with both direct calling and AI-mediated calling
 */
public class LangChain4jClient {

        /**
         * This example uses the calculator MCP server that provides basic calculator
         * operations. The AI model can automatically discover and use these tools
         * based on natural language requests.
         * 
         * Prerequisites:
         * 1. Start the calculator MCP server: run McpServerApplication
         * 2. Set GITHUB_TOKEN environment variable for GitHub Models access
         * 3. Ensure the server is running on localhost:8080
         * 
         * Watch the logs to see the AI model automatically calling calculator tools!
         */
        public static void main(String[] args) throws Exception {

                // Configure AI model - using GitHub Models (free tier)
                // You could also use OpenAI directly, Anthropic, or local models
                ChatLanguageModel model = OpenAiOfficialChatModel.builder()
                                .isGitHubModels(true)                           // Use GitHub's free AI models
                                .apiKey(System.getenv("GITHUB_TOKEN"))          // GitHub PAT for authentication
                                .timeout(Duration.ofSeconds(60))               // Allow time for complex calculations
                                .modelName("gpt-4o-mini")                       // Efficient model good for tool use
                                .build();

                // Configure MCP transport to connect to our calculator server
                // HTTP transport with Server-Sent Events for real-time communication
                McpTransport transport = new HttpMcpTransport.Builder()
                                .sseUrl("http://localhost:8080/sse")            // Our MCP server's SSE endpoint
                                .timeout(Duration.ofSeconds(60))               // Connection timeout
                                .logRequests(true)                             // Debug: see MCP requests
                                .logResponses(true)                            // Debug: see MCP responses
                                .build();

                // Create MCP client that connects to our calculator server
                McpClient mcpClient = new DefaultMcpClient.Builder()
                                .transport(transport)
                                .build();

                // Create tool provider that makes MCP tools available to the AI model
                // This is the "bridge" between MCP and LangChain4j
                ToolProvider toolProvider = McpToolProvider.builder()
                                .mcpClients(List.of(mcpClient))                 // Connect to our calculator MCP server
                                .build();

                // Create AI service that combines the language model with MCP tools
                // AiServices automatically handles the complexity of:
                // - When to call tools vs. respond directly
                // - How to extract parameters from natural language
                // - How to incorporate tool results into responses
                Bot bot = AiServices.builder(Bot.class)
                                .chatLanguageModel(model)                       // The AI brain
                                .toolProvider(toolProvider)                    // The available tools
                                .build();

                try {
                        // Test natural language requests that require tool usage
                        // Notice: we don't specify which tools to use or what parameters!
                        
                        System.out.println("=== AI + MCP Calculator Demo ===\n");
                        
                        // Test 1: Basic arithmetic that requires tool calling
                        String response = bot.chat("Calculate the sum of 24.5 and 17.3 using the calculator service");
                        System.out.println("Human: Calculate the sum of 24.5 and 17.3 using the calculator service");
                        System.out.println("AI: " + response + "\n");

                        // Test 2: More complex operation
                        response = bot.chat("What's the square root of 144?");
                        System.out.println("Human: What's the square root of 144?");
                        System.out.println("AI: " + response + "\n");

                        // Test 3: Meta-request for help
                        response = bot.chat("Show me the help for the calculator service");
                        System.out.println("Human: Show me the help for the calculator service");
                        System.out.println("AI: " + response + "\n");
                        
                        // Test 4: Complex multi-step calculation
                        response = bot.chat("Calculate 2 to the power of 8, then divide the result by 4");
                        System.out.println("Human: Calculate 2 to the power of 8, then divide the result by 4");
                        System.out.println("AI: " + response + "\n");
                        
                        System.out.println("=== Demo Complete ===");
                        System.out.println("Notice how the AI automatically:");
                        System.out.println("1. Determined which tools to call");
                        System.out.println("2. Extracted the right parameters from natural language");
                        System.out.println("3. Made the tool calls");
                        System.out.println("4. Incorporated results into natural responses");
                        
                } finally {
                        // Always clean up connections
                        mcpClient.close();
                }
        }
}