package com.anz.jobapplication.paymentplatform.mapper;

import com.anz.jobapplication.paymentplatform.domain.Account;
import com.anz.jobapplication.paymentplatform.domain.AccountType;
import com.anz.jobapplication.paymentplatform.domain.Currency;
import com.anz.jobapplication.paymentplatform.domain.Transaction;
import com.anz.jobapplication.paymentplatform.response.AccountsResponse;
import com.anz.jobapplication.paymentplatform.response.TransactionsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        TransactionsMapperImpl.class})
public class TransactionsMapperTest {

    @Autowired
    private TransactionsMapper transactionsMapper;

    @Test
    public void testTransactionsMapper() {

        long testId = 1l;
        long testAccountId = 2l;
        LocalDate testBalanceDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        String testAccountName = "test-account-name";
        String testAccountNumber = "12456";
        Currency testCurrency = Currency.AUD;
        BigDecimal testOpeningBalance = BigDecimal.valueOf(4000);
        BigDecimal transactionAmount = BigDecimal.valueOf(50);
        String transactionNarrative = "test-transaction-narrative";

        Account account = new Account();
        account.setId(testAccountId);
        account.setAccountName(testAccountName);
        account.setCurrency(testCurrency);
        account.setAccountNumber(testAccountNumber);

        Transaction transaction = new Transaction();
        transaction.setId(testId);
        transaction.setAccount(account);
        transaction.setAmount(transactionAmount);
        transaction.setTransactionTimestamp(localDateTime);
        transaction.setTransactionNarrative(transactionNarrative);

        List<TransactionsResponse> transactionResponses = transactionsMapper.map(List.of(transaction));

        TransactionsResponse transactionResponse = transactionResponses.get(0);

        Assertions.assertEquals(testId, transactionResponse.getId());
        Assertions.assertEquals(localDateTime, transactionResponse.getTransactionTimestamp());
        Assertions.assertEquals(transactionNarrative, transactionResponse.getTransactionNarrative());


    }
}
