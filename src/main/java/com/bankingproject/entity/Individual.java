package com.bankingproject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "individuals")
@Data
public class Individual {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String personalIdentificationNumber;

    private Double salary;

    @OneToOne
    private User user;
}
