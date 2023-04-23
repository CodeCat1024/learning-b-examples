import java.util.concurrent.CountDownLatch;

public class E_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        // 构造方法的参数表示有几个选手参赛
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "到达终点！");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }

        // 裁判就要等待所有的线程到达
        // 当这些线程没有执行完的时候，await就阻塞，所有的线程都执行完了，await才返回
        latch.await();
        System.out.println("比赛结束！");
    }
}
