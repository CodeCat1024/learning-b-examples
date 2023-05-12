package g_heap.b_use;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueue 的使用示例
 */

public class UsePriorityQueue {
    public static void main(String[] args) {
        // 小根堆
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Queue<Integer> priorityQueue2 = new PriorityQueue<>(10);
        List<Integer> list = new ArrayList<>();
        Queue<Integer> priorityQueue3 = new PriorityQueue<>(list);

        // 大根堆


        // PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(10);
        priorityQueue.offer(2);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek());
    }
}
