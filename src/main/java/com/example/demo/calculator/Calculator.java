package com.example.demo.calculator;

public class Calculator {

    public double calculate(String _x, String _y, String operand) {
        try {
            double x = Double.parseDouble(_x);
            double y = Double.parseDouble(_y);
            switch (parseOperand(operand)) {
                case '+' -> { return x + y; }
                case '-' -> { return x - y; }
                case '*' -> { return x * y; }
                case '/' -> {
                    if (y == 0) {
                        throw new RuntimeException(Constants.DIVIDE_ZERO);
                    }
                    return x / y; }
                default -> throw new RuntimeException(Constants.DISALLOWED_OPERAND);
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(Constants.NOT_A_NUMBER);
        }
    }

    public char parseOperand(String operand) {
        if (operand.length() == 1) {
            return operand.charAt(0);
        }
        throw new RuntimeException(Constants.WRONG_LENGTH);
    }

}
