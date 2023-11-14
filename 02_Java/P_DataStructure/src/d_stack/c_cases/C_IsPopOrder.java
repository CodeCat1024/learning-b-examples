package d_stack.c_cases;

import java.util.Stack;

/**
 * 根据入栈序列判断出栈序列是否合法
 */
public class C_IsPopOrder {
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
}
