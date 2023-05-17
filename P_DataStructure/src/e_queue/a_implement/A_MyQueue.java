package e_queue.a_implement;

import b_arraylist.a_implement.EmptyException;

/**
 * 实现普通队列（链式存储）
 */
public class A_MyQueue {
    static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    public Node head;
    public Node last;
    public int usedSize;

    // 入队
    public void offer(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            last.next = node;
        }
        last = node;
        usedSize++;
    }

    // 出队
    public int poll() {
        if (empty()) {
            throw new EmptyException("队列为空");
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            // 如果只有一个节点，那么last也要置空
            last = null;
        }
        usedSize--;
        return ret;
    }

    // 是否为空
    public boolean empty() {
        return usedSize == 0;
    }

    // 查看队头数据
    public int peek() {
        if (empty()) {
            throw new EmptyException("队列为空");
        }
        return head.val;
    }

    // 获取元素个数
    public int getUsedSize() {
        return usedSize;
    }

    public static void main(String[] args) {
        A_MyQueue AMySingleQueue = new A_MyQueue();
        AMySingleQueue.offer(1);
        AMySingleQueue.offer(2);
        AMySingleQueue.offer(3);
        AMySingleQueue.offer(4);
        System.out.println(AMySingleQueue.peek());
        System.out.println(AMySingleQueue.poll());
        System.out.println(AMySingleQueue.peek());
    }
}
