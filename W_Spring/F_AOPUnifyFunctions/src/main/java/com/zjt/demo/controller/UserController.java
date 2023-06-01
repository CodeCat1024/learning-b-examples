package com.zjt.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public boolean login(HttpServletRequest request, String username, String password) {
        boolean result = false;
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
            if (username.equals("admin") && password.equals("admin")) {
                HttpSession session = request.getSession();
                session.setAttribute("userinfo", "userinfo");
                result = true;
            }
        }
        return result;
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request, String username, String password) {
         // 算术异常测试
         // int a = 4 / 0;

        // 空指针异常测试
        // Object obj = null;
        // System.out.println(obj.hashCode());

        return "Hello Index";
    }
}
