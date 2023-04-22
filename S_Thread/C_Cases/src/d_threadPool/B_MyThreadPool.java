package d_threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class MyThreadPool {
    // 1.描述一个任务，直接使用 Runnable，不需要再额外创建类了
    // 2.使用一个数据结构来组织若干任务
    private BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();

    // 3.描述一个线程，工作线程的功能就是从任务队列中取任务并执行
    static class Worker extends Thread {
        // 当前线程池中有若干个 Worker 线程，这些线程内部都持有了上述任务队列
        private BlockingDeque<Runnable> queue = null;

        public Worker(BlockingDeque<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            // 就需要能够拿到上面的队列
            while(true) {
                try {
                    // 循环地去获取任务队列中的任务
                    // 如果队列为空，就直接阻塞，如果队列非空，就获取里面的内容
                    Runnable runnable = queue.take();
                    // 获取到之后，就执行任务
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 4.创建一个数据结构来组织若干个线程
    private List<Thread> workers = new ArrayList<>();

    public MyThreadPool(int n) {
        // 在构造方法中，创建出若干个线程，放到上述的数组中
        for (int i = 0; i < n; i++) {
            Worker worker = new Worker(queue);
            worker.start();
            workers.add(worker);
        }
    }

    // 5.创建一个方法，能够允许程序员来放任务到线程池中
    public void submit(Runnable runnable) {
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class B_MyThreadPool {
}







