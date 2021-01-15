package com.bankingproject.controller;

import com.bankingproject.service.AccountService;
import com.bankingproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersoanaFizicaController {

    private AccountService accountService;
    private ClientService clientService;

    @Autowired
    public PersoanaFizicaController(AccountService accountService, ClientService clientService) {


        this.accountService = accountService;
    }
}
