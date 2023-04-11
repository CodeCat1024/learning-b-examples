package com.zjt.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginIntercept implements HandlerInterceptor {

    /**
     * 返回 true 表示拦截判断通过，可以访问后面的接口
     * 返回 false 表示拦截未通过，直接返回结果给前端
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 得到HttpSession对象
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("userinfo") == null) {
            // 表示已经登录
            return true;
        }

        return false;
    }
}
