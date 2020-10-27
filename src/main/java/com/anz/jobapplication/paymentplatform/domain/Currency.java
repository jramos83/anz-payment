package com.anz.jobapplication.paymentplatform.domain;

public enum Currency {
    SGD("Singaporean Dollar"), AUD("Australian Dollar");

    private String description;

    private Currency(String description) {
        this.description = description;
    }
}
