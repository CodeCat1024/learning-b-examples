package c_timer;

import java.util.TimerTask;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 自己实现衣蛾定时器（重点掌握）
 */

// 创建一个类，表示一个任务
class MyTask implements Comparable<MyTask>{
    // 任务具体要干啥
    private Runnable runnable;

    // 任务具体啥时候干，保存任务要执行的毫秒级时间戳
    private long time;

    // after 是一个时间间隔，不是绝对的时间戳的值
    public MyTask(Runnable runnable, long after) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + after;
    }

    public void run() {
        runnable.run();
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTask o) {
        // 时间小的在前，时间大的在后
        return (int) (this.time - o.time);
    }
}

class MyTimer {
    // 定时器内部要能够存放多个任务
    private PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    private Object locker = new Object();

    public void schedule(Runnable runnable, long delay) {
        MyTask task = new MyTask(runnable, delay);
        queue.put(task);

        // 每次任务插入成功之后，都唤醒一下扫描线程，让线程重新检查一下队首的任务是否时间到了要执行
        synchronized (locker) {
            locker.notify();
        }
    }


    public MyTimer() {
        Thread t = new Thread(() -> {
            while(true) {
                try {
                    // 先取出队首元素
                    MyTask myTask = queue.take();

                    // 再比较一下看看当前这个任务时间到了没
                    long currentTime = System.currentTimeMillis();
                    if (currentTime < myTask.getTime()) {
                        // 时间没到，把任务再塞回到队列中
                        queue.put(myTask);

                        // 指定一个等待时间（解决忙等）
                        synchronized (locker) {
                            locker.wait(myTask.getTime() - currentTime);
                        }

                    } else {
                        // 时间到了，执行这个任务
                        myTask.run();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}

public class B_MyTimer {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello MyTimer!");
            }
        }, 3000);
        System.out.println("main");
    }
}
