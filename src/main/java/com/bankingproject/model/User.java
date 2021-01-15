package com.bankingproject.model;

import com.bankingproject.dto.BankAccount;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class User {

    public String username;
    public List<BankAccount> bankAccounts = new ArrayList<>();
    public Long uniqueId;

    public void addBankAccount(BankAccount bankAccount) {

        this.bankAccounts.add(bankAccount);
    }
}
