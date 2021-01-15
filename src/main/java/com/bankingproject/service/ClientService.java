package com.bankingproject.service;

import com.bankingproject.dto.BankAccount;
import com.bankingproject.dto.Transaction;
import com.bankingproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService {

    private AccountService accountService;
    private TransactionService transactionService;

    @Autowired
    public ClientService(AccountService accountService, TransactionService transactionService) {

        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    public boolean transferFunds(String transfererAccountIBAN, String transferToAccountIBAN, Double amount) {

        return accountService.transferFunds(transfererAccountIBAN, transferToAccountIBAN, amount);
    }

    public boolean cashOut(User user, String IBAN, Double amount) {

        return accountService.withdraw(user, IBAN, amount);
    }

    public boolean deposit(User user, String IBAN, Double amount) {

        return accountService.deposit(user, IBAN, amount);
    }

    public boolean selfTransferFunds(String username, Double amount, String transferFromIBAN, String transferToIBAN) {

        return accountService.selfTransferFunds(username, amount, transferFromIBAN, transferToIBAN);
    }

    public List<BankAccount> getUserBankAccounts(User user) {

        return accountService.getUserBankAccounts(user);
    }

    public List<Transaction> getUserTransactions(User user) {

        List<Transaction> trxList = null;
        getUserBankAccounts(user).forEach(bankAccount -> trxList.addAll(transactionService.getAllFromAccount(bankAccount)));

        return trxList;
    }

    public String generateTransactionsReport(User user) {

        String str = "";
        for (BankAccount bankAccount : this.getUserBankAccounts(user)) {
            str += transactionService.generateTransactionsReport(bankAccount);
        }

        return str;
    }

}
