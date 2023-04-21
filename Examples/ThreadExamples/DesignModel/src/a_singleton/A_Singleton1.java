package a_singleton;

/**
 * 单例模式演示（饿汉模式）
 * 只读，也就是说在并发调用 getInstance 方法时是线程安全的
 */
class Singleton {
    // 1.使用 static 创建一个实例，并且立即进行实例化
    //   这个 instance 对应的实例，就是该类的唯一实例
    private static Singleton instance = new Singleton();

    // 2.为了防止 new 出第二个Singleton，就可以把构造方法设置为 private
    private Singleton() {};

    // 3.提供一个方法让外面能够拿到唯一实例
    public static Singleton getInstance() {
        return instance;
    }
}

public class A_Singleton1 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }
}
