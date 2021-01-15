package com.bankingproject.service;

import com.bankingproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    private AccountService accountService;

    @Autowired
    public LoginService(AccountService accountService) {

        this.accountService = accountService;
    }

    public boolean clientLogin(String username) {

        for (User usr : accountService.getUsers()) {
            if (usr.getUsername().equalsIgnoreCase(username)) {
                System.out.println(String.format("User %s is logged.", username));
                return true;
            }
        }


        System.out.println(String.format("User %s is not in our system.", username));
        return false;
    }
}
