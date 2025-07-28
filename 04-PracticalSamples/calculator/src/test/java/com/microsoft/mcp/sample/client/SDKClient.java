package com.microsoft.mcp.sample.client;

import java.util.Map;

import org.springframework.web.reactive.function.client.WebClient;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.transport.WebFluxSseClientTransport;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.ListToolsResult;

/**
 * Direct MCP SDK Client Example
 * 
 * This demonstrates how to use the MCP (Model Context Protocol) SDK directly
 * to connect to an MCP server and call tools programmatically.
 * 
 * This approach is useful when you want:
 * - Direct control over MCP communication
 * - To build custom integrations
 * - To understand how MCP works under the hood
 * - To create non-AI clients that use MCP tools
 * 
 * Compare this with LangChain4jClient which uses AI models to decide
 * when and how to call tools based on natural language prompts.
 */
public class SDKClient {
	
	public static void main(String[] args) {
		// Create transport that connects to our MCP server via Server-Sent Events
		// SSE is a standard protocol for real-time communication
		var transport = new WebFluxSseClientTransport(WebClient.builder().baseUrl("http://localhost:8080"));
		new SDKClient(transport).run();
	}
	
	private final McpClientTransport transport;

	public SDKClient(McpClientTransport transport) {
		this.transport = transport;
	}

	/**
	 * Demonstrates direct MCP tool calling without AI involvement.
	 * 
	 * This shows the raw MCP protocol in action:
	 * 1. Initialize connection to MCP server
	 * 2. Discover available tools
	 * 3. Call tools directly with specific parameters
	 * 4. Handle responses
	 */
	public void run() {

		// Create synchronous MCP client (blocking operations)
		var client = McpClient.sync(this.transport).build();
		
		// Initialize the MCP connection
		client.initialize();

		// Verify connection with a ping
		client.ping();

		// Discover what tools are available on the server
		// This is equivalent to browsing an API documentation
		ListToolsResult toolsList = client.listTools();
		System.out.println("Available Tools = " + toolsList);

		// Now let's test each calculator operation directly
		// Notice: WE decide what parameters to use (no AI involved)
		
		CallToolResult resultAdd = client.callTool(new CallToolRequest("add", Map.of("a", 5.0, "b", 3.0)));
		System.out.println("Add Result = " + resultAdd);

		CallToolResult resultSubtract = client.callTool(new CallToolRequest("subtract", Map.of("a", 10.0, "b", 4.0)));
		System.out.println("Subtract Result = " + resultSubtract);

		CallToolResult resultMultiply = client.callTool(new CallToolRequest("multiply", Map.of("a", 6.0, "b", 7.0)));
		System.out.println("Multiply Result = " + resultMultiply);

		CallToolResult resultDivide = client.callTool(new CallToolRequest("divide", Map.of("a", 20.0, "b", 4.0)));
		System.out.println("Divide Result = " + resultDivide);

		CallToolResult resultPower = client.callTool(new CallToolRequest("power", Map.of("base", 2.0, "exponent", 8.0)));
		System.out.println("Power Result = " + resultPower);

		CallToolResult resultSqrt = client.callTool(new CallToolRequest("squareRoot", Map.of("number", 16.0)));
		System.out.println("Square Root Result = " + resultSqrt);

		CallToolResult resultAbsolute = client.callTool(new CallToolRequest("absolute", Map.of("number", -5.5)));
		System.out.println("Absolute Result = " + resultAbsolute);

		// Get help information about available tools
		CallToolResult resultHelp = client.callTool(new CallToolRequest("help", Map.of()));
		System.out.println("Help = " + resultHelp);

		// Clean up the connection
		client.closeGracefully();

		// Give threads time to shut down properly before exiting
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.exit(0);
	}
}
