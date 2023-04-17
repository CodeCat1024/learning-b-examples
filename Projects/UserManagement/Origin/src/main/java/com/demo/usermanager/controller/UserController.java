package com.demo.usermanager.controller;

import com.demo.usermanager.model.UserInfo;
import com.demo.usermanager.service.UserService;
import com.demo.usermanager.util.ConstVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public boolean login(HttpServletRequest request, String loginname, String password){
        // 先做非空校验
        if (StringUtils.hasLength(loginname) && StringUtils.hasLength(password)) {
            UserInfo userInfo = userService.login(loginname, password);
            if(userInfo != null && userInfo.getUid() > 0)  {
                // 存储 session
                HttpSession session = request.getSession(true);
                session.setAttribute(ConstVariable.USER_SESSION_KEY, userInfo);
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/list")
    public List<UserInfo> getAll() {
        return userService.getAll();
    }
}
