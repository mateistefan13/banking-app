package com.bankingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankingproject.service.AccountService;
import com.bankingproject.service.ClientService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersoanaJuridicaController {

    private AccountService accountService;
    private ClientService clientService;

    @Autowired
    public PersoanaJuridicaController(AccountService accountService, ClientService clientService) {


        this.accountService = accountService;
    }
}
