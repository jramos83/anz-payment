package com.anz.jobapplication.paymentplatform.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;
}
