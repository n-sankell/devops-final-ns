package com.example.demo.calculator;

public class Calculator {

    public double calculate(String inputX, String inputY, String operator) {
        try {
            double x = Double.parseDouble(inputX);
            double y = Double.parseDouble(inputY);
            switch (parseOperator(operator)) {
                case '+' -> {
                    return x + y;
                }
                case '-' -> {
                    return x - y;
                }
                case '*' -> {
                    return x * y;
                }
                case '/' -> {
                    if (y == 0) {
                        throw new RuntimeException(Constants.DIVIDE_ZERO);
                    }
                    return x / y;
                }
                default -> throw new RuntimeException(Constants.DISALLOWED_OPERATOR);
            }
        } catch (NumberFormatException | NullPointerException e) {
            throw new RuntimeException(Constants.NOT_A_NUMBER);
        }
    }

    public char parseOperator(String operator) {
        if (operator == null) {
            throw new RuntimeException(Constants.DISALLOWED_OPERATOR);
        }
        if (operator.length() == 1) {
            return operator.charAt(0);
        }
        throw new RuntimeException(Constants.WRONG_LENGTH);
    }

}
