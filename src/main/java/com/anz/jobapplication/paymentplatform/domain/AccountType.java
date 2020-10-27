package com.anz.jobapplication.paymentplatform.domain;

public enum AccountType {

    Savings("Savings"), Current("Current");

    private String description;

    private AccountType(String description) {
        this.description = description;
    }
}
