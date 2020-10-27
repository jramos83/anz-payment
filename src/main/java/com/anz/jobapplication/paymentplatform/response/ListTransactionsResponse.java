package com.anz.jobapplication.paymentplatform.response;

import lombok.Data;

import java.util.List;

@Data
public class ListTransactionsResponse {
    private List<TransactionsResponse> transactionsResponses;
}
