package com.example.demo.service;

import com.example.demo.calculator.Calculator;
import com.example.demo.request.CalculateRequest;
import org.springframework.stereotype.Service;

/**
* This class contains the service-layer for the calculator.
* This class communicates with the actual calculator.
*/
@Service
public class CalculatorService {

    private final Calculator calculator = new Calculator();

    /**
    * This method calls the calculate method in the Calculator class.
    * Returns either an error or the double value of the calculation.
    *
    * @param request input to the calculator passes the individual fields from the CalculateRequest.
    */
    public double calculate(CalculateRequest request) {
        return calculator.calculate(request.x(), request.y(), request.operator());
    }

}
