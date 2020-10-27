package com.anz.jobapplication.paymentplatform.response;

import lombok.Data;

import java.util.List;

@Data
public class ListAccountsResponse {
    private List<AccountsResponse> accountsResponses;
}
