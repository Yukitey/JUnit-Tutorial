package com.yukitey;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    @DisplayName("add(2, 3) должен вернуть 5")
    void add_positiveNumbers() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(2, 3);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void divide_shouldThrow_whenDivisorIsZero() {
        Calculator calc = new Calculator();

        ArithmeticException ex = assertThrows(
                ArithmeticException.class,
                () -> calc.divide(10, 0)
        );

        assertEquals("Делить на ноль нельзя", ex.getMessage());
    }
}