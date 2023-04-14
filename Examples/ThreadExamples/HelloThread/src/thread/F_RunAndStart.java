package thread;

/**
 * run() 和 start() 方法的区别
 * run方法只是一个普通的方法，并没有真正创建线程，因此这里只会串行执行，不会并发执行
 */

public class F_RunAndStart {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("Hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //t.start();

        t.run();

        while(true) {
            System.out.println("Hello Main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
