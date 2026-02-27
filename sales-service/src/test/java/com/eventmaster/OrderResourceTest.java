
package com.eventmaster;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class OrderResourceTest {

    @Test
    void shouldCreateOrderWhenAuthorized() {
        given()
          .auth().preemptive().basic("user","password")
          .body("ORDER123")
        .when()
          .post("/orders")
        .then()
          .statusCode(200)
          .body(containsString("ORDER_CREATED"));
    }
}
