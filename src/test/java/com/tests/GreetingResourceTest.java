package com.tests;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

@QuarkusTest
@TestHTTPEndpoint(GreetingResource.class)
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
                .when().get()
                .then()
                .statusCode(200)
                .body(is("Hello from Quarkus REST"));
    }

    @Test
    public void testGreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();
        given()
                .pathParam("name", uuid)
                .when()
                .get("/greeting/{name}")
                .then()
                .statusCode(200)
                .body(is("hello " + uuid));
    }

}