-- 创建数据库
drop database if exists test;
create database test DEFAULT CHARACTER SET utf8mb4;

-- 使用数据库
use test;

-- 创建用户表
drop table if exists userinfo;
create table userinfo(
    id int primary key,
    username varchar(50) not null,
    password varchar(50) not null
) default charset 'utf8mb4';

-- 插入用户信息
insert into userinfo values (1, "张三", "1234");