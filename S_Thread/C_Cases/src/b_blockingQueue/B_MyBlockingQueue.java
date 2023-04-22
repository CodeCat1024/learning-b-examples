package b_blockingQueue;

/**
 *
 * 1.实现普通的队列
 * 2.让这个队列支持线程安全
 *   给put, take方法加上锁
 * 3.实现阻塞效果（使用 wait 和 notify）
 *   对于 put 来说，阻塞条件就是队列为满
 *   对于 take 来说，阻塞条件就是队列为空
 */
class MyBlockingQueue {
    // 保存数据本体
    private int[] data = new int[1000];
    // 有效元素个数
    private int size = 0;
    // 队首下标
    private int head = 0;
    // 队尾下标
    private int tail =0;

    private Object locker = new Object();

    // 入队列
    public void put(int value) throws InterruptedException {
        synchronized (locker) {
            if (size == data.length) {
                // 队列满了，暂时先直接返回
                //return;
                locker.wait(); // 由 take 来唤醒（只要take成功了一个元素，队列就不满了，就可以唤醒了）
            }
            // 把新的元素放到tail位置上
            data[tail] = value;
            tail++;

            // 处理tail到达数组末尾的情况

            // 写法1（更好）
            if (tail >= data.length) {
                tail = 0;
            }

            // 写法2（可读性差且开销更大）
            // tail = tail % data.length;

            // 插入之后修改元素个数
            size++;
            // 如果入队列成功，则队列非空，于是就唤醒 take 中的阻塞等待
            locker.notify();
        }
    }

    // 出队列
    public Integer take() throws InterruptedException {
        synchronized (locker) {
            if (size == 0) {
                // 如果队列为空，就返回一个非法值
                //return null;

                locker.wait(); // 由 put 来唤醒
            }
            // 取出 head 位置的元素
            int ret = data[head];
            head++;
            if (head >= data.length) {
                head = 0;
            }
            size--;
            // take成功之后，唤醒 put中的等待
            locker.notify();
            return ret;
        }
    }
}

public class B_MyBlockingQueue {
    private static MyBlockingQueue queue = new MyBlockingQueue();

    public static void main(String[] args) throws InterruptedException {

        // 验证队列是否能正确工作
//        MyBlockingQueue myBlockingQueue = new MyBlockingQueue();
//        myBlockingQueue.put(1);
//        myBlockingQueue.put(2);
//        myBlockingQueue.put(3);
//        myBlockingQueue.put(4);
//
//        int ret = 0;
//        ret = myBlockingQueue.take();
//        System.out.println(ret);
//        ret = myBlockingQueue.take();
//        System.out.println(ret);
//        ret = myBlockingQueue.take();
//        System.out.println(ret);
//        ret = myBlockingQueue.take();
//        System.out.println(ret);

        // 实现一个简单的生产者消费者模型

        // 生产者
        Thread producer = new Thread(() -> {
            int num = 0;
            while (true) {
                try {
                    System.out.println("生产了：" + num);
                    queue.put(num);
                    num++;
                    //Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();

        // 消费者
        Thread customer = new Thread(() -> {
             while(true) {
                 try {
                     int num = queue.take();
                     System.out.println("消费了：" + num);
                     Thread.sleep(500);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
        });
        customer.start();
    }
}
