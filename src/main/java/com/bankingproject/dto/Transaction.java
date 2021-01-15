package com.bankingproject.dto;

import com.bankingproject.utils.IdGeneratingClass;
import lombok.Data;

@Data
public class Transaction {

    private Long id;
    private BankAccount sender;
    private BankAccount receiver;
    private Double amount;

    public Transaction(BankAccount sender, BankAccount receiver, Double amount) {

        this.id = IdGeneratingClass.generateIdForTransaction.incrementAndGet();
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public Transaction(BankAccount sender, Double amount) {

        this.id = IdGeneratingClass.generateIdForTransaction.incrementAndGet();
        this.sender = sender;
        this.amount = amount;
    }
}
