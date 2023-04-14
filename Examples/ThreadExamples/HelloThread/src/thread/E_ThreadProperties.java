package thread;

/**
 * 打印出线程的所有属性
 */

public class E_ThreadProperties {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    // Thread。currentThread() 也就是获取当前线程的引用
                    // 我们也可以使用this.
                    System.out.println(Thread.currentThread().getName() + "我还活着");
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "我即将死去");
        });

        System.out.println(Thread.currentThread().getName()
                         + "：ID：" + t.getId());
        System.out.println(Thread.currentThread().getName()
                         + "：名称：" + t.getName());
        System.out.println(Thread.currentThread().getName()
                         + "：状态：" + t.getState());
        System.out.println(Thread.currentThread().getName()
                         + "：优先级：" + t.getPriority());
        System.out.println(Thread.currentThread().getName()
                         + "：后台线程：" + t.isDaemon());
        System.out.println(Thread.currentThread().getName()
                         + "：活着：" + t.isAlive());
        System.out.println(Thread.currentThread().getName()
                         + "：被中断：" + t.isInterrupted());

        t.start();
        while (t.isAlive()) {}
        System.out.println(Thread.currentThread().getName() + "：状态：" + t.getState());
    }
}
