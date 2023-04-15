package thread;

import java.util.Scanner;

/**
 * 使用 synchronized 保证内存可见性
 */

public class C_MemoryVisibilityOfSynchronized {
    static class Counter {
        public int flag = 0;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
           while (true) {
               synchronized (counter) {
                   if (counter.flag != 0) {
                       break;
                   }
               }
           }
            System.out.println("循环结束！");
        });

        Thread t2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入一个整数：");
            counter.flag = scanner.nextInt();
        });

        t1.start();
        t2.start();
    }
}
