package com.bankingproject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "firms")
@Data
public class Firm {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    private Double transactionCost;

    private Double capital;

    @OneToOne
    private User user;
}
