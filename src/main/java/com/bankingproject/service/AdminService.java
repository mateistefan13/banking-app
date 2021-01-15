package com.bankingproject.service;

import com.bankingproject.dto.CreditBankAccountDTO;
import com.bankingproject.dto.DebitBankAccountDTO;
import com.bankingproject.model.PersoanaFizica;
import com.bankingproject.model.PersoanaJuridica;
import com.bankingproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

    private AccountService accountService;

    @Autowired
    public AdminService(AccountService accountService) {

        this.accountService = accountService;
    }

    public PersoanaFizica createPersoanaFizica(String nume, String prenume, String username, String CNP,
                                               Double salariu) {

        PersoanaFizica user = new PersoanaFizica(nume, prenume, username, CNP, salariu);
        accountService.addUser(user);
        return user;
    }

    public PersoanaJuridica createPersoanaJuridica(String numeCompanie, String username, String CUI,
                                                   Double costTranzactie, Double capital) {

        PersoanaJuridica user = new PersoanaJuridica(numeCompanie, username, CUI, costTranzactie, capital);
        accountService.addUser(user);
        return user;
    }

    public DebitBankAccountDTO createDebitAccount(String username) {

        DebitBankAccountDTO account = new DebitBankAccountDTO(0.0, accountService.getUserId(username),
                "RODEBITROBU" + accountService.getUserId(username));
        accountService.addBankAccount(account);
        return account;
    }

    public CreditBankAccountDTO createCreditAccount(String username) {

        User usr = accountService.getUser(username);

        if (usr == null) {
            return null;
        }

        Double limitAmount;
        if (usr instanceof PersoanaFizica) {
            limitAmount = ((PersoanaFizica) usr).getSalariu();
        } else {
            limitAmount = ((PersoanaJuridica) usr).getCapital() % 10;
        }

        CreditBankAccountDTO account = new CreditBankAccountDTO(accountService.getUserId(username), limitAmount, limitAmount,
                "ROCREDITROBU" + accountService.getUserId(username));
        accountService.addBankAccount(account);
        return account;
    }
}
