package com.bankingproject.model;

import com.bankingproject.dto.BankAccount;
import com.bankingproject.utils.IdGeneratingClass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PersoanaJuridica extends User {

    private String numeCompanie;
    private String username;
    private String CUI;
    private Long uniqueId;
    private List<BankAccount> bankAccounts;
    private Double costTranzactie;
    private Double capital;

    public PersoanaJuridica() {

        this.uniqueId = IdGeneratingClass.generateIdForClient.incrementAndGet();
    }

    public PersoanaJuridica(String numeCompanie, String username, String CUI, Double costTranzactie, Double capital) {

        this.numeCompanie = numeCompanie;
        this.username = username;
        this.CUI = CUI;
        this.uniqueId = IdGeneratingClass.generateIdForClient.incrementAndGet();
        this.costTranzactie = costTranzactie;
        this.capital = capital;
    }

}
