package d_stack;

import java.util.Stack;

public class D_MakeQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public D_MakeQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void push(int x) {
        stack1.push(x);
    }
    public int pop() {
        if (empty()) {
            return -1;
        }

        if (stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public int peek() {
        if (empty()) {
            return -1;
        }

        if (stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

}

