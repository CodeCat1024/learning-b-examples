package thread;

/**
 * 此外还有Thread.interrupt方法，这个方法判定的是标志位是Thread的static成员（一个程序中只有一个标志位）
 * 因此随时哪个线程都有可能会终止
 *
 * 而Thread。currentThread().isInterrupted()方法判定的标志位是Thread的普通成员，每个示例都有自己的标志位
 * 基本都是使用第二种方法
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
                   // 当触发异常后，跳出循环，也就是中断线程
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

        /**
         * 在主线程中，调用 interrupt 方法，来中断这个线程
         * 使用该方法可能会出现两种情况
         *   1.如果线程处在就绪状态，就设置状态位位 true
         *   2.如果线程处在阻塞状态（sleep)，就会触发 InterruptException
         */
        t.interrupt();

    }
}
