package com.zjt.demo.mapper;

import com.zjt.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    // 根据名称进行模糊查询
    public List<UserInfo> getListByName(@Param("username") String username);

    // 登录功能
    public UserInfo login(@Param("username") String username,
                          @Param("password") String password);

    // 根据用户id查询用户
    public UserInfo getUserById(@Param("id") Integer id);

    // 根据用户id查询用户及用户发表的所有文章
    public UserInfo getUserAndArticleByUid(@Param("uid") Integer id);

    // 获取列表，根据创建时间进行倒序或正序
    public List<UserInfo> getOrderList(@Param("order") String order);

    // 修改方法【根据id修改名称】
    public int update(@Param("id") Integer id,
                      @Param("username") String username);

    // 根据id删除用户
    public int del(@Param("id") Integer id);

    // 添加用户，返回受影响的行数
    public int add(UserInfo userInfo);

    // 添加用户，并返回自增id
    public int addGetId(UserInfo userInfo);

    // 添加用户，返回受影响的行数（photo是非必传参数）
    public int add2(UserInfo userInfo);

    // 添加用户，其中 username，password，photo 都是非必传参数
    // 但至少会传递一个
    public int add3(UserInfo userInfo);

    public UserInfo getUserById2(@Param("id")Integer id);

    //public int update2(UserInfo userInfo);

    public int update2(UserInfo userInfo);

    // 根据id进行批量删除
    int delByIds(List<Integer> ids);

}
