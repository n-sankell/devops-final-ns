package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.calculator.Constants;
import com.example.demo.request.CalculateRequest;
import com.example.demo.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class CalculatorControllerTest {

    private final CalculatorService service = new CalculatorService();
    private final CalculatorController controller = new CalculatorController(service);

    @Test
    void testCalculatorEndpointCorrectResult() {
        CalculateRequest request = new CalculateRequest("1", "1", "+");
        ResponseEntity<String> response = controller.calculate(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("2.0", response.getBody());
    }

    @Test
    void testCalculatorErrorMessage() {
        CalculateRequest request = new CalculateRequest("1", "1", null);
        ResponseEntity<String> response = controller.calculate(request);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(Constants.DISALLOWED_OPERATOR, response.getBody());
    }

    @Test
    void testControllerHello() {
        ResponseEntity<String> response = controller.hello();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Calculator app!", response.getBody());
    }

}