package com.example.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class JsonPlaceholderTests extends BaseTest {

    private Integer createdId;
    private Integer updateId; // I used stable id (1..100) for update flows

    @Test
    public void getPosts_shouldReturn200_andWithin2s_andMatchSchema() {
        Response res = given().spec(req).when().get("/posts");
        reportPerfIfSlow("GET", "/posts", res.timeIn(TimeUnit.MILLISECONDS));

        res.then()
           .statusCode(200)
           .contentType(ContentType.JSON)
           .time(lessThan(perfThresholdMs))
           .body(matchesJsonSchemaInClasspath("schemas/posts.schema.json"))
           .body("size()", greaterThan(0));
    }

    @Test(dependsOnMethods = "getPosts_shouldReturn200_andWithin2s_andMatchSchema")
    public void createPost_shouldReturn201_andId() {
        Map<String, Object> body = new HashMap<>();
        body.put("title", "foo");
        body.put("body", "bar");
        body.put("userId", 1);

        Response res = given().spec(req).body(body).when().post("/posts");
        reportPerfIfSlow("POST", "/posts", res.timeIn(TimeUnit.MILLISECONDS));

        res.then()
           .statusCode(201)
           .contentType(ContentType.JSON)
           .body("title", equalTo("foo"))
           .body("body", equalTo("bar"))
           .body("userId", equalTo(1))
           .body("id", notNullValue());

        createdId = res.jsonPath().getInt("id");
        updateId = (createdId != null && createdId <= 100) ? createdId : 1; // I used to avoid fake-id 500s
        Assert.assertNotNull(createdId);
        Assert.assertNotNull(updateId);
    }

    @Test(dependsOnMethods = "createPost_shouldReturn201_andId")
    public void putPost_shouldReturn200_andReplaceFields() {
        Map<String, Object> body = new HashMap<>();
        body.put("id", updateId);
        body.put("title", "updated-title");
        body.put("body", "updated-body");
        body.put("userId", 1);

        Response res = given().spec(req).body(body).when().put("/posts/{id}", updateId);
        reportPerfIfSlow("PUT", "/posts/" + updateId, res.timeIn(TimeUnit.MILLISECONDS));

        res.then()
           .statusCode(200)
           .contentType(ContentType.JSON)
           .body("id", equalTo(updateId))
           .body("title", equalTo("updated-title"))
           .body("body", equalTo("updated-body"))
           .body("userId", equalTo(1));
    }

    @Test(dependsOnMethods = "putPost_shouldReturn200_andReplaceFields")
    public void patchPost_shouldReturn200_andUpdatePartialField() {
        Map<String, Object> body = new HashMap<>();
        body.put("title", "patched-title");

        Response res = given().spec(req).body(body).when().patch("/posts/{id}", updateId);
        reportPerfIfSlow("PATCH", "/posts/" + updateId, res.timeIn(TimeUnit.MILLISECONDS));

        res.then()
           .statusCode(200)
           .contentType(ContentType.JSON)
           .body("id", equalTo(updateId))
           .body("title", equalTo("patched-title"));
    }

    @Test(dependsOnMethods = "patchPost_shouldReturn200_andUpdatePartialField")
    public void deletePost_shouldReturn200() {
        Response res = given().spec(req).when().delete("/posts/{id}", updateId);
        reportPerfIfSlow("DELETE", "/posts/" + updateId, res.timeIn(TimeUnit.MILLISECONDS));

        res.then()
           .statusCode(anyOf(is(200), is(204)));
    }

    // Negative tests
    @Test
    public void getInvalidEndpoint_shouldReturn404() {
        Response res = given().spec(req).when().get("/does-not-exist");
        reportPerfIfSlow("GET", "/does-not-exist", res.timeIn(TimeUnit.MILLISECONDS));
        res.then().statusCode(404);
    }

    @Test
    public void postWithInvalidContentType_shouldReturn415_orIgnore() {
        Response res = given().spec(req)
                .contentType(ContentType.XML) // intentionally wrong
                .body("<bad/>")
                .when().post("/posts");
        reportPerfIfSlow("POST", "/posts (invalid content-type)", res.timeIn(TimeUnit.MILLISECONDS));

        res.then().statusCode(anyOf(is(201), is(415)));
    }
}
