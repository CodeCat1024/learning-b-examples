package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    // 登录功能
    UserInfo login(@Param("loginname") String loginname,
                   @Param("password") String password);
}
