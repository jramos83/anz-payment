package com.anz.jobapplication.paymentplatform.controller;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
public class TransactionsControllerIntegrationTest {
    @Test
    public void test_statuscode_is_ok() {
        RestAssured.get("/v1/account/1/transactions").then().log().all().statusCode(200);
    }

    @Test
    public void test_body_is_as_expected() {
        String returnedBody = RestAssured.get("/v1/account/1/transactions").then().extract().asString();
        log.info(returnedBody);
        String expectedBody = "{\"transactionsResponses\":[{\"id\":1,\"account\":{\"id\":1,\"accountNumber\":\"123456789\",\"accountName\":\"John Doe Savings\",\"accountType\":\"Savings\",\"balanceDate\":\"2020-10-27\",\"currency\":\"AUD\"},\"transactionType\":\"CREDIT\",\"amount\":1000.00,\"transactionTimestamp\":\"2020-10-26T10:00:59\",\"transactionNarrative\":\"Salary\"},{\"id\":2,\"account\":{\"id\":1,\"accountNumber\":\"123456789\",\"accountName\":\"John Doe Savings\",\"accountType\":\"Savings\",\"balanceDate\":\"2020-10-27\",\"currency\":\"AUD\"},\"transactionType\":\"DEBIT\",\"amount\":1000.00,\"transactionTimestamp\":\"2020-10-26T11:00:59\",\"transactionNarrative\":\"Transfer to Checking\"}]}";
        Assertions.assertEquals(expectedBody, returnedBody);
    }
}