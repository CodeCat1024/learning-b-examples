/**
 *  演示线程的五种创建方式
 */

class MyThread extends Thread {
    @Override
    public void run() {
        // 要执行的代码
        System.out.println("Hello Thread1");
    }
}
/**
 *  通常认为Runnable这种写法更好一些，可以做到要执行的任务之间更好的解耦
 *  它只是描述了一个任务，要给进程，线程，线程池还是协程执行不关它事
 */

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello Thread2");
    }
}


public class B_CreateThread {
    public static void main(String[] args) {

        // 1.创建子类，继承自Thread
        Thread t1 = new MyThread();
        t1.start(); // 在调用start之前，系统是没有创建出线程的

        // 2.创建一个类，实现Runnable接口，再创建Runnable实例传给Thread实例
        //   通过Runnable来描述任务的内容，进一步再把描述好的任务交给Thread实例
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // 3 / 4：上面两个写法的翻版，只是使用了匿名内部类
        Thread t3 = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello Thread3");
            }
        };
        t3.start();

        Thread t4  = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Thread4");
            }
        });
        t4.start();

        // 5.相当于第4种写法的延伸
        Thread t5 = new Thread(() -> {
            System.out.println("Hello Thread5");
        });
        t5.start();
    }
}
