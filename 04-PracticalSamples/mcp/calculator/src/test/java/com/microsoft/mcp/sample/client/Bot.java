package com.microsoft.mcp.sample.client;

/**
 * Simple interface for AI chat bots that can use MCP tools.
 * 
 * This interface demonstrates the abstraction pattern:
 * - Different AI models (OpenAI, Anthropic, local models) can implement this
 * - The underlying MCP tool integration is handled by the implementation
 * - Client code can work with any AI model that implements this interface
 * 
 * This is used by LangChain4j's AiServices to create AI bots that can:
 * 1. Understand natural language prompts
 * 2. Decide when to call MCP tools
 * 3. Call the tools with appropriate parameters
 * 4. Incorporate tool results into their responses
 */
public interface Bot {

    /**
     * Send a prompt to the AI bot and get a response.
     * 
     * The AI implementation will:
     * - Analyze the prompt to understand what's needed
     * - Determine if MCP tools should be called
     * - Make tool calls if necessary
     * - Formulate a natural language response
     * 
     * @param prompt The user's question or request
     * @return The AI's response (may include results from tool calls)
     */
    String chat(String prompt);
}