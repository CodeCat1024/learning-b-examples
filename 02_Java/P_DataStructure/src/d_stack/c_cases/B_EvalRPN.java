package d_stack.c_cases;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 */
public class B_EvalRPN {
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

    public static void main(String[] args) {

    }
}
