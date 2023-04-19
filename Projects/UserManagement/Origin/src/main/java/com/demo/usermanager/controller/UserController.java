package com.demo.usermanager.controller;

import com.demo.usermanager.model.UserInfo;
import com.demo.usermanager.service.UserService;
import com.demo.usermanager.util.ConstVariable;
import com.demo.usermanager.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录功能（加盐）
     * 盐值（通常使用随机数） + 加密数据 = 加盐数据
     * 实现方式
     * 1.使用框架提供加盐测试和API实现加盐
     * 2、自己实现加盐方法
     *    1.加密：随机盐值$最终加密密码
     *    2.解密：md5（随机盐值 + 用户输入的密码） == 最终加密密码 ? 密码正确:密码错误
     * @param request
     * @param loginname
     * @param password
     * @return
     */
    // todo:登录不进去
    @RequestMapping("/login")
    public boolean login(HttpServletRequest request, String loginname, String password) {
        if (StringUtils.hasLength(loginname) && StringUtils.hasLength(password)) {
            // 参数有效
            UserInfo userInfo = userService.getUserByLoginName(loginname);
            if (userInfo != null && userInfo.getUid() > 0) {
                // 数据库保存的加密的密码
                String dbPassword = userInfo.getPassword();
                boolean result = PasswordUtil.decrypt(password, dbPassword);
                if (result) {
                    // 存储 session
                    HttpSession session = request.getSession(true);
                    session.setAttribute(ConstVariable.USER_SESSION_KEY, userInfo);
                    return true;
                }
            }
        }
        return false;
    }

    // 渲染主页数据
    @RequestMapping("/list")
    public List<UserInfo> getAll() {
        return userService.getAll();
    }

    // 渲染主页数据（带分页和条件查询）
    @RequestMapping("/listbypage")
    public HashMap<String, Object> getListByPage(String username,
                                                 String address,
                                                 String email,
                                                 Integer pindex,
                                                 Integer psize) {
        HashMap<String, Object> result = new HashMap<>();
        if (pindex == null || pindex < 1) {
            pindex = 1;
        }
        if (psize == null || psize <= 0) {
            psize = 2;
        }
        if (!StringUtils.hasLength(username)) {
            username = null;
        }
        if (!StringUtils.hasLength(address)) {
            address = null;
        }
        if (!StringUtils.hasLength(email)) {
            email = null;
        }
        int offset = (pindex - 1) * psize;
        List<UserInfo> list = userService.getListByPage(username, address, email, psize, offset);
        int totalCount = userService.getListByPageCount(username, address, email);
        result.put("list", list);
        result.put("count", totalCount);
        return result;
    }

    // 添加用户
    // todo:无法添加用户
    @RequestMapping("/add")
    public int add(UserInfo userInfo, HttpServletRequest request) {
        int result = 0;
        // 1.非空效验
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername()) ||
                !StringUtils.hasLength(userInfo.getLoginname()) ||
                !StringUtils.hasLength(userInfo.getPassword())) return result;
        // 2.判断必须为超级管理员，才能进行添加操作
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(ConstVariable.USER_SESSION_KEY) == null) return result;
        UserInfo loginUser = (UserInfo) session.getAttribute(ConstVariable.USER_SESSION_KEY);
        if (!loginUser.isIsadmin()) return result;
        // 3.对登录名做一个唯一效验
        UserInfo loginNameUser = userService.getUserByLoginName(userInfo.getLoginname());
        // 当前登录名是否存在的判断
        if (loginNameUser != null && loginNameUser.getUid() > 0) return result;
        // 4.添加用户到数据库
        userInfo.setPassword(PasswordUtil.encrypt(userInfo.getPassword())); // 加密密码
        result = userService.add(userInfo);
        return result;
    }

    // 根据uid获取用户信息
    @RequestMapping("/getuserbyuid")
    public UserInfo getUserByUid(Integer uid) {
        UserInfo userInfo = null;
        // 先做非空校验
        if (uid == null || uid <= 0) return userInfo;

        // 查询数据库
        userInfo = userService.getUserByUid(uid);

        // 将密码隐藏掉
        userInfo.setPassword("");
        return userInfo;
    }

    // 修改用户信息
    @RequestMapping("/update")
    public int update(UserInfo userInfo, HttpServletRequest request) {
        int result = 0;

        // 非空校验（isadmin默认是false，所以不需要判断）
        if (userInfo == null || userInfo.getUid() <=0 ||
                !StringUtils.hasLength(userInfo.getUsername())) {
            return result;
        }
        System.out.println("已走到非空校验");

        // 判断必须为超级管理员，才能进行添加操作（健壮性增强）
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(ConstVariable.USER_SESSION_KEY) == null)return result;
        UserInfo loginUser = (UserInfo) session.getAttribute(ConstVariable.USER_SESSION_KEY);
        if (!loginUser.isIsadmin()) return result;


        // 执行修改操作
        result = userService.update(userInfo);

        return result;
    }

    // 删除单个用户
    @RequestMapping("/del")
    public int del(Integer uid) {
        if (uid == null) return 0;
        return userService.del(uid);
    }

    // 删除多个用户
    @RequestMapping("/delbyids")
    public int dels(String ids, HttpServletRequest request) {
        System.out.println("进来了吗？");
        if (!StringUtils.hasLength(ids)) return 0;
        String[] idsArr = ids.split(",");
        if (idsArr == null || idsArr.length <= 0) return 0;
        List<Integer> idsList = new ArrayList<>();
        // 得到当前登录用户的id
        HttpSession session = request.getSession(false);
        System.out.println("不然判断走进去了吗？");
        System.out.println("来看看ids长什么样吧先" + ids);

        if (session == null || session.getAttribute(ConstVariable.USER_SESSION_KEY) == null) return 0;
        int uid = ((UserInfo) session.getAttribute(ConstVariable.USER_SESSION_KEY)).getUid();
        System.out.println("再看看uid长什么样" +uid);
        for (String item : idsArr) {
            if (StringUtils.hasLength(item)) {
                // todo: 问题就出在这一行！！！写文章进行总结，并且发给磊哥
                item = item.trim();
                int thisUid = Integer.valueOf(item);

                // 删除之前，要判断删除的数据中不包含当前登录的用户
                if (uid == thisUid) {
                    System.out.println("不能删除管理员！");
                    return 0;
                }
                idsList.add(thisUid);
                System.out.println("以及最重要的idsList" + idsList);
            }
        }
        System.out.println("走到这个方法了吗？");
        int result = userService.dels(idsList);
        System.out.println("删除多条数据结果：" + result);
        return result;
    }


}
