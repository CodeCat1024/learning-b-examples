package d_stack.c_cases;

import java.util.Stack;

public class C_Cases {
    //递归打印链表
    /*public void display(ListNode pHead) {
        if (pHead == null) {
            return;
        }
        if (pHead.next == null) {
            System.out.print(pHead.val + " ");
            return;
        }
        display(pHead.next);
        System.out.print(pHead.val + " ");
    }
    */
    // 使用栈打印链表
    /*
    public void display(ListNode pHead) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 遍历栈
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            System.out.print(top.val + " ");
        }
        System.out.println();
    }
     */
    // 逆波兰表达式求值
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String x : tokens) {
            if (!isOperation(x)) {
                stack.push(Integer.parseInt(x));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch(x) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop();
    }
    // 判断是否为表达式
    private static boolean isOperation(String x) {
        return x.equals("+") || x.equals("-") || x.equals("/") || x.equals("*");
    }
    // 括号匹配
    private static boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char ch2 = stack.peek(); // 拿到左括号
                if (ch == ')' && ch2 == '(' || ch == '}' && ch2 == '{' || ch == ']' && ch2 == '[') {
                    stack.pop();
                } else {
                    return false; // 不匹配
                }
            }
        }
        return stack.empty();
    }
    // 根据入栈序列判断出栈序列是否合法
    private static boolean isPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int k : pushA) {
            stack.push(k);
            while (j < popA.length && !stack.empty() && stack.peek().equals(popA[j])) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
    // 最小栈

}
class MinStack {
}