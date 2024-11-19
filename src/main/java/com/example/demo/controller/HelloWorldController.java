package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController{
    @GetMapping("/")
    public String helloWorld(HttpServletRequest request){
        return "Hello World! This is secured by Spring Security! " +request.getSession().getId();
    }
}