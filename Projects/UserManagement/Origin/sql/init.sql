drop database if exists usermanager;
create database usermanager character set 'utf8mb4';
use usermanager;

create table userinfo(
    uid int primary key auto_increment,
    username varchar(250) not null,
    loginname varchar(250) unique not null,
    password varchar(65) not null,
    sex varchar(2) default '男',
    age int default 0,
    address varchar(250),
    qq varchar(250),
    email varchar(250),
    isadmin bit default 0,
    state int default 1,
    createtime datetime default now(),
    updatetime datetime default now()
) default charset='utf8mb4';

insert into userinfo(username, loginname, password, isadmin)
values ('超级管理员', 'admin', 'admin', 1);

insert into userinfo(username, loginname, password, isadmin)
values ('普通用户', 'Kate', 'Kate', 0);

insert into userinfo(username, loginname, password, isadmin)
values ('Paul', 'Paul', 'Paul', 0);

insert into userinfo(username, loginname, password, isadmin)
values ('King', 'King', 'King', 0);

insert into userinfo(username, loginname, password, isadmin)
values ('King1', 'King1', 'King1', 0);

insert into userinfo(username, loginname, password, isadmin)
values ('King2', 'King2', 'King2', 0);

insert into userinfo(username, loginname, password, isadmin)
values ('King3', 'King3', 'King3', 0);

insert into userinfo(username, loginname, password, isadmin)
values ('King4', 'King4', 'King4', 0);

insert into userinfo(username, loginname, password, isadmin)
values ('King5', 'King5', 'King5', 0);

insert into userinfo(username, loginname, password, isadmin)
values ('King6', 'King6', 'King6', 0);

insert into userinfo(username, loginname, password, isadmin)
values ('King7', 'King7', 'King7', 0);

insert into userinfo(username, loginname, password, isadmin)
values ('King8', 'King8', 'King8', 0);

