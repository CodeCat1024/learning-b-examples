package d_stack.a_implement;

import java.util.Arrays;

/**
 * 栈的实现
 */
class EmptyException extends RuntimeException{
    public EmptyException() { }
    public EmptyException(String msg) {
        super(msg);
    }
}
public class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack() {
        this.elem = new int[10];
    }
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
    }
    // 压栈（相当于尾插）
    public void push(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        this.elem[usedSize++] = val;
    }
    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new EmptyException("抱歉，栈为空！");
        }
        return elem[--usedSize];
    }
    // 获取栈顶元素
    public int peek() {
        if (isEmpty()) {
            throw new EmptyException("抱歉，栈为空！");
        }
        return elem[usedSize - 1];
    }
    // 判断栈是否已满
    public boolean isFull() {
        return usedSize == this.elem.length;
    }
    // 判断栈是否为空
    public boolean isEmpty() {
        return usedSize == 0;
    }


    public static void main(String[] args) {

    }
}
