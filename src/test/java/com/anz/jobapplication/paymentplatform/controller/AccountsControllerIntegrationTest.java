package com.anz.jobapplication.paymentplatform.controller;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class AccountsControllerIntegrationTest {

    @Test
    public void test_statuscode_is_ok() {
        RestAssured.get("/v1/user/1/accounts").then().statusCode(200);
    }

    @Test
    public void test_statuscode_is_not_found() {
        RestAssured.get("/v1/user/5/accounts").then().statusCode(404);
    }

    @Test
    public void test_body_is_as_expected() {
        String returnedBody = RestAssured.get("/v1/user/1/accounts").then().extract().asString();
        log.info(returnedBody);
        String expectedBody = "{\"accountsResponses\":[{\"id\":1,\"accountNumber\":\"123456789\",\"accountName\":\"John Doe Savings\",\"accountType\":\"Savings\",\"balanceDate\":\"2020-10-27\",\"currency\":\"AUD\",\"openingBalance\":0.00},{\"id\":2,\"accountNumber\":\"123456790\",\"accountName\":\"John Doe Checking\",\"accountType\":\"Current\",\"balanceDate\":\"2020-10-27\",\"currency\":\"AUD\",\"openingBalance\":500.00}]}";
        Assertions.assertEquals(expectedBody, returnedBody);
    }

    @Test
    public void test_body_is_as_expected2() {
        String returnedBody = RestAssured.get("/v1/user/2/accounts").then().extract().asString();
        log.info(returnedBody);
        String expectedBody = "{\"accountsResponses\":[{\"id\":3,\"accountNumber\":\"123456791\",\"accountName\":\"Marry Poppins Savings\",\"accountType\":\"Savings\",\"balanceDate\":\"2020-10-27\",\"currency\":\"AUD\",\"openingBalance\":2000.00}]}";
        Assertions.assertEquals(expectedBody, returnedBody);
    }
}
