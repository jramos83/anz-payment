package com.anz.jobapplication.paymentplatform.mapper;

import com.anz.jobapplication.paymentplatform.domain.Account;
import com.anz.jobapplication.paymentplatform.domain.AccountType;
import com.anz.jobapplication.paymentplatform.domain.Currency;
import com.anz.jobapplication.paymentplatform.response.AccountsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        AccountsMapperImpl.class})
public class AccountsMapperTest {

    @Autowired
    private AccountsMapper accountsMapper;

    @Test
    public void testAccountsMapper() {

        long testId = 1l;
        LocalDate testBalanceDate = LocalDate.now();
        String testAccountName = "test-account-name";
        AccountType testAccountType = AccountType.Savings;
        String testAccountNumber = "12456";
        Currency testCurrency = Currency.AUD;
        BigDecimal testOpeningBalance = BigDecimal.valueOf(4000);

        Account account = new Account();
        account.setId(testId);
        account.setAccountName(testAccountName);
        account.setAccountType(testAccountType);
        account.setAccountNumber(testAccountNumber);
        account.setBalanceDate(testBalanceDate);
        account.setCurrency(testCurrency);
        account.setOpeningBalance(testOpeningBalance);

        List<AccountsResponse> accountsResponses = accountsMapper.map(List.of(account));

        AccountsResponse accountsResponse = accountsResponses.get(0);

        Assertions.assertEquals(testId, accountsResponse.getId());
        Assertions.assertEquals(testAccountName, accountsResponse.getAccountName());
        Assertions.assertEquals(testAccountType, accountsResponse.getAccountType());
        Assertions.assertEquals(testAccountNumber, accountsResponse.getAccountNumber());
        Assertions.assertEquals(testBalanceDate, accountsResponse.getBalanceDate());
        Assertions.assertEquals(testCurrency, accountsResponse.getCurrency());
        Assertions.assertEquals(testOpeningBalance, accountsResponse.getOpeningBalance());

    }
}
