package com.demo.usermanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/login")
    public boolean login(String loginname, String password){

        return false;
    }
}
