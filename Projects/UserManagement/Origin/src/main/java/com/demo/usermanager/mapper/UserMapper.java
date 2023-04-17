package com.demo.usermanager.mapper;

import com.demo.usermanager.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    // 登录功能
    UserInfo login(@Param("loginname") String loginname,
                   @Param("password") String password);

    // 查询所有的用户信息
    List<UserInfo> getAll();

    // 添加用户
    int add(UserInfo userInfo);

    // 根据登录名查询用户信息（非模糊查询）
    UserInfo getUserByLoginName(@Param("loginname") String loignname);

    // 根据uid查询用户信息
    UserInfo getUserByUid(@Param("uid") Integer uid);

    // 修改用户信息
    int update(UserInfo userInfo);

    // 删除单个用户
    int del(@Param("uid") Integer uid);


}
