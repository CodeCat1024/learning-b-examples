package com.example.demo.c_return;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求重定向
 * 重定向发生在客户端，也就是让服务器重新发送HTTP请求
 * 也就是告诉服务器你得重新去写信
 */

@Controller
public class E_Redirect {
    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:/index.html";
    }
}
