package com.bankingproject.controller;

import com.bankingproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {

        this.loginService = loginService;
    }

    public boolean clientLogin(String username) {

        return this.loginService.clientLogin(username.trim());
    }
}
