package com.zjt.usermanager.mapper;

import com.zjt.usermanager.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    UserInfo login(@Param("loginname") String loginname,
                   @Param("password") String password);
}
