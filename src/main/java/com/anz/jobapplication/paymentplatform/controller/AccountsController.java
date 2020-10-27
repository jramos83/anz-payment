package com.anz.jobapplication.paymentplatform.controller;

import com.anz.jobapplication.paymentplatform.domain.Account;
import com.anz.jobapplication.paymentplatform.domain.User;
import com.anz.jobapplication.paymentplatform.exception.ResourceNotFoundException;
import com.anz.jobapplication.paymentplatform.mapper.AccountsMapper;
import com.anz.jobapplication.paymentplatform.response.ListAccountsResponse;
import com.anz.jobapplication.paymentplatform.service.AccountsService;
import com.anz.jobapplication.paymentplatform.service.UserService;
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
@RequestMapping(path = "/v1/user/{userid}/accounts")
@Api(value = "Accounts Resource", description = "API for Accounts Resource")
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountsMapper accountsMapper;

    @GetMapping
    @ApiOperation(value = "Lists all accounts for a specified user")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 404, message = "User Not Found"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),
                    @ApiResponse(code = 200, message = "Successful")
            }
    )
    public ListAccountsResponse getAccounts(@PathVariable(name = "userid") Long userId) {

        Optional<User> user = userService.findById(userId);

        if (user.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        List<Account> accounts = accountsService.findByUserId(userId);

        ListAccountsResponse listAccountsResponse = new ListAccountsResponse();
        listAccountsResponse.setAccountsResponses(accountsMapper.map(accounts));

        return listAccountsResponse;

    }
}
