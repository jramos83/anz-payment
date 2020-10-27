package com.anz.jobapplication.paymentplatform.response;

import com.anz.jobapplication.paymentplatform.domain.AccountType;
import com.anz.jobapplication.paymentplatform.domain.Currency;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AccountsResponse {

    private Long id;

    private String accountNumber;

    private String accountName;

    private AccountType accountType;

    private LocalDate balanceDate;

    private Currency currency;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal openingBalance;
}
