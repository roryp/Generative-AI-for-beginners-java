package com.microsoft.mcp.sample.server.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

/**
 * Calculator Service that exposes mathematical operations as MCP tools.
 * 
 * This service demonstrates the key concept of MCP tool development:
 * - Each method annotated with @Tool becomes available to AI models
 * - The AI can "call" these functions and get back results
 * - Think of this as creating a "calculator plugin" for AI models
 * 
 * Key Learning Points for Beginners:
 * - @Tool annotation makes methods discoverable by AI models
 * - Description parameter helps AI understand what each tool does
 * - Good error handling prevents AI from getting confused responses
 * - Consistent formatting helps AI understand and relay results to users
 * 
 * This pattern can be extended to any functionality you want AI to access:
 * database queries, API calls, file operations, etc.
 */
@Service
public class CalculatorService {

    /**
     * Add two numbers
     * 
     * @Tool annotation makes this method available to AI models as a callable function.
     * The description helps the AI understand when and how to use this tool.
     * 
     * @param a The first number
     * @param b The second number
     * @return The sum of the two numbers (formatted for easy reading)
     */
    @Tool(description = "Add two numbers together")
    public String add(double a, double b) {
        double result = a + b;
        return formatResult(a, "+", b, result);
    }

    /**
     * Subtract one number from another
     * 
     * AI models can understand parameter names and use them correctly
     * when calling this function.
     * 
     * @param a The number to subtract from (minuend)
     * @param b The number to subtract (subtrahend)
     * @return The result of the subtraction
     */
    @Tool(description = "Subtract the second number from the first number")
    public String subtract(double a, double b) {
        double result = a - b;
        return formatResult(a, "-", b, result);
    }

    /**
     * Multiply two numbers
     * @param a The first number
     * @param b The second number
     * @return The product of the two numbers
     */
    @Tool(description = "Multiply two numbers together")
    public String multiply(double a, double b) {
        double result = a * b;
        return formatResult(a, "*", b, result);
    }

    /**
     * Divide one number by another
     * 
     * This demonstrates IMPORTANT error handling for MCP tools:
     * - Always validate inputs to prevent crashes
     * - Return clear error messages that AI models can understand and relay to users
     * - Don't throw exceptions unless absolutely necessary (they confuse AI models)
     * 
     * @param a The numerator (dividend)
     * @param b The denominator (divisor)
     * @return The result of the division or an error message
     */
    @Tool(description = "Divide the first number by the second number")
    public String divide(double a, double b) {
        // Critical validation: prevent division by zero
        if (b == 0) {
            return "Error: Cannot divide by zero";
        }
        double result = a / b;
        return formatResult(a, "/", b, result);
    }

    /**
     * Calculate the power of a number
     * @param base The base number
     * @param exponent The exponent
     * @return The result of raising the base to the exponent
     */
    @Tool(description = "Calculate the power of a number (base raised to an exponent)")
    public String power(double base, double exponent) {
        double result = Math.pow(base, exponent);
        return formatResult(base, "^", exponent, result);
    }

    /**
     * Calculate the square root of a number
     * 
     * Another example of good error handling for MCP tools.
     * Notice the different formatting since this is a single-operand function.
     * 
     * @param number The number to find the square root of
     * @return The square root of the number or an error message
     */
    @Tool(description = "Calculate the square root of a number")
    public String squareRoot(double number) {
        // Validate input: square root of negative numbers isn't real
        if (number < 0) {
            return "Error: Cannot calculate square root of a negative number";
        }
        double result = Math.sqrt(number);
        // Different formatting for single-operand functions
        return String.format("√%.2f = %.2f", number, result);
    }

    /**
     * Format the result of a calculation
     * 
     * Private helper method that ensures consistent formatting across all operations.
     * This makes the output more readable for both AI models and end users.
     * 
     * Pattern: operation_operand operation_symbol operand = result
     * Example: 5.00 + 3.00 = 8.00
     */
    private String formatResult(double a, String operator, double b, double result) {
        return String.format("%.2f %s %.2f = %.2f", a, operator, b, result);
    }

    /**
     * Calculate the modulus (remainder) of division
     * @param a The dividend
     * @param b The divisor
     * @return The remainder of the division
     */
    @Tool(description = "Calculate the remainder when one number is divided by another")
    public String modulus(double a, double b) {
        if (b == 0) {
            return "Error: Cannot divide by zero";
        }
        double result = a % b;
        return formatResult(a, "%", b, result);
    }

    /**
     * Calculate the absolute value of a number
     * @param number The number to find the absolute value of
     * @return The absolute value of the number
     */
    @Tool(description = "Calculate the absolute value of a number")
    public String absolute(double number) {
        double result = Math.abs(number);
        return String.format("|%.2f| = %.2f", number, result);
    }

    /**
     * Get help about available calculator operations
     * 
     * This is a special kind of MCP tool - a "meta-tool" that provides information
     * about other tools. Very useful for AI models to understand what's available.
     * 
     * Best Practice: Always provide a help function in your MCP services
     * so AI models can discover and understand your tool capabilities.
     * 
     * @return Information about available operations and examples
     */
    @Tool(description = "Get help about available calculator operations")
    public String help() {
        return "Basic Calculator MCP Service\n\n" +
               "Available operations:\n" +
               "1. add(a, b) - Adds two numbers\n" +
               "2. subtract(a, b) - Subtracts the second number from the first\n" +
               "3. multiply(a, b) - Multiplies two numbers\n" +
               "4. divide(a, b) - Divides the first number by the second\n" +
               "5. power(base, exponent) - Raises a number to a power\n" +
               "6. squareRoot(number) - Calculates the square root\n" + 
               "7. modulus(a, b) - Calculates the remainder of division\n" +
               "8. absolute(number) - Calculates the absolute value\n\n" +
               "Example usage: add(5, 3) will return 5 + 3 = 8\n\n" +
               "All operations include input validation and clear error messages.";
    }
}
