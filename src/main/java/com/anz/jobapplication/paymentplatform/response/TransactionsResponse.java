package com.anz.jobapplication.paymentplatform.response;

import com.anz.jobapplication.paymentplatform.domain.Account;
import com.anz.jobapplication.paymentplatform.domain.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionsResponse {

    private Long id;

    private AccountsResponse account;

    private TransactionType transactionType;

    private BigDecimal amount;

    private LocalDateTime transactionTimestamp;

    private String transactionNarrative;
}
