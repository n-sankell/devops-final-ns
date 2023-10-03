package com.example.demo.service;

import com.example.demo.request.CalculateRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {

    private final CalculatorService service = new CalculatorService();

    @Test
    void calculate() {
        CalculateRequest request = new CalculateRequest("1","1","+");
        assertEquals(String.valueOf(service.calculate(request)), "2.0");
    }

}