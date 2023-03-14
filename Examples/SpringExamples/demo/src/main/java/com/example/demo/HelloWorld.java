package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/HelloWorld")
public class HelloWorld {

    @Value("${server.port}")
    private String port;

    @Value("${my.message}")
    private String HelloWorld;

    @ResponseBody
    @RequestMapping("/sayHi")
    public String sayHi() {
        return "My Hello World is " + HelloWorld;
    }

}
