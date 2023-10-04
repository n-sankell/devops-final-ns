package com.example.demo.request;

/**
* DTO class that represents an API-request,
* contains the numbers and operator that shall be calculated.
*
* @param x String value of first number.
* @param y String value of second number.
* @param operator String value of operand.
*/
public record CalculateRequest(String x, String y, String operator) {
}
