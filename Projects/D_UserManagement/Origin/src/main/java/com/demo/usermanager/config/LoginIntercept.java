package com.demo.usermanager.config;

import com.demo.usermanager.util.ConstVariable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 自定义拦截器
 */

@Component
public class LoginIntercept implements HandlerInterceptor {
    /**
     * true 表示用户已经登录，会继续访问目标方法
     * false 表示未登录，会跳转到登录页面
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(ConstVariable.USER_SESSION_KEY) != null ) {
            return true;
        }
        // 未登录则跳转到登录页面
        response.sendRedirect("/login.html");
        return false;
    }
}
