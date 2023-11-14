package b_blockingQueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class A_JavaBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();
        queue.put("hello");  // 入队列
        String s = queue.take();// 出队列
    }
}
