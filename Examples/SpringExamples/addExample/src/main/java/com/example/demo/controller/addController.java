package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class addController {

    @RequestMapping("/index")
    public String index(){return "index.html";}


    @RequestMapping("/add")
    @ResponseBody
    public String add(Integer num1, Integer num2){
//
//        if(num1 == null || num2 == null){
//            return "参数错误";
//        }
        return "<h1>结果：" + (num1 + num2) + "</h1>";
    }

    @RequestMapping("/login")
    @ResponseBody
    public HashMap<String, Object> login(String username, String password){
        HashMap<String, Object> result = new HashMap<String, Object>();
        int state = 200;
        int data = -1;
        String msg = "未知错误";
        if(StringUtils.hasLength(username) && StringUtils.hasLength(password)){
            if(username.equals("admin") && password.equals("admin")){
                data = 1;
                msg = "";
            } else {
                msg =  "用户名或密码错误！";
            }
        }else {
            msg =  "非法参数";
        }
        result.put("state", state);
        result.put("data", data);
        result.put("msg", msg);
        return result;
    }

    @RequestMapping("/forward2")
    public void myForward2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/hello.html").forward(request, response);
    }

    @RequestMapping("/re2")
    public void myRedirect2(HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.html");
    }

    @RequestMapping("/re1")
    public String myRedirect(){
        return "redirect:/index.html";
    }

}
