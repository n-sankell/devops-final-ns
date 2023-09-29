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
                        throw new RuntimeException("Cant divide with zero");
                    }
                    return x / y; }
                default -> throw new RuntimeException("Operand is not allowed");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Not a number");
        }
    }

    public char parseOperand(String operand) {
        if (operand.length() == 1) {
            return operand.charAt(0);
        }
        throw new RuntimeException("Wrong length");
    }

}
