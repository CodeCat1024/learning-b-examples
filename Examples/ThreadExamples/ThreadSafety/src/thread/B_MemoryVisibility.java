package thread;

import java.util.Scanner;

/**
 * 演示了内存可见性导致线程不安全及其解决方式
 */

/**
 * 内存可见性是什么？
 * 是属于编译器优化范围内比较玄学的一个典型案例
 * 编译器优化本身是一个比较玄学的问题，啥时候优化，啥时候不优化，都比较难说
 *
 * 解决方式：
 * 1.使用 synchronized 关键字，synchronized 不光能保证指令的原子性，同时也能保证内存可见性
 *   被 synchronized 不光能保证指令的原子性，同时也能保证内存可见性，被 synchronized 包裹起来的代码
 *   编译器不敢轻易地做出优化（相当于手动禁止了编译器的优化）
 * 2.使用volatile关键字
 *   volatile 和原子性无关，但是能够保证内存可见性
 *   禁止编译器做出上述优化，编译器每次执行判定相等，都会重新从内存中读取isQuit的值
 */

public class B_MemoryVisibility {
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