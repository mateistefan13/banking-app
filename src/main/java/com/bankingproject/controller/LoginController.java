package com.bankingproject.controller;

import com.bankingproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
