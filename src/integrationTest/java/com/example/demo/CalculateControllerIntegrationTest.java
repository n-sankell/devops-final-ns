package com.example.demo;

import com.example.demo.calculator.Constants;
import com.example.demo.request.CalculateRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
* This test class performs an integration-test to the /calculate end-point using MockMvc.
*/
@SpringBootTest
@AutoConfigureMockMvc
public class CalculateControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testCalculatorSuccess() throws Exception {
        CalculateRequest request = new CalculateRequest("1", "1", "+");
        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void testCalculatorFail() throws Exception {
        CalculateRequest request = new CalculateRequest("1", "1", null);
        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(request)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Constants.DISALLOWED_OPERATOR));
    }

}
