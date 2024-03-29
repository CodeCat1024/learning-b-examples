package user;

import operations.*;

import java.util.Scanner;

public class AdminUser extends User{

    public AdminUser(String name) {
        super(name);
        this.ioPerations = new IOPeration[] {
                new Exit(),
                new Find(),
                new Add(),
                new Del(),
                new Display(),
        };
    }

    @Override
    public int menu() {
        System.out.println("************************************");
        System.out.println("Hello~" + name + "欢迎来到图书管理系统！");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("************************************");
        System.out.println("请输入你的操作");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
