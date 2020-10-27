package com.anz.jobapplication.paymentplatform.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "accounts")
public class Account {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @Column(name = "account_name", unique = true)
    private String accountName;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @Column(name = "balance_date")
    private LocalDate balanceDate;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Transient
    private BigDecimal openingBalance;
}
