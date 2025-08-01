package com.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected RequestSpecification req;
    protected long perfThresholdMs;

    @BeforeClass
    public void setup() {
        String baseUrl = System.getProperty("baseUrl", "https://jsonplaceholder.typicode.com");
        perfThresholdMs = Long.parseLong(System.getProperty("perfThresholdMs", "2000"));

        RestAssured.baseURI = baseUrl;

        req = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setContentType(ContentType.JSON)
                .build();

        RestAssured.filters(new RequestLoggingFilter(LogDetail.METHOD),
                            new ResponseLoggingFilter(LogDetail.STATUS));
    }

    protected void reportPerfIfSlow(String method, String path, long elapsedMs) {
        if (elapsedMs > perfThresholdMs) {
            System.err.printf("PERF WARNING: %s %s took %d ms (>%d ms)%n",
                    method, path, elapsedMs, perfThresholdMs);
        }
    }
}
