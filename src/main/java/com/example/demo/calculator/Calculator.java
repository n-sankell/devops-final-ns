package com.example.demo.calculator;

/**
* The calculator class represents a simple calculator that can
* perform a simple calculation with two operands and one operator.
*/
public class Calculator {

    /**
    * Performs a simple calculation. If all parameters are valid, a double result is returned.
        *
      * @param inputX String value of the first number. This will get parsed before calculation.
       * @param inputY String value of the second number. This will get parsed before calculation.
    * @param operator String value of the operator. This will get parsed before calculation.
     */
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

    /**
    * Check if the operator is null or has the right length.
     * Returns the char value of the input String.
    *
     * @param operator String value of the operator.
    */
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
