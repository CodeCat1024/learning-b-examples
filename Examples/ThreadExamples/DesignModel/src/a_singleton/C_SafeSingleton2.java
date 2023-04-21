package a_singleton;

/**
 *  实现线程安全的懒汉模式
 *  使用这里的类对象作为锁对象（类对象在一个程序中只有一份，就能保证多个线程调用 getInstance 的时候都是针对同一个对象进行加锁）
 *  一旦被初始化之后，getInstance 就只剩下两个读操作，就是线程安全的了
 *  因此只需要在第一个调用的时候进行加锁
 */

class SafeSingleton2 {

    private static volatile SafeSingleton2 instance = null;

    private SafeSingleton2() {};

    public static SafeSingleton2 getInstance() {
        // 外层的 if 是判断是否要进行加锁
        if (instance == null) {
            synchronized (SafeSingleton2.class) {
                // 如果去掉了里层的 if 就变成了典型的错误代码
                // 枷锁没有把 读+修改 操作进行打包
                // 并且尽管这里的 if 条件是相邻的，它们的执行时机差别也是很大的
                // 可能外层条件是 10点 执行的，里层条件是 11点执行的（因为加锁会导致代码阻塞）
                if (instance == null) {
                    instance = new SafeSingleton2();
                }
            }
        }
        return instance;
    }
}

public class C_SafeSingleton2 {
    public static void main(String[] args) {
        SafeSingleton2 instance = SafeSingleton2.getInstance();
    }
}
