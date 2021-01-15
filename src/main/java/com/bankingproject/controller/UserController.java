package com.bankingproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import  com.bankingproject.dto.BankAccount;
import  com.bankingproject.dto.Transaction;
import  com.bankingproject.model.User;
import  com.bankingproject.service.AccountService;
import  com.bankingproject.service.ClientService;

@Component
public abstract class UserController {

    private AccountService accountService;
    private ClientService clientService;

    public UserController() {

    }

    @Autowired
    public UserController(AccountService accountService, ClientService clientService) {

        this.accountService = accountService;
        this.clientService = clientService;
    }

    public List<BankAccount> getUserBankAccounts(User user) {

        return user.getBankAccounts();
    }

    public Double getUserBankAccountFunds(User user, long bankAccountId) {

        return accountService.getUserBankAccountFunds(user, bankAccountId);
    }

    public boolean transferFunds(String transfererIBAN, String transferToIBAN, Double amount) {

        return accountService.transferFunds(transfererIBAN, transferToIBAN, amount);
    }

    public boolean selfTransferFunds(String username, Double amount, String transferFromIBAN, String transferToIBAN) {

        return accountService.selfTransferFunds(username, amount, transferFromIBAN, transferToIBAN);
    }

    public List<Transaction> getUserTransactions(User user) {

        return clientService.getUserTransactions(user);
    }

    public String generateTransactionsReport(User user) {

        return clientService.generateTransactionsReport(user);
    }

}
