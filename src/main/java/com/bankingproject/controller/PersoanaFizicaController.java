package com.bankingproject.controller;

import com.bankingproject.service.AccountService;
import com.bankingproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersoanaFizicaController extends UserController {

    private AccountService accountService;
    private ClientService clientService;

    @Autowired
    public PersoanaFizicaController(AccountService accountService, ClientService clientService) {

        super(accountService, clientService);
        this.accountService = accountService;
    }
}
