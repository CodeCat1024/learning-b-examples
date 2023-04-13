package thread;


class MyThread extends Thread {
    @Override
    public void run() {
        // 要执行的代码
        System.out.println("Hello Thread1");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello Thread2");
    }
}

public class CreateThread {
    public static void main(String[] args) {

        // 1.创建子类，继承自Thread
        Thread t1 = new MyThread();
        t1.start(); // 在调用start之前，系统是没有创建出线程的

        // 2.创建一个类，实现Runnable接口，再创建Runnable实例传给Thread实例
        //   通过Runnable来描述任务的内容，进一步再把描述好的任务交给Thread实例
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        3.

    }
}
