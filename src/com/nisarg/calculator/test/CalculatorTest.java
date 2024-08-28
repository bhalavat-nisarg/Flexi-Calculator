package com.nisarg.calculator.test;

import com.nisarg.calculator.Calculator;
import com.nisarg.calculator.Operations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(5.0, calculator.calculate(String.valueOf(Operations.ADD), 2, 3));
        assertEquals(2.0, calculator.calculate(String.valueOf(Operations.ADD), 0, 2));
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, calculator.calculate(String.valueOf(Operations.SUBTRACT), 3, 2));
        assertEquals(-2.0, calculator.calculate(String.valueOf(Operations.SUBTRACT), 6, 8));
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, calculator.calculate(String.valueOf(Operations.MULTIPLY), 2, 3));
        assertEquals(0.0, calculator.calculate(String.valueOf(Operations.MULTIPLY), 2, 0));
    }

    @Test
    void testDivide() {
        assertEquals(1.0, calculator.calculate(String.valueOf(Operations.DIVIDE), 2, 2));
        assertEquals(2.5, calculator.calculate(String.valueOf(Operations.DIVIDE), 5, 2));
    }

    @Test
    void testChainOperations() {
        assertEquals(16.0, calculator.chain(5, Operations.ADD, 3, Operations.MULTIPLY, 2));
        assertEquals(4.0, calculator.chain(5, Operations.SUBTRACT, 3, Operations.MULTIPLY, 2));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(String.valueOf(Operations.DIVIDE), 4, 0));
    }

    @Test
    void testUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(null, 2, 3));
    }

    @Test
    void testCustomOperations() {
        calculator.addNewOperation("MOD", (a, b) -> a.doubleValue() % b.doubleValue());
        assertEquals(1.0, calculator.calculate("MOD", 5, 2));
    }
}
