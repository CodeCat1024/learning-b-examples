package d_stack.c_cases;

import java.util.Stack;

/**
 * 括号匹配
 */
public class D_isValid {
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
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
}
