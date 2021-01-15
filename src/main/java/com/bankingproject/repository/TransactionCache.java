package com.bankingproject.repository;


import com.bankingproject.dto.BankAccount;
import com.bankingproject.dto.Transaction;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class TransactionCache {

    private List<Transaction> transactions = new ArrayList<>();

    @Autowired
    TransactionCache() {

    }

    public boolean add(BankAccount sender, BankAccount receiver, Double amount) {

        return this.transactions.add(new Transaction(sender, receiver, amount));
    }

    public boolean add(BankAccount sender, Double amount) {

        return this.transactions.add(new Transaction(sender, amount));
    }

    public Transaction get(Long id) {

        if (transactions.stream().filter(transaction -> transaction.getId() == id).findAny().isEmpty()) {
            return null;
        }
        return transactions.stream().filter(transaction -> transaction.getId() == id).findAny().get();
    }

    public Transaction get(BankAccount sender, BankAccount receiver) {

        if (transactions.stream().filter(transaction -> transaction.getSender().equals(sender) &&
                transaction.getReceiver().equals(receiver)).findAny().isEmpty()) {
            return null;
        }

        return transactions.stream().filter(transaction -> transaction.getSender().equals(sender) &&
                transaction.getReceiver().equals(receiver)).findAny().get();
    }

    public List<Transaction> getAllFromAccount(BankAccount bankAccount) {

        if (transactions.stream().filter(transaction -> transaction.getSender().equals(bankAccount) ||
                transaction.getReceiver().equals(bankAccount)).findAny().isEmpty()) {
            return null;
        }

        return transactions.stream().filter(transaction -> transaction.getSender().equals(bankAccount) ||
                transaction.getReceiver().equals(bankAccount)).collect(Collectors.toList());
    }

    public List<Transaction> getAll(BankAccount bankAccount) {

        return this.transactions;
    }

    public boolean delete(Long id) {

        if (transactions.stream().filter(transaction -> transaction.getId() == id).findAny().isEmpty()) {
            return false;
        }
        Transaction trx = transactions.stream().filter(transaction -> transaction.getId() == id).findAny().get();

        return this.transactions.remove(trx);
    }

    public boolean delete(BankAccount sender, BankAccount receiver) {

        if (transactions.stream().
                filter(transaction -> transaction.getSender().equals(sender) && transaction.getReceiver().equals(receiver)).findAny().isEmpty()) {
            return false;
        }
        Transaction trx = transactions.stream().filter(transaction -> transaction.getSender().equals(sender) && transaction.getReceiver().equals(receiver)).findAny().get();

        return this.transactions.remove(trx);
    }

    public boolean delete(Transaction transaction) {

        return this.transactions.remove(transaction);
    }
}
