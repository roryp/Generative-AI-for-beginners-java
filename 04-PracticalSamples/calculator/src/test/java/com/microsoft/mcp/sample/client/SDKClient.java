package com.microsoft.mcp.sample.client;

import java.io.PrintStream;
import java.time.Duration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientStreamableHttpTransport;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.ListToolsResult;
import io.modelcontextprotocol.spec.McpSchema.TextContent;

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
	static final Set<String> CALCULATOR_TOOLS = Set.of(
		"add", "subtract", "multiply", "divide", "power", "squareRoot", "modulus", "absolute", "help");

	public static void main(String[] args) {
		McpClientTransport transport = HttpClientStreamableHttpTransport.builder(serverUrl())
			.endpoint("/mcp")
			.connectTimeout(Duration.ofSeconds(15))
			.build();
		new SDKClient(transport).run();
	}

	static String serverUrl() {
		return System.getProperty("mcp.server.url",
			System.getenv().getOrDefault("MCP_SERVER_URL", "http://localhost:8080"));
	}

	static void requireCalculatorTools(Set<String> availableTools) {
		var missing = new HashSet<>(CALCULATOR_TOOLS);
		missing.removeAll(availableTools);
		if (!missing.isEmpty()) {
			throw new IllegalStateException("Calculator tools missing: " + missing);
		}
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
		run(System.out);
	}

	void run(PrintStream output) {
		try (var client = McpClient.sync(this.transport).requestTimeout(Duration.ofSeconds(15)).build()) {
			client.initialize();
			client.ping();

			var toolNames = new HashSet<String>();
			String cursor = null;
			do {
				ListToolsResult page = client.listTools(cursor);
				page.tools().forEach(tool -> toolNames.add(tool.name()));
				cursor = page.nextCursor();
			} while (cursor != null);
			requireCalculatorTools(toolNames);
			output.println("Available Tools = " + toolNames);

			printResult(client, "add", Map.of("a", 5.0, "b", 3.0), output);
			printResult(client, "subtract", Map.of("a", 10.0, "b", 4.0), output);
			printResult(client, "multiply", Map.of("a", 6.0, "b", 7.0), output);
			printResult(client, "divide", Map.of("a", 20.0, "b", 4.0), output);
			printResult(client, "power", Map.of("base", 2.0, "exponent", 8.0), output);
			printResult(client, "squareRoot", Map.of("number", 16.0), output);
			printResult(client, "modulus", Map.of("a", 17.0, "b", 5.0), output);
			printResult(client, "absolute", Map.of("number", -5.5), output);
			printResult(client, "help", Map.of(), output);
		}
	}

	static void printResult(McpSyncClient client, String name, Map<String, Object> arguments, PrintStream output) {
		CallToolResult result = client.callTool(CallToolRequest.builder(name).arguments(arguments).build());
		if (Boolean.TRUE.equals(result.isError())) {
			throw new IllegalStateException("MCP tool failed: " + name + ": " + result.content());
		}
		output.println(name + " = " + result.content().stream()
			.filter(TextContent.class::isInstance)
			.map(TextContent.class::cast)
			.map(TextContent::text)
			.collect(java.util.stream.Collectors.joining("\n")));
	}
}
