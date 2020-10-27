package com.anz.jobapplication.paymentplatform.controller;

import com.anz.jobapplication.paymentplatform.domain.Account;
import com.anz.jobapplication.paymentplatform.domain.Transaction;
import com.anz.jobapplication.paymentplatform.exception.ResourceNotFoundException;
import com.anz.jobapplication.paymentplatform.mapper.TransactionsMapper;
import com.anz.jobapplication.paymentplatform.response.ListTransactionsResponse;
import com.anz.jobapplication.paymentplatform.service.AccountsService;
import com.anz.jobapplication.paymentplatform.service.TransactionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/account/{accountid}/transactions")
@Api(value = "Transactions Resource", description = "API for Transactions Resource")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private AccountsService accountsService;

    @Autowired
    private TransactionsMapper transactionsMapper;

    @GetMapping
    @ApiOperation(value = "Lists all transactions for a specified account")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 404, message = "Account Not Found"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),
                    @ApiResponse(code = 200, message = "Successful")
            }
    )
    public ListTransactionsResponse getTransactions(@PathVariable(name = "accountid") Long accountId) {

        Optional<Account> account = accountsService.findById(accountId);

        if(account.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        List<Transaction> transactions = transactionsService.findAllByAccountId(account.get().getId());

        ListTransactionsResponse listTransactionsResponse = new ListTransactionsResponse();
        listTransactionsResponse.setTransactionsResponses(transactionsMapper.map(transactions));
        return listTransactionsResponse;

    }
}
