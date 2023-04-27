package d_stack;

import java.util.Arrays;
class EmptyException extends RuntimeException{
    public EmptyException() { }
    public EmptyException(String msg) {
        super(msg);
    }
}

public class B_MyStack {
    public int[] elem;
    public int usedSize;

    public B_MyStack() {
        this.elem = new int[10];
    }
    // 压栈
    public void push(int val) {
        if (isFull()) {
            // 扩容
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }

        elem[usedSize++] = val;
    }
    public boolean isFull() {
        return usedSize == elem.length;
    }

    // 出栈
    public int pop() {
        if(isEmpty()) {
            throw new EmptyException("抱歉，栈为空！");
        }
        return elem[--usedSize];
    }
    public boolean isEmpty() {
        return usedSize == 0;
    }

    // 获取栈顶元素
    public int peek() {
        if (isEmpty()) {
            throw new EmptyException("抱歉，栈为空！");
        }
        return elem[usedSize - 1];
    }

    public static void main(String[] args) {
        B_MyStack b_myStack = new B_MyStack();
        b_myStack.push(1);
        b_myStack.push(2);
        b_myStack.push(3);
        b_myStack.push(4);
        System.out.println(b_myStack.peek());
        int a = b_myStack.pop();
        System.out.println(a);
        System.out.println(b_myStack.peek());
        System.out.println(b_myStack.isEmpty());
    }
}
