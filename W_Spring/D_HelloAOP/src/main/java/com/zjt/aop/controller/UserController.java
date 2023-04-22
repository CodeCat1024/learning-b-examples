package com.zjt.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/sayhi")
    public String sayHi() {
        System.out.println("sayhi方法被执行");
        return "Hi World";
    }

    @RequestMapping("/sayhello")
    public String sayHello() {
        System.out.println("sayhello方法被执行");
        // int num = 5 / 0; // 测试 AfterThrowing 方法
        return "Hello World";
    }

}
