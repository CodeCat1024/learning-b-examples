package thread;

/**
 * 给线程命名
 */
public class D_ThreadSetName {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while(true) {
                System.out.println("Hello Thread1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread1");
        t1.start();

        Thread t2 = new Thread(() -> {
            while(true) {
                System.out.println("Hello Thread2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread2");
        t2.start();
    }
}
