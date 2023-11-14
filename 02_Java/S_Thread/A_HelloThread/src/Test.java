

public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("hello");
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.run();
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
    }
}