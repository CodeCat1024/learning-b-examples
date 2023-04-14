package thread;

/**
 * 方法1：
 * Thread.interrupt()，这个方法判定的是标志位是Thread的static成员（一个程序中只有一个标志位）
 * 因此随时哪个线程都有可能会终止
 *
 * 方法2：
 * 而Thread.currentThread().isInterrupted()方法判定的标志位是Thread的普通成员（每个示例都有自己的标志位），基本都是使用这种方法
 * 接着再使用 .interrupt() 来中断线程，使用该方法可能会出现两种情况
 *      1.如果线程还处在就绪状态，就设置状态位为 true
 *      2.如果线程处在阻塞状态(sleep)，就会触发 InterruptException 异常，因此要再触发异常之后跳出循环，也就是中断线程，才代表线程结束

 */

public class H_AdvancedStopThread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
           while(!Thread.currentThread().isInterrupted()) {
               System.out.println("Hello Thread");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
                   System.out.println("终止线程 t");
                   break;
               }
           }
        });
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();

    }
}
