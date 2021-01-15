package com.bankingproject.dto;

import com.bankingproject.utils.IdGeneratingClass;
import lombok.Data;

@Data
public class DebitBankAccountDTO extends BankAccount {

    private Long id;
    private Double amount;
    private Long ownerId;
    private String IBAN;

    public DebitBankAccountDTO(Double amount, Long ownerId, String IBAN) {

        this.id = IdGeneratingClass.generateIdForBankAccount.incrementAndGet();
        this.amount = amount;
        this.ownerId = ownerId;
        this.IBAN = IBAN;
    }

    public DebitBankAccountDTO() {

    }

}



