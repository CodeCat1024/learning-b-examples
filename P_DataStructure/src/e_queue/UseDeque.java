package e_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列
 */
public class UseDeque {
    public static void main(String[] args) {
        // 由链表实现的双端队列
        Deque<Integer> deque1 = new LinkedList<>();
        // 由顺序表实现的双端队列
        Deque<Integer> deque2 = new ArrayDeque<>();
    }
}
