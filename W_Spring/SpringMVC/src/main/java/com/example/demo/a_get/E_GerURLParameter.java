package com.example.demo.a_get;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class E_GerURLParameter {
    @RequestMapping("/geturlparameter/{parameter1}/{parameter2}")
    public String getURLParameter(@PathVariable String parameter1, @PathVariable String parameter2) {
        return "接收到的URL参数为：" + parameter1 + " 和 " + parameter2;
    }
}
