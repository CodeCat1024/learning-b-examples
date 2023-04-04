package com.zjt.demo.mapper;

import com.zjt.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public UserInfo getUserById(@Param("id") Integer id);
}
