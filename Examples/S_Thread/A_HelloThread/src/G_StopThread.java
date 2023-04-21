/**
 * 演示手动停止线程
 *
 * 想让线程停下来，最重要的就是执行完run方法
 * 只要把这个isQuit设置为true，这个循环就退出了，run方法就执行结束了
 * 因为多个线程共用一个虚拟地址空间，所以main线程修改的isQuit和判定t的isQuit是一个值
 * 因此如果是进程的话，可能就会失败
 */

public class G_StopThread {
    private static boolean isQuit = false;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!isQuit) {
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
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        isQuit = true;
        System.out.println("终止 t 线程！");

    }
}
