package e_queue.b_use;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列的使用
 */
public class UseDeque {
    public static void main(String[] args) {
        // 由链表实现的双端队列
        Deque<Integer> deque1 = new LinkedList<>();
        // 由顺序表实现的双端队列
        Deque<Integer> deque2 = new ArrayDeque<>();

        deque1.addFirst(100);
        deque1.addFirst(200);
        deque1.addFirst(300);

        deque1.addLast(900);
        deque1.addLast(800);
        deque1.addLast(700);

        System.out.println(deque1.peekFirst());
        System.out.println(deque1.peekLast());

        System.out.println();
        System.out.println();

        System.out.println(deque1.peekFirst());
        System.out.println(deque1.peekLast());

        System.out.println(deque1.pollFirst());
        System.out.println(deque1.pollLast());

        System.out.println(deque1.size());
        System.out.println(deque1.isEmpty());

    }
}
