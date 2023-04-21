package com.hjt.blog.service;

import com.hjt.blog.po.User;

public interface UserService {

    User checkUser(String username, String password);   //检查用户名和密码
}
