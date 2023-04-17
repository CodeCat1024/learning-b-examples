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

    // 添加用户
    public int add(UserInfo userInfo) {
        System.out.println("已经走到service这里了");
        return userMapper.add(userInfo);
    }

    // 根据登录名查询用户
    public UserInfo getUserByLoginName(String loginname) {
        return userMapper.getUserByLoginName(loginname);
    }

    // 根据uid返回用户
    public UserInfo getUserByUid(Integer uid) { return userMapper.getUserByUid(uid);}

    // 修改用户信息
    public int update(UserInfo userInfo) {
        return userMapper.update(userInfo);
    }

    // 删除单个用户
    public int del(Integer uid) {
        return userMapper.del(uid);
    }
}
