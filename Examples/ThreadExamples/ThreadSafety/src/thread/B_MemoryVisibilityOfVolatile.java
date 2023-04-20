package thread;

import java.util.Scanner;

/**
 * 使用volatile解决内存可见性
 */

public class B_MemoryVisibilityOfVolatile {
    private static volatile int isQuit = 0;
    //private static int isQuit = 0;
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
           while (isQuit == 0) {
               // 如果加上这个，编译器就不进行优化了，这是个很模糊的事情
               // Thread.sleep(1000):
           }
            System.out.println("循环结束：t线程退出！");
        });
        t.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个isQuit的值：");
        isQuit = scanner.nextInt();
        System.out.println("main线程执行完毕");
    }
}
