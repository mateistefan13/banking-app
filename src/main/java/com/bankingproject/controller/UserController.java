package com.bankingproject.controller;

import java.util.List;

import com.bankingproject.entity.User;
import com.bankingproject.service.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import  com.bankingproject.dto.BankAccount;
import  com.bankingproject.dto.Transaction;
import  com.bankingproject.service.AccountService;
import  com.bankingproject.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private AccountService accountService;
    private ClientService clientService;
    private UserService userService;

    @Autowired
    public UserController(AccountService accountService,
                          ClientService clientService,
                          UserService userService) {

        this.accountService = accountService;
        this.clientService = clientService;
        this.userService = userService;
    }


    @GetMapping
    public HttpEntity<List<User>> findAllUsers() {

        return ResponseEntity.ok(this.userService.findAllUsers());
    }

    /*
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


     */
}
