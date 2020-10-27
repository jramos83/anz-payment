package com.anz.jobapplication.paymentplatform.service;

import com.anz.jobapplication.paymentplatform.domain.Transaction;
import com.anz.jobapplication.paymentplatform.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    public List<Transaction> findAllByAccountId(Long accountId) {
        return transactionsRepository.findAllByAccountId(accountId);
    }
}
