package com.zjt.usermanager.controller;

import com.zjt.usermanager.util.ConstVariable;
import com.zjt.usermanager.model.UserInfo;
import com.zjt.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 登录功能
    @RequestMapping("/login")
    public String login(HttpServletRequest request, String loginname, String password) {
        // 先进行非空校验
        if (StringUtils.hasLength(loginname) && StringUtils.hasLength(password)) {
            // 根据用户名和密码去数据库里查找对应的信息，并用userInfo接收返回的对象（如果在数据库中查不到该对象则会返回null）
            UserInfo userInfo = userService.login(loginname, password);
            if (userInfo != null && userInfo.getUid() > 0) {
                // 存储用户的session
                HttpSession session = request.getSession(true);
                session.setAttribute(ConstVariable.USER_SESSION_KEY, userInfo);

                // 进入主页面
                return "list.html";
            }
        }
        // 登录失败
        return "login.html";
    }

    // 用户列表页展示
    @RequestMapping
}
