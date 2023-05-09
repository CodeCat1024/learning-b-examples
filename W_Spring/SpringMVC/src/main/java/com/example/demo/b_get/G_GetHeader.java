package com.example.demo.b_get;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 获取 header 中的信息
 */
@RestController
public class G_GetHeader {
    @RequestMapping("/get-header")
    public String getHead(HttpServletRequest request){
        return "获取到的 User-Agent 为：" + request.getHeader("User-Agent") + "<br>" +
                "获取到的 Cookies 为：" + request.getHeader("Cookie");
    }

    @RequestMapping("/simple-get-header")
    public String getHeader(@RequestHeader("User-Agent") String userAgent,
                            @RequestHeader("Cookie") String cookie) {
        return "获取到的 User-Agent 为：" + userAgent + "<br>" +
                "获取到的 Cookies 为：" + cookie + "<br>";
    }
}
