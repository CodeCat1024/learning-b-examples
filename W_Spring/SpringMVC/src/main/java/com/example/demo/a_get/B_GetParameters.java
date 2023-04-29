package com.example.demo.a_get;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接收多个参数
 */
@RestController
public class B_GetParameters {
    @RequestMapping("/getparameters")
    public String getParameters(String username, String password) {
        return "用户名为：" + username + " || " + "密码为：" + password;
    }
}
