package c_multiInterface;

/**
 * 通过接口可以实现多继承
 * 只要实现了IRunning接口的都可以接收
 * 不管是什么类型，只要实现了该接口可以传入了
 * 接口可以让程序员忘记类型，只要具备接口的能力就行
 */

abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }
}

interface IRunning {
    void run();
}

interface IFlying {
    void fly();
}


class Bird extends Animal implements IRunning, IFlying {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name + "正在跑！");
    }


    @Override
    public void fly() {
        System.out.println(name + "正在飞！");
    }
}

class Eagle extends Animal implements IRunning, IFlying {
    public Eagle(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name + "正在跑！");
    }


    @Override
    public void fly() {
        System.out.println(name + "正在飞！");
    }
}


public class Test {


    public static void walk(IRunning iRunning) {
        iRunning.run();
    }

    public static void main(String[] args) {
        walk(new Bird("小鸟"));
        walk(new Bird("老鹰"));
    }
}



