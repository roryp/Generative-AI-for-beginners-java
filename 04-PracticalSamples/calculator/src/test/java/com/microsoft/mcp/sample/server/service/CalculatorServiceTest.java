package com.microsoft.mcp.sample.server.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorServiceTest {

    private final CalculatorService calculator = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
        "add, 5, 3, 5.00 + 3.00 = 8.00",
        "add, 24.5, 17.3, 24.50 + 17.30 = 41.80",
        "subtract, 10, 4, 10.00 - 4.00 = 6.00",
        "multiply, 6, 7, 6.00 * 7.00 = 42.00",
        "divide, 20, 4, 20.00 / 4.00 = 5.00",
        "power, 2, 8, 2.00 ^ 8.00 = 256.00",
        "modulus, 17, 5, 17.00 % 5.00 = 2.00"
    })
    void binaryOperations(String operation, double first, double second, String expected) {
        String actual = switch (operation) {
            case "add" -> calculator.add(first, second);
            case "subtract" -> calculator.subtract(first, second);
            case "multiply" -> calculator.multiply(first, second);
            case "divide" -> calculator.divide(first, second);
            case "power" -> calculator.power(first, second);
            case "modulus" -> calculator.modulus(first, second);
            default -> throw new IllegalArgumentException(operation);
        };
        assertEquals(expected, actual);
    }

    @Test
    void unaryOperations() {
        assertAll(
            () -> assertEquals("\u221a16.00 = 4.00", calculator.squareRoot(16)),
            () -> assertEquals("\u221a0.00 = 0.00", calculator.squareRoot(0)),
            () -> assertEquals("|-5.50| = 5.50", calculator.absolute(-5.5)),
            () -> assertEquals("|0.00| = 0.00", calculator.absolute(0))
        );
    }

    @Test
    void invalidOperationsReturnClearErrors() {
        assertAll(
            () -> assertEquals("Error: Cannot divide by zero", calculator.divide(1, 0)),
            () -> assertEquals("Error: Cannot divide by zero", calculator.divide(1, -0.0)),
            () -> assertEquals("Error: Cannot divide by zero", calculator.modulus(1, 0)),
            () -> assertEquals("Error: Cannot calculate square root of a negative number", calculator.squareRoot(-1))
        );
    }

    @Test
    void helpListsEveryArithmeticTool() {
        for (String name : new String[] {"add", "subtract", "multiply", "divide", "power", "squareRoot", "modulus", "absolute"}) {
            assertTrue(calculator.help().contains(name + "("), name);
        }
    }
}