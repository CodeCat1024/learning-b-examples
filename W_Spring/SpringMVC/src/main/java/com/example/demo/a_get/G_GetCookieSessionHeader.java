package com.example.demo.a_get;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class G_GetCookieSessionHeader {
    @RequestMapping("/getcookie")
    public String getCookie() {
        return "获取到的Cookie为： ";
    }
    @RequestMapping("/getsession")
    public String getSession() {
        return "获取到的Session为： ";
    }
    @RequestMapping("/getheader")
    public String getHeader() {
        return "获取到的Header为： ";
    }
}
