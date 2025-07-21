package com.microsoft.mcp.sample.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for the Calculator MCP service.
 * 
 * This is crucial for MCP services because:
 * - AI models need consistent, parseable error responses
 * - Unhandled exceptions can crash the entire MCP conversation
 * - Clear error messages help users understand what went wrong
 * - Structured error responses are easier for clients to handle
 * 
 * Key Learning Points for Beginners:
 * - @RestControllerAdvice applies to ALL controllers in the application
 * - @ExceptionHandler methods catch specific exception types
 * - Always return structured error responses, not just strings
 * - Include helpful resolution guidance for common errors
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle IllegalArgumentException which occurs when invalid input is provided.
     * 
     * This is common in calculator operations when users provide invalid parameters.
     * Instead of crashing, we return a structured error response that AI models
     * can understand and relay to users.
     * 
     * @param ex The exception that was thrown
     * @return A structured error response with HTTP 400 (Bad Request)
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse error = new ErrorResponse(
            "Invalid_Input", 
            "Invalid input parameter: " + ex.getMessage(),
            "Please check your input values and try again. Use the help() tool for examples.");
        
        // HTTP 400 = Bad Request (client error, not server error)
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle any other unexpected exceptions.
     * 
     * This is the "catch-all" handler for problems we didn't anticipate.
     * Important for MCP services because unhandled exceptions break the conversation.
     * 
     * @param ex The exception that was thrown
     * @return A structured error response with HTTP 500 (Internal Server Error)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
            "Internal_Error", 
            "An unexpected error occurred: " + ex.getMessage(),
            "Please try again later or contact support if the issue persists. Check server logs for details.");
        
        // HTTP 500 = Internal Server Error (our fault, not the client's)
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Structured error response class for consistent error reporting.
     * 
     * This ensures all errors from our MCP service have the same format,
     * making it easier for AI models and clients to parse and handle errors.
     * 
     * Three-part error structure:
     * - code: Machine-readable error identifier
     * - message: Human-readable error description  
     * - resolution: Helpful guidance on how to fix the issue
     */
    public static class ErrorResponse {
        private String code;
        private String message;
        private String resolution;

        public ErrorResponse(String code, String message, String resolution) {
            this.code = code;
            this.message = message;
            this.resolution = resolution;
        }

        // Getters required for JSON serialization
        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public String getResolution() {
            return resolution;
        }
    }
}
