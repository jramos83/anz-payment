package com.anz.jobapplication.paymentplatform.repository;

import com.anz.jobapplication.paymentplatform.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {

    public List<Account> findByUserId(Long userId);

    @Query(value = "SELECT SUM(CASE WHEN TRANSACTION_TYPE = 'CREDIT' THEN AMOUNT  ELSE AMOUNT * -1 END)  FROM TRANSACTIONS WHERE ACCOUNT_ID = ? AND TRANSACTION_TIMESTAMP < ?", nativeQuery = true)
    public BigDecimal getBalanceForAccount(Long accountId, LocalDate balanceDate);

}
