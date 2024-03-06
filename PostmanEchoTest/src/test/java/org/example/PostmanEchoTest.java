package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {
    private static RequestSpecification requestSpec;
    private static ValidatableResponse response;

    @BeforeEach
    void setUpRequest() {
        requestSpec = RestAssured.given()
                .baseUri("https://postman-echo.com")
                .accept(ContentType.JSON);
    }

    void headersToBodyTest() {
        response
                .assertThat().body("headers.x-forwarded-proto", equalTo("https"))
                .assertThat().body("headers.x-forwarded-port", equalTo("443"))
                .assertThat().body("headers.host", equalTo("postman-echo.com"))
                .assertThat().body("headers.x-amzn-trace-id", notNullValue())
                .assertThat().body("headers.user-agent", notNullValue())
                .assertThat().body("headers.accept", notNullValue())
                .assertThat().body("headers.cache-control", nullValue())
                .assertThat().body("headers.postman-token", nullValue())
                .assertThat().body("headers.cookie", nullValue());
    }

    @Test
    @DisplayName("GET with args")
    void getTest() {
        response = requestSpec
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .assertThat().body("args.foo1", equalTo("bar1"))
                .assertThat().body("args.foo2", equalTo("bar2"));
        headersToBodyTest();

    }

    @Test
    @DisplayName("POST with json")
    void postJsonTest() {
        response = requestSpec
                .contentType("application/json")
                .accept("application/json")
                .body(new Person("Alex", 20))
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .assertThat().body("json.name", equalTo("Alex"))
                .assertThat().body("json.age", equalTo(20));
        headersToBodyTest();
    }

    @Test
    @DisplayName("POST with raw")
    void postTextTest() {
        response = requestSpec
                .body("Some text")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .assertThat().body("data", equalTo("Some text"));
        headersToBodyTest();
    }

    @Test
    @DisplayName("POST with form")
    void postFileTest() {
        response = requestSpec
                .given()
                .contentType("multipart/form-data")
                .multiPart("login", "stas")
                .multiPart("password", "1234")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .assertThat().body("form.login", equalTo("stas"))
                .assertThat().body("form.password", equalTo("1234"));
        headersToBodyTest();
    }

    @Test
    @DisplayName("PUT with json")
    void putJsonTest() {
        response = requestSpec
                .contentType("application/json")
                .accept("application/json")
                .body(new Person("Alex", 20))
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .assertThat().body("json.name", equalTo("Alex"))
                .assertThat().body("json.age", equalTo(20));
        headersToBodyTest();
    }

    @Test
    @DisplayName("PUT with raw")
    void putTextTest() {
        response = requestSpec
                .body("Some text")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .assertThat().body("data", equalTo("Some text"));
        headersToBodyTest();
    }

    @Test
    @DisplayName("PUT with form")
    void putFileTest() {
        response = requestSpec
                .given()
                .contentType("multipart/form-data")
                .multiPart("login", "stas")
                .multiPart("password", "1234")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .assertThat().body("form.login", equalTo("stas"))
                .assertThat().body("form.password", equalTo("1234"));
        headersToBodyTest();
    }

    @Test
    @DisplayName("PATCH with form")
    void patchFileTest() {
        response = requestSpec
                .given()
                .contentType("multipart/form-data")
                .multiPart("login", "stas")
                .multiPart("password", "1234")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .assertThat().body("form.login", equalTo("stas"))
                .assertThat().body("form.password", equalTo("1234"));
        headersToBodyTest();
    }

    @Test
    @DisplayName("PATCH with raw")
    void patchTextTest() {
        response = requestSpec
                .body("Some text")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .assertThat().body("data", equalTo("Some text"));
        headersToBodyTest();
    }

    @Test
    @DisplayName("PATCH with json")
    void patchJsonTest() {
        response = requestSpec
                .contentType("application/json")
                .accept("application/json")
                .body(new Person("Alex", 20))
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .assertThat().body("json.name", equalTo("Alex"))
                .assertThat().body("json.age", equalTo(20));
        headersToBodyTest();
    }

    @Test
    @DisplayName("DELETE with json")
    void deleteJsonTest() {
        requestSpec
                .contentType("application/json")
                .accept("application/json")
                .body(new Person("Alex", 20))
                .when()
                .put("/put")
                .then()
                .statusCode(200);

        response = requestSpec
                .given()
                .delete("/delete")
                .then()
                .statusCode(200);

        System.out.println(response.extract().asPrettyString());
    }
}

