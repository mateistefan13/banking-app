package com.bankingproject.service;

import com.bankingproject.dto.BankAccount;
import com.bankingproject.dto.Transaction;
import com.bankingproject.repository.TransactionCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionService {

    TransactionCache transactionCache;

    @Autowired
    TransactionService(TransactionCache transactionCache) {

        this.transactionCache = transactionCache;
    }

    public boolean addTransaction(BankAccount sender, BankAccount receiver, Double amount) {

        return transactionCache.add(sender, receiver, amount);
    }

    public boolean addTransaction(BankAccount bankAccount, Double amount) {

        return transactionCache.add(bankAccount, amount);
    }

    public Transaction get(BankAccount sender, BankAccount receiver) {

        return transactionCache.get(sender, receiver);
    }

    public boolean delete(Long id) {

        return transactionCache.delete(id);
    }

    public boolean delete(BankAccount sender, BankAccount receiver) {

        return transactionCache.delete(sender, receiver);
    }

    public boolean delete(Transaction transaction) {

        return transactionCache.delete(transaction);
    }

    public List<Transaction> getAllFromAccount(BankAccount bankAccount) {

        return transactionCache.getAllFromAccount(bankAccount);
    }

    public List<Transaction> getAll(BankAccount bankAccount) {

        return transactionCache.getAll(bankAccount);
    }

    public String generateTransactionsReport(BankAccount bankAccount) {

        if (bankAccount == null) {
            System.out.println("The specified bank account does not exist.");
        }

        String str = "The bank account with the id of " + bankAccount.getId() + " has the following transactions: \n";

        for (Transaction transaction : this.getAllFromAccount(bankAccount)) {
            str += transaction.toString() + "\n";
        }

        return str;
    }

}
