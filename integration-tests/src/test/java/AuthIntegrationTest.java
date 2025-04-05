import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnOkWithValidToken() {
        String loginPayload = """
          {
            "email": "testuser@test.com",
            "password": "password123"
          }
        """;

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(loginPayload)
                .post("/auth/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .extract().response();

        System.out.println("Generated token: " + response.jsonPath().getString("token"));
    }

    @Test
    public void shouldReturnUnauthorizedOnInvalidLogin() {
        String loginPayload = """
          {
            "email": "invalid_user@test.com",
            "password": "wrong_password123"
          }
        """;

        RestAssured.given()
                .contentType("application/json")
                .body(loginPayload)
                .post("/auth/login")
                .then()
                .statusCode(401);
    }

    @AfterAll
    static void tearDown() {
        RestAssured.reset();
    }
}




