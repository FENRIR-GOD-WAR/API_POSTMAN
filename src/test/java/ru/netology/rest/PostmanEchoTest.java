package ru.netology.rest;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanEchoTest {

    @Test
    void shouldReturnPostedDataInResponseBody() {

        given()
                .baseUri("https://postman-echo.com")
                .body("Hi")
                .when().log().all()
                .post("/post")
                .then().log().all()
                .statusCode(200)
                .body("data", org.hamcrest.Matchers.equalTo("Hi"));
    }
}
