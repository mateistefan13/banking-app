package com.bankingproject.model;

import com.bankingproject.dto.BankAccount;
import com.bankingproject.utils.IdGeneratingClass;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersoanaFizica extends User {


    private String nume;
    private String prenume;
    private String username;
    private String CNP;
    private Double salariu;
    private Long uniqueId;
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public PersoanaFizica() {

        this.uniqueId = IdGeneratingClass.generateIdForClient.incrementAndGet();
    }

    public PersoanaFizica(String nume, String prenume, String username, String CNP, Double salariu) {

        this.nume = nume;
        this.prenume = prenume;
        this.username = username;
        this.CNP = CNP;
        this.uniqueId = IdGeneratingClass.generateIdForClient.incrementAndGet();
        this.salariu = salariu;
    }

}
