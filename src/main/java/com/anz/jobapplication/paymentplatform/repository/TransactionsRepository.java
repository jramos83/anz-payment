package com.anz.jobapplication.paymentplatform.repository;

import com.anz.jobapplication.paymentplatform.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAccountId(Long id);
}
