package com.example.demo.c_return;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求重定向
 * 重定向发生在客户端，会重新发起请求
 */

@Controller
public class E_Redirect {
    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:/index.html";
    }
}
