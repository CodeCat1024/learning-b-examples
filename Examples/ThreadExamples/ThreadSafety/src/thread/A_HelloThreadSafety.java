package thread;

/**
 * 初步演示了线程不安全
 * 该案例线程不安全的原因：count++到底干了什么？
 *
 * 1.load：把内存中的count的值，给加载到CPU寄存器中
 * 2.add：把寄存器中的值+1
 * 3.save：把寄存器中的值写回到内存的count中
 * 正因为“抢占式执行”，这就导致两个线程同时执行这三个指令的时候，顺序上充满了随机性，导致了线程的不安全
 */

class Counter {

    public int count;

    // public void increase() { count++; }

    // 使用 synchronized 进行修正方法1
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

        t1.join();
        t2.join();

        System.out.println(counter.count);
    }

}
