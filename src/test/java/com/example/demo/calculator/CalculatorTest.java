package com.example.demo.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    public Calculator calculator;

    @BeforeEach
    void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    void calculateAdd() {
        assertEquals(12, calculator.calculate("5", "7", "+"), 0);
    }

    @Test
    void calculateAddFalse() {
        assertNotEquals(13, calculator.calculate("5", "7", "+"), 0);
    }

    @Test
    void calculateSubtract() {
        assertEquals(-2, calculator.calculate("5", "7", "-"), 0);
    }

    @Test
    void calculateSubtractFalse() {
        assertNotEquals(-3, calculator.calculate("5", "7", "-"), 0);
    }

    @Test
    void calculateMultiply() {
        assertEquals(10, calculator.calculate("5", "2", "*"), 0);
    }

    @Test
    void calculateMultiplyFalse() {
        assertNotEquals(11, calculator.calculate("5", "2", "*"), 0);
    }

    @Test
    void calculateDivide() {
        assertEquals(2.5, calculator.calculate("5", "2", "/"), 0);
    }

    @Test
    void calculateDivideFalse() {
        assertNotEquals(2.7, calculator.calculate("5", "2", "/"), 0);
    }

    @Test
    void parseOperand() {
        assertEquals('*', calculator.parseOperator("*"));
    }

    @Test
    void parseOperandLength() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                calculator.parseOperator("//"));
        assertEquals(Constants.WRONG_LENGTH, exception.getMessage());
    }

    @Test
    void parseOperandNull() {
        Throwable exception = assertThrows(RuntimeException.class, () ->
                calculator.parseOperator(null));
        assertEquals(Constants.DISALLOWED_OPERATOR, exception.getMessage());
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
        assertEquals(Constants.DISALLOWED_OPERATOR, exception.getMessage());
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