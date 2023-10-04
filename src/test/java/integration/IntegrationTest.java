package integration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import com.example.demo.calculator.Constants;
import com.example.demo.request.CalculateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

/**
* This test class performs an integration-test to the /calculate end-point.
* Rest Assured and ObjectMapper is used to test the end-point.
*/
public class IntegrationTest {

    public final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testCalculatorEndpointCorrectResult() throws JsonProcessingException {
        CalculateRequest request = new CalculateRequest("1", "1", "+");
        RestAssured.baseURI = "http://localhost:8080";
        given()
                .contentType(ContentType.JSON)
                .body(objectMapper.writeValueAsString(request))
                .when()
                .post("/calculate")
                .then()
                .statusCode(200)
                .body(equalTo("2.0"));
    }

    @Test
    public void testCalculatorErrorMessage() throws JsonProcessingException {
        CalculateRequest request = new CalculateRequest("1", "1", "h");
        RestAssured.baseURI = "http://localhost:8080";
        given()
                .contentType(ContentType.JSON)
                .body(objectMapper.writeValueAsString(request))
                .when()
                .post("/calculate")
                .then()
                .statusCode(400)
                .body(equalTo(Constants.DISALLOWED_OPERATOR));
    }

}

