import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示了使用 CAS 保证线程安全
 * 既能确保线程安全，又能比 synchronized 高效
 * synchronized 会涉及锁的竞争，两个线程又要互相等待
 * CAS 不涉及到线程阻塞等待
 */
public class A_HelloCAS {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger num = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
           for (int i = 0; i < 50000; i++) {
               // 这个方法就相当于 num++
               num.getAndIncrement();
           }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                num.getAndIncrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // 通过 get 方法得到 原子类 内部的数值
        System.out.println(num.get());
    }
}
