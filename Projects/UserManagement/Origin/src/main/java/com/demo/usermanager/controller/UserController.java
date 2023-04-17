package com.demo.usermanager.controller;

import com.demo.usermanager.model.UserInfo;
import com.demo.usermanager.service.UserService;
import com.demo.usermanager.util.ConstVariable;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 登录功能
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

    // 渲染主页数据
    @RequestMapping("/list")
    public List<UserInfo> getAll() {
        return userService.getAll();
    }

    // 添加用户（还存在问题）
    @RequestMapping("/add")
    public int add(UserInfo userInfo, HttpServletRequest request) {
        int result = 0;
        // 非空校验（isadmin默认是false，所以不需要判断）
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername()) ||
                                !StringUtils.hasLength(userInfo.getLoginname()) ||
                                !StringUtils.hasLength(userInfo.getPassword())) {
            return result;
        }
        System.out.println("已走到非空校验");

        // 判断必须为超级管理员，才能进行添加操作（健壮性增强）
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(ConstVariable.USER_SESSION_KEY) == null)return result;
        UserInfo loginUser = (UserInfo) session.getAttribute(ConstVariable.USER_SESSION_KEY);
        if (!loginUser.isIsadmin()) return result;
        System.out.println("已走到判断是否为管理员");

        // 对登录名做一个唯一校验
        UserInfo loginNameUser = userService.getUserByLoginName(userInfo.getLoginname());
        // 当前登录名是否存在的判断
        if (loginNameUser != null && loginNameUser.getUid() > 0) return result;
        System.out.println("已走到校验登录名");

        // 添加用户到数据库

        result = userService.add(userInfo);
        System.out.println("已完成添加操作");
        return result;
    }

    // 根据uid获取用户信息
    @RequestMapping("/getuserbyuid")
    public UserInfo getUserByUid(Integer uid) {
        UserInfo userInfo = null;
        // 先做非空校验
        if (uid == null || uid <= 0) return userInfo;

        // 查询数据库
        userInfo = userService.getUserByUid(uid);

        // 将密码隐藏掉
        userInfo.setPassword("");
        return userInfo;
    }

    @RequestMapping("/update")
    public int update(UserInfo userInfo, HttpServletRequest request) {
        int result = 0;

        // 非空校验（isadmin默认是false，所以不需要判断）
        if (userInfo == null || userInfo.getUid() <=0 ||
                !StringUtils.hasLength(userInfo.getUsername())) {
            return result;
        }
        System.out.println("已走到非空校验");

        // 判断必须为超级管理员，才能进行添加操作（健壮性增强）
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(ConstVariable.USER_SESSION_KEY) == null)return result;
        UserInfo loginUser = (UserInfo) session.getAttribute(ConstVariable.USER_SESSION_KEY);
        if (!loginUser.isIsadmin()) return result;


        // 执行修改操作
        result = userService.update(userInfo);

        return result;
    }



}
