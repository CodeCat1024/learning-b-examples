create database order_system;
use order_system;

drop table if exists dishes;
create table dishes (
    dishId int primary key auto_increment,
    name varchar(50),
    price int -- 以分为单位，不要用float double 表示，会有误差
);

drop table if exists user;
create table user (
    userId int primary key auto_increment,
    name varchar(50),
    password varchar(50),
    isAdmin int -- 是否为管理员，0表示不是，1表示是
);

drop table if exists order_user;
create table order_user (
    orderId int primary key auto_increment,
    userId int, --这个用户id需要和user表中的 userId 有关联关系
    time datetime, --下单时间
    isDone int, --1表示完结，0表示未完结
    foreign key(userId) references user(userId)
);

drop table if exists order_dish;
create table order_dish (
    orderId int, --orderId也和order_user表中的orderId字段有外键关系
    dishId int --dishId 也和 dishes 表中的dishId存在外键关系
    foreign key(orderId) references order_user(orderId),
    foreign key(dishId) references dishes(dishId)
);