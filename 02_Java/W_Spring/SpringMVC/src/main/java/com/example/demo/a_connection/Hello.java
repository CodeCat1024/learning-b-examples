package com.example.demo.a_connection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class Hello {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
