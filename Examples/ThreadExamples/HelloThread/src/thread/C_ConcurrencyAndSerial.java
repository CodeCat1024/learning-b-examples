package thread;

/**
 * 演示并发的串行的效率差别
 */

public class C_ConcurrencyAndSerial {
    private static final long count = 10_0000_0000;
    // private static final long count = 100_0000_0000L;

    public static void serial() {
        // 记录程序执行时间
        long beg = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < count; i++) {
            a++;
        }

        long b = 0;
        for (long i = 0; i < count; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println("串行消耗时间为：" + (end - beg) + "ms");
    }

    public static void concurrency() throws InterruptedException {
        // 记录程序执行时间
        long beg = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
           long a = 0;
           for (long i = 0; i < count; i++) {
               a++;
           }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            long b = 0;
            for (long i = 0; i < count; i++) {
                b++;
            }
        });
        t2.start();

        // 此处不能这么记录结束时间，因为此时求时间戳的代码是在main线程中
        // main和t1，t2之间是并发执行的关系，此处t1和t2还没有执行完呢，这里就开始记录结束时间了
        // 正确的做法应该是让main线程等待t1和t2跑完了，再来记录结束时间
        // join 效果就是等待线程结束，t1.join就是让main线程等待t1结束再执行后面的代码
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("并行消耗时间为：" + (end - beg) + "ms");
    }

    public static void main(String[] args) throws InterruptedException {
        serial();
        concurrency();
    }
}
