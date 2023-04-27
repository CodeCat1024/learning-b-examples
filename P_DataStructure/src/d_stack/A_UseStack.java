package d_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A_UseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        // 出栈
        Integer a = stack.pop();
        System.out.println(a);

        // 查看栈顶数据
        Integer b = stack.peek();
        System.out.println(b);
        Integer c = stack.peek();
        System.out.println(c);

        // 获取元素个数
        System.out.println(stack.size());

        // 查看栈是否为空
        System.out.println(stack.empty());
        System.out.println(stack.isEmpty());
    }
}
