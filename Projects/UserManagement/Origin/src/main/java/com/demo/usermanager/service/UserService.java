package com.demo.usermanager.service;

import com.demo.usermanager.mapper.UserMapper;
import com.demo.usermanager.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    // 登录功能
    public UserInfo login(String loginname, String password) {
        return userMapper.login(loginname, password);
    }

    // 获取所有用户
    public List<UserInfo> getAll() {
        return userMapper.getAll();
    }

}
