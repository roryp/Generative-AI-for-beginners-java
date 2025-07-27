package com.microsoft.mcp.sample.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.mcp.sample.server.service.CalculatorService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for health check and service information endpoints.
 * 
 * These endpoints are crucial for production MCP services:
 * - Health checks help clients verify the service is running
 * - Info endpoints help clients discover available tools
 * - Both are useful for debugging connection issues
 * 
 * Key Learning Points:
 * - @RestController automatically converts return values to JSON
 * - ResponseEntity allows control over HTTP status codes
 * - Health checks should be simple and fast (no complex logic)
 */
@RestController
public class HealthController {
    
    // Dependency injection: Spring provides the CalculatorService instance
    private final CalculatorService calculatorService;
    
    public HealthController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }    
    
    /**
     * Simple health check endpoint.
     * 
     * This is the first endpoint clients should call to verify:
     * 1. The server is running and responding
     * 2. Basic dependencies are working
     * 3. The service timestamp for debugging
     * 
     * URL: GET /health
     * 
     * @return Health status information in JSON format
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");                           // Service is running
        response.put("timestamp", LocalDateTime.now().toString());  // When this was checked
        response.put("service", "Basic Calculator MCP Service");
        
        // Verify that our calculator service dependency is available
        // This catches common Spring configuration issues
        response.put("calculatorService", calculatorService != null ? "Available" : "Unavailable");
        
        // Return HTTP 200 OK with the health information
        return ResponseEntity.ok(response);
    }
    
    /**
     * Information endpoint about the service and its available tools.
     * 
     * This endpoint helps clients (and developers) discover:
     * 1. What tools are available
     * 2. What each tool does
     * 3. How to access the MCP endpoints
     * 
     * Very useful for debugging and client development.
     * URL: GET /info
     * 
     * @return Service information and available tools in JSON format
     */
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> serviceInfo() {
        Map<String, Object> response = new HashMap<>();
        response.put("service", "Basic Calculator MCP Service");
        response.put("version", "1.0.0");
        response.put("endpoint", "/v1/tools");
        
        // List all available tools with descriptions
        // This matches the @Tool annotations in CalculatorService
        // In a production system, you might auto-discover these
        Map<String, String> tools = new HashMap<>();
        tools.put("add", "Add two numbers together");
        tools.put("subtract", "Subtract the second number from the first number");
        tools.put("multiply", "Multiply two numbers together");
        tools.put("divide", "Divide the first number by the second number");
        tools.put("power", "Calculate the power of a number (base raised to an exponent)");
        tools.put("squareRoot", "Calculate the square root of a number");
        tools.put("modulus", "Calculate the remainder when one number is divided by another");
        tools.put("absolute", "Calculate the absolute value of a number");
        tools.put("help", "Get help about available calculator operations");
        response.put("availableTools", tools);
        
        // Additional helpful information for clients
        response.put("documentation", "See README.md for usage examples");
        response.put("clientExamples", "Check src/test/java for client implementation examples");
        
        return ResponseEntity.ok(response);
    }
}
