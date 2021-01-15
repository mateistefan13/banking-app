package com.bankingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankingproject.service.AccountService;
import com.bankingproject.service.ClientService;

@Component
public class PersoanaJuridicaController extends UserController {

    private AccountService accountService;
    private ClientService clientService;

    @Autowired
    public PersoanaJuridicaController(AccountService accountService, ClientService clientService) {

        super(accountService, clientService);
        this.accountService = accountService;
    }
}
