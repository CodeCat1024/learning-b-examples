# MyBlog_01 Spring Boot个人博客项目随笔

#### 介绍
第一个框架相关的练手项目，一个基于SpringBoot的博客项目，前端框架semantic-UI，模板使用Thymeleaf，持久层使用的JPA，系统日志采用自定义注解+AOP 方式实现

后续将更新上传持久层改写为Mybatis，安全方面使用Shiro实现的项目代码。


- 作者：何锦涛
- qq：1059339010


项目参照b站李仁密老师的Spring Boot开发小而美的个人博客。

目录中有blog.sql文件，可以直接执行生成对应的数据库和表，密码采用了MD5加密。

#### 技术组合：

1.  后端：Spring Boot + Spring MVC + JPA

2.  数据库：MySQL

3.  前端UI：Semantic UI框架 + thymeleaf模板

4.  各项插件：

    -内容排版typo

    -代码高亮prism

    -动画animate.css

    -目录生成Tocbot

#### 工具与环境：

-IDEA 2020.3

-Maven 3.6.2

-JDK 8

-springboot 2.3.4

-运行环境 阿里云ESC:centos7

#### 项目截图
##### 主页
![输入图片说明](https://images.gitee.com/uploads/images/2020/1226/151551_681f84a3_8462965.png "QMW0RK$CWNDPFM`FWC939Y9.png")
##### 标签页
![输入图片说明](https://images.gitee.com/uploads/images/2020/1226/151707_b9e35d29_8462965.png "0RJ5PYJH]X4R2B0L6N5`(6A.png")
##### 归档页
![输入图片说明](https://images.gitee.com/uploads/images/2020/1226/151752_a0d85751_8462965.png "[5J_P5YIPAIV@BOC$_NA5OR.png")
##### 关于我
![输入图片说明](https://images.gitee.com/uploads/images/2020/1226/152204_ae8c9cd3_8462965.png "9W65C5P5V]ZZA@R8)N)%}_V.png")
##### 后台管理博客
![输入图片说明](https://images.gitee.com/uploads/images/2020/1226/151857_f3ac055f_8462965.png "[H_@@F5I1NG9S2}HJ74C77I.png")
##### 博客发布
![输入图片说明](https://images.gitee.com/uploads/images/2020/1226/152020_be078e9a_8462965.png "EYB2VV0VO6SZ2XGLQ[@RZIV.png")