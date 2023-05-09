package com.example.demo.b_get;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class I_Session {
    /**
     * 创建，设置，获取 session
     * HttpServletRequest 和 HttpSession 的更多方法 API 请前往 Java EE API文档查看
     */
    @RequestMapping("/session")
    public String setSession(HttpServletRequest request) {
        // 创建（ true 表示没有 session 则新创建一个，false 表示没有 session 则返回 null）
        HttpSession session = request.getSession(true);
        // 设置
        session.setAttribute("username", "Kate");
        session.setAttribute("age", "120");
        // 获取
        return "session中的username为：" + session.getAttribute("username") + "<br>" +
                "session中的age为：" + session.getAttribute("age") + "<br>";
    }


    /**
     * 更简单的获取 session 的方法
     * 只有 session 存在才能获取到里面的值（也就是得当 session 先创建好之后）
     * 这里 required = false 表示如果要获取的session属性不存在也不会报错，就返回null
     * 如果 required = true  表示如果要获取的session属性不存在就直接报错
     */
    @RequestMapping("/simple-get-session")
    public String getSession(@SessionAttribute(value = "username", required = false) String username) {
        return "session中的username为：" + username;
    }
}
