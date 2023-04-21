package a_singleton;

/**
 * 单例模式：懒汉模式（线程不安全）
 */

class Singleton2 {
    // 1.不是立即就初始化实例
    private static Singleton2 instance = null;

    // 2.把构造方法设置为private
    private Singleton2() {};

    // 3.提供一个方法来获取上述单例的实例
    //   用到的时候再去创建
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

public class B_Singleton2 {
    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
    }
}
