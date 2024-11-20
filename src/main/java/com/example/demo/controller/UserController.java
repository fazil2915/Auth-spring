package com.example.demo.controller;

import com.example.demo.models.Users;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    public UserService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users users){
        return service.register(users);
    }
}
