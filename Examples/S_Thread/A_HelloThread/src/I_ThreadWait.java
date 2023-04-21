/**
 * 演示 join()
 * main 线程针对t进行调用，也就是等待 t 线程执行完再执行 main 线程
 * 使用.join()等待线程结束，默认情况是死等，t.join(1000)是活等
 */

public class I_ThreadWait {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0;i  < 5; i++) {
                System.out.println("Hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            t.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End");


    }
}
