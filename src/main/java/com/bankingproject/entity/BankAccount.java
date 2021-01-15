package com.bankingproject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bank_accounts")
@Data
public class BankAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private Double amount;

    private String iban;

    @ManyToOne
    private User user;
}
