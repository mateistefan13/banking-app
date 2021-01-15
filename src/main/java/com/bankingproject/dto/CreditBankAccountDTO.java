package com.bankingproject.dto;

import com.bankingproject.utils.IdGeneratingClass;
import lombok.Data;

@Data
public class CreditBankAccountDTO extends BankAccount {

    private Long id;
    private Long ownerId;
    private Double amount;
    private Double limitAmount;
    private String IBAN;

    public CreditBankAccountDTO(Long ownerId, Double amount, Double limitAmount, String IBAN) {

        this.id = IdGeneratingClass.generateIdForBankAccount.incrementAndGet();
        this.ownerId = ownerId;
        this.amount = amount;
        this.limitAmount = limitAmount;
        this.IBAN = IBAN;
    }

    public CreditBankAccountDTO() {

    }
}
