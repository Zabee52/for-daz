package com.fordaz.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginContrller {
    @GetMapping("/hello")
    public String hello(){
        return "hello!";
    }
}
