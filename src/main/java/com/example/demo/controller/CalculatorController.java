package com.example.demo.controller;

import com.example.demo.request.CalculateRequest;
import com.example.demo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
* This class contains the controller for the calculator.
* Communication with the actual calculator through CalculatorService.
*/
@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    /**
    * This method gets called through the /calculate end-point.
    * Returns either an error message or the String value of the calculation.
    *
    * @param request request body CalculateRequest.
    */
    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestBody CalculateRequest request) {
        try {
            return ResponseEntity.ok().body(String.valueOf(calculatorService.calculate(request)));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok().body("Calculator app!");

    }

}
