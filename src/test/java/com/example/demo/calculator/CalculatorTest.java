package com.example.demo.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    public Calculator calculator;

    @BeforeEach
    void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    void calculateAdd() {
        assertEquals(calculator.calculate("5", "7", "+"), 12, 0);
    }

    @Test
    void calculateAddFalse() {
        assertNotEquals(calculator.calculate("5", "7", "+"), 13, 0);
    }

    @Test
    void calculateSubtract() {
        assertEquals(calculator.calculate("5", "7", "-"), -2, 0);
    }

    @Test
    void calculateSubtractFalse() {
        assertNotEquals(calculator.calculate("5", "7", "-"), -3, 0);
    }

    @Test
    void calculateMultiply() {
        assertEquals(calculator.calculate("5", "2", "*"), 10, 0);
    }

    @Test
    void calculateMultiplyFalse() {
        assertNotEquals(calculator.calculate("5", "2", "*"), 11, 0);
    }

    @Test
    void calculateDivide() {
        assertEquals(calculator.calculate("5", "2", "/"), 2.5, 0);
    }

    @Test
    void calculateDivideFalse() {
        assertNotEquals(calculator.calculate("5", "2", "/"), 2.7, 0);
    }

    @Test
    void parseOperand() {
        assertEquals(calculator.parseOperand("*"), '*');
    }

    @Test
    void parseOperandLength() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                calculator.parseOperand("//"));
        assertEquals(Constants.WRONG_LENGTH, exception.getMessage());
    }

    @Test
    void divideWithZeroExpectException() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                calculator.calculate("5", "0", "/"));
        assertEquals(Constants.DIVIDE_ZERO, exception.getMessage());
    }

    @Test
    void wrongOperandExpectException() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                calculator.calculate("5", "5", "a"));
        assertEquals(Constants.DISALLOWED_OPERAND, exception.getMessage());
    }

    @Test
    void wrongOperandLengthExpectException() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                calculator.calculate("5", "5", "++"));
        assertEquals(Constants.WRONG_LENGTH, exception.getMessage());
    }

    @Test
    void wrongNumberExpectException() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                calculator.calculate("h", "5", "+"));
        assertEquals(Constants.NOT_A_NUMBER, exception.getMessage());
    }

}