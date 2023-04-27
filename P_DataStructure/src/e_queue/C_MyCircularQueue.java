package e_queue;

// 实现普通队列（顺序存储，循环）
public class C_MyCircularQueue {
    private int[] elem;
    private int front; // 表示队列的头
    private int rear;  // 表示队列的尾
    public C_MyCircularQueue(int k) {
        // 如果是浪费空间，这里必须处理多加一个1
        this.elem = new int[k + 1];
    }
    public boolean enQueue(int value) {
        // 1.检查队列是否为满
        if (isFull()) {
            return false;
        }

        // 2.
        elem[rear] = value;
        // rear++ 的话有可能会越界
        rear = (rear + 1) % elem.length;
        return true;
    }
    public boolean isFull() {
        return (rear + 1) % elem.length == front;
    }
    public boolean isEmpty() { return front == rear; }
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        // front++ 可能会越界
        front = (front + 1) % elem.length;
        return true;
    }
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elem[front];
    }
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (rear == 0) ? elem.length - 1: rear - 1;
        return elem[index];
    }
}
