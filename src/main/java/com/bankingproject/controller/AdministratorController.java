package com.bankingproject.controller;

import com.bankingproject.dto.CreditBankAccountDTO;
import com.bankingproject.dto.DebitBankAccountDTO;
import com.bankingproject.model.PersoanaFizica;
import com.bankingproject.model.PersoanaJuridica;
import com.bankingproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdministratorController {

    private AdminService adminService;

    @Autowired
    public AdministratorController(AdminService adminService) {

        this.adminService = adminService;
    }

    public PersoanaFizica createPersoanaFizica(String nume, String prenume, String username, String CNP,
                                               Double salariu) {

        return adminService.createPersoanaFizica(nume, prenume, username, CNP, salariu);
    }

    public PersoanaJuridica createPersoanaJuridica(String numeCompanie, String username, String CUI,
                                                   Double costTranzactie, Double capital) {

        return adminService.createPersoanaJuridica(numeCompanie, username, CUI, costTranzactie, capital);
    }

    public DebitBankAccountDTO createDebitAccount(String username) {

        return adminService.createDebitAccount(username);
    }

    public CreditBankAccountDTO createCreditAccount(String username) {

        return adminService.createCreditAccount(username);
    }
}
