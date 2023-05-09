package com.example.demo.b_get;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 为啥前面 get-header 中已经能获取到 cookie了，这里还要继续获取 cookie 呢？
 * 因为 cookies 里面还有很多的 cookie
 */

@RestController
public class H_Cookies {

    /**
     * 先获取 cookies，再获取每个 cookie
     */
    @RequestMapping("/get-cookies")
    public String getCookie(HttpServletResponse response, HttpServletRequest request){
        String name = request.getParameter("name");
        // 获取所有的cookie信息
        Cookie[] cookies = request.getCookies();
        return  null;
    }

    /**
     * 更简单的获取每个 cookie 的方法
     */
    @RequestMapping("/simple-get-cookies")
    public String simpleGetCookies(@CookieValue("JSESSIONID") String cookie) {
        return "Cookies中的JSESSIONID为： " + cookie;
    }

}
