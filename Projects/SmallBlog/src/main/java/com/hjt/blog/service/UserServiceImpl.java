package com.hjt.blog.service;

import com.hjt.blog.dao.UserRepository;
import com.hjt.blog.po.User;
import com.hjt.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//实现检查用户名密码
@Service
public class UserServiceImpl implements UserService {

    @Autowired  //用在方法上，可直接用在字段上
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
//        User user = userRepository.findByUsernameAndPassword(username,MD5Utils.code(password));
        User user = userRepository.findByUsernameAndPassword(username,password);
//        MD5Utils.code(password)
        return user;
    }
}
