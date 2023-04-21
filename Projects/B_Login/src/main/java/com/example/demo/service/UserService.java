package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    // 登录功能
    public UserInfo login(String loginname, String password) {
        return userMapper.login(loginname, password);
    }
}
