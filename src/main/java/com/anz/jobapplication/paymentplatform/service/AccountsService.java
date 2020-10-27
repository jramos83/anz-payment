package com.anz.jobapplication.paymentplatform.service;

import com.anz.jobapplication.paymentplatform.domain.Account;
import com.anz.jobapplication.paymentplatform.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Transactional
    public List<Account> findByUserId(Long userId) {

        List<Account> accounts = accountsRepository.findByUserId(userId);

        for(Account account : accounts) {
            account.setOpeningBalance(accountsRepository.getBalanceForAccount(account.getId(), LocalDate.now()));
        }

        return accounts;
    }

    public Optional<Account> findById(Long id) {
        return accountsRepository.findById(id);
    }
}
