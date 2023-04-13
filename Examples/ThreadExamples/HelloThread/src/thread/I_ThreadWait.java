package thread;

/**
 * 多个线程之间，调度顺序是不确定的
 * 线程之间的执行是按照调度器来安排的，这个过程可以视为是“无序，随机”
 * 为了控制顺序，我们可以使用 线程等待
 * 这里的线程等待，住哟啊是控制线程结束的先后顺序
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


        /**
         * 在主线中可以使用等待操作，来等待 t 线程执行结束
         * 该方法是main线程针对t调用的
         * 意思就是：main线程会等待t执行完再继续执行
         * 此时main线程就会进入阻塞状态（暂时无法在cpu上执行）
         * join 默认情况下是死等（不见不散）
         * 如果 t.join(1000); 这样就是活等，1000ms后还不出现就直接走人
         */
    }
}
