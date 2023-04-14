package thread;

/**
 * 演示两个线程交替执行任务
 */

class ThreadExample extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("Hello Thread1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class A_HelloThread {
    public static void main(String[] args) {
        Thread t = new ThreadExample();
        t.start();

        while (true) {
            System.out.println("Hello Main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
