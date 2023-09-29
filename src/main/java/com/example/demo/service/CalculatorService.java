package com.example.demo.service;

import com.example.demo.calculator.Calculator;
import com.example.demo.request.CalculateRequest;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final Calculator calculator = new Calculator();

    public double calculate(CalculateRequest request) {
        return calculator.calculate(request.x(), request.y(), request.operand());
    }

}
