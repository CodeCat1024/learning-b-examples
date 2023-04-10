package com.zjt.demo.mapper;

import com.zjt.demo.model.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// 单元测试
@SpringBootTest // 表示当前单元测试运行在Spring Boot环境中
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getUserById() {
        UserInfo userInfo =  userMapper.getUserById(1);
        Assertions.assertNotNull(userInfo);
    }

    @Test
    @Transactional // 表示在不污染数据库的前提下进行测试，也就是方法执行后回滚事务
    void update() {
        int result = userMapper.update(2, "李四");
        Assertions.assertEquals(1, result);
    }

    @Test
    @Transactional
    void del() {
        int result = userMapper.del(1);
        System.out.println("受影响的行数：" + result);
        Assertions.assertEquals(1, result);
    }

    @Test
    void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("王五");
        userInfo.setPassword("1111");
        userInfo.setPhoto("");
        int result = userMapper.add(userInfo);
        System.out.println("受影响的行数：" + result);
        Assertions.assertEquals(1, result);

    }

    @Test
    void addGetId() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("老六");
        userInfo.setPassword("1111");
        userInfo.setPhoto("");
        System.out.println("添加之前 user id：" + userInfo.getId());
        int result = userMapper.addGetId(userInfo);
        System.out.println("受影响的行数：" + result);
        System.out.println("添加之后 user id：" + userInfo.getId());
        Assertions.assertEquals(1, result);
    }

    @Test
    void getOrderList() {
        List<UserInfo> list = userMapper.getOrderList("desc");
        System.out.println("列表：" + list);
    }

    @Test
    void login() {
        String username = "admin";
        String password = "' or 1 = '1"; // SQL注入，使用#{}的话就不会存在该问题
        UserInfo userInfo = userMapper.login(username, password);
        System.out.println("用户信息" + userInfo);
    }

    @Test
    void getListByName() {
        String username = "a";
        List<UserInfo> list = userMapper.getListByName(username);
        System.out.println("用户列表：" + list);
    }

    @Test
    void getUserAndArticleByUid() {
        UserInfo userInfo = userMapper.getUserAndArticleByUid(1);
        System.out.println("用户详情：" + userInfo);
    }

    @Test
    void add2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("张三");
        userInfo.setPassword("123");
        userInfo.setPhoto("default.png");
        userInfo.setPhoto(null);
        int result = userMapper.add2(userInfo);
        System.out.println("添加用户结果：" + result);
    }

    @Test
    void add3() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("王五");
        userInfo.setPassword("123");
        userInfo.setPhoto(null);
        int result = userMapper.add2(userInfo);
        System.out.println("添加用户结果：" + result);
    }

    @Test
    void getUserById2() {
        UserInfo userInfo = userMapper.getUserById2(null);
        System.out.println("用户信息：" + userInfo);
    }

    @Test
    void update2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("Paul");
        userInfo.setPassword("8888");
        //userInfo.setPhoto("MVP");
        int result = userMapper.update2(userInfo);
        System.out.println("update2 修改的结果为：" + result);
    }
}