package com.tests.spies;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@QuarkusTest
public class SpyGreetingServiceTest {
    @InjectSpy
    GreetingService greetingService;

    @Test
    public void testDefaultGreeting() {
        given()
                .when().get("/greeting")
                .then()
                .statusCode(200)
                .body(is("hello"));

        Mockito.verify(greetingService, Mockito.times(1)).greet();
    }

    @Test
    public void testOverrideGreeting() {
        doReturn("hi").when(greetingService).greet();
        given()
                .when().get("/greeting")
                .then()
                .statusCode(200)
                .body(is("hi"));
    }

    @Path("greeting")
    public static class GreetingResource {

        final GreetingService greetingService;

        public GreetingResource(GreetingService greetingService) {
            this.greetingService = greetingService;
        }

        @GET
        @Produces("text/plain")
        public String greet() {
            return greetingService.greet();
        }
    }

    @ApplicationScoped
    public static class GreetingService {
        public String greet() {
            return "hello";
        }
    }
}
