package com.example.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @ResponseBody
    //@GetMapping("sayHi")
    @PostMapping("/sayHi")
    public String sayHi() {
        return "Hello Spring Boot";
    }
}
