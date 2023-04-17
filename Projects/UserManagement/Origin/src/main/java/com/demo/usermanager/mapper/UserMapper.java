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
}
