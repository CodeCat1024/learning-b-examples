package com.zjt.demo.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 实现登录拦截器
 */
@Component
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
        if(session != null && session.getAttribute("userinfo") != null) {
            // 表示已经登录
            return true;
        }
        // 用重定向会更好，不用承担那么多的责任，才不会存在Web资源丢失的问题
        response.sendRedirect("/login.html");
        return false;
    }
}
