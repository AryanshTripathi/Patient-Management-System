import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

public class PatientIntegrationTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnPatientWithValidToken() {
        String loginPayload = """
          {
            "email": "testuser@test.com",
            "password": "password123"
          }
        """;

        String token = RestAssured.given()
                .contentType("application/json")
                .body(loginPayload)
                .post("/auth/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .jsonPath()
                .get("token");

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/api/patients")
                .then()
                .statusCode(200)
                .body("patients", notNullValue())
                .extract().response();

        System.out.println("Patients: " + response.asPrettyString());
    }

    @AfterAll
    public static void tearDown() {
        RestAssured.reset();
    }
}
