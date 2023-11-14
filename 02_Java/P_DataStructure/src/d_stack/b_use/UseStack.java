package d_stack.b_use;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UseStack {
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
        System.out.println(stack.peek());

        // 获取元素个数
        System.out.println(stack.size());

        // 查看栈是否为空
        System.out.println(stack.empty());
    }
}
