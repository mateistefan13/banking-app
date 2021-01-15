package com.bankingproject.service;

import com.bankingproject.entity.User;
import com.bankingproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {

        return this.userRepository.findAll();
    }
}
