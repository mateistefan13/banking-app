package com.bankingproject.dto;

import lombok.Data;

@Data
public abstract class BankAccount {

    public Long id;
    public Long ownerId;
    public Double amount;
    public String IBAN;

}
