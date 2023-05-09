package com.example.demo.c_get;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取 URL 中的参数
 */
@RestController
public class D_GetURLParameter {
    @RequestMapping("/geturlparameter/{parameter1}/{parameter2}")
    public String getURLParameter(@PathVariable String parameter1, @PathVariable String parameter2) {
        return "接收到的URL参数为：" + parameter1 + " 和 " + parameter2;
    }
}
