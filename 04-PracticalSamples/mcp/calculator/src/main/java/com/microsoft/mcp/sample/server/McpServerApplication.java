package com.microsoft.mcp.sample.server;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.microsoft.mcp.sample.server.service.CalculatorService;

/**
 * Main MCP (Model Context Protocol) Server Application for Calculator Service.
 * 
 * This demonstrates how to create an MCP server that provides calculator tools
 * that AI models can call. Key concepts:
 * 
 * MCP (Model Context Protocol):
 * - A protocol that allows AI models to connect to external tools and data sources
 * - Think of it as a "plugin system" for AI models
 * - AI models can discover and call functions/tools through this protocol
 * 
 * Why MCP is important for beginners:
 * - Extends AI capabilities beyond just text generation
 * - Allows AI to perform real actions (calculations, API calls, database queries)
 * - Standard way to make your functions available to AI models
 * - Works with different AI models and clients consistently
 */
@SpringBootApplication
public class McpServerApplication {

	public static void main(String[] args) {
		// Start Spring Boot server that will expose calculator tools via MCP
		SpringApplication.run(McpServerApplication.class, args);
	}
	
	/**
	 * Configure Spring AI to automatically discover and expose calculator methods as tools.
	 * 
	 * Spring AI Magic: Any method in CalculatorService marked with @Tool annotation
	 * will automatically become available as an MCP tool that AI models can call.
	 * 
	 * This bean tells Spring AI to scan the CalculatorService and create
	 * tool definitions from its @Tool-annotated methods.
	 */
	@Bean
	public ToolCallbackProvider calculatorTools(CalculatorService calculator) {
		// MethodToolCallbackProvider automatically discovers @Tool methods
		// and creates MCP-compatible tool definitions
		return MethodToolCallbackProvider.builder().toolObjects(calculator).build();
	}

}
