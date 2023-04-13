package thread;

/**
 * 产生线程不安全的原因：
 * 1.线程是抢占式执行，线程间的调度充满随机性
 * 2.多个线程对同一个变量进行修改操作
 * 3.针对变量的操作不是原子的
 * 4.内存可见性
 */

/**
 * 线程不安全的原因：count++到底干了什么？
 * 1.load：把内存中的count的值，给加载到CPU寄存器中
 * 2.add：把寄存器中的值+1
 * 3.save：把寄存器中的值写回到内存的count中
 * 正因为“抢占式执行”，这就导致两个线程同时执行这三个指令的时候，顺序上充满了随机性
 * 我们使用最频繁的是 synchronized 这个关键字
 */

class Counter {

    // 这个变量就是两个线程需要去自增的变量
    public int count;

    /**
     * 给方法加上 synchronized，进入方法就会自动加锁，离开方法自动解锁
     */
    synchronized public void increase() {
        count++;
    }
}

public class A_HelloThreadSafety {

    private static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
           for (int i = 0; i < 50000; i ++) {
               counter.increase();
           }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i ++) {
                counter.increase();
            }
        });

        t1.start();
        t2.start();

        // 必须在t1和t2都执行完之后再去打印count
        // 因为main和这两个线程就是并发的关系，所以有可能t1，t2还没执行完就去打印了count

        t1.join();
        t2.join();
        // 在main方法中打印一下两个线程自增完成之后得到的count结果
        System.out.println(counter.count);
    }

}
