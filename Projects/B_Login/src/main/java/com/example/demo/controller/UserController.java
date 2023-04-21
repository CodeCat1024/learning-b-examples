package com.example.demo.controller;

import com.example.demo.model.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 登录功能
    @RequestMapping("/login")
    public boolean login2(String loginname, String password){
        // 非空校验
        if (StringUtils.hasLength(loginname) && StringUtils.hasLength(password)) {
            UserInfo userInfo = userService.login(loginname, password);
            if(userInfo != null && userInfo.getUid() > 0)  {
                return true;
            }
        }
        return false;
    }
}
