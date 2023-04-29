package e_queue.c_cases;

import java.util.LinkedList;
import java.util.Queue;

public class E_MakeStack {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;

    public E_MakeStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int x) {
        if(!qu1.isEmpty()) {
            qu1.offer(x);
        } else if (!qu2.isEmpty()) {
            qu2.offer(x);
        }else {
            qu1.offer(x);
        }
    }

    public int pop() {
        if(empty()) {
            return -1;//两个队列都为空，意味着当前的栈为空
        }
        if(!qu1.isEmpty()) {
            int size = qu1.size();
            for (int i = 0; i < size-1; i++) {
                //for (int i = 0; i < qu1.size()-1; i++) {
                int val = qu1.poll();
                qu2.offer(val);
            }
            return qu1.poll();
        }else {
            int size = qu2.size();
            for (int i = 0; i < size-1; i++) {
                int val = qu2.poll();
                qu1.offer(val);
            }
            return qu2.poll();
        }
    }
    //peek
    public int top() {
        if(empty()) {
            return -1;//两个队列都为空，意味着当前的栈为空
        }
        if(!qu1.isEmpty()) {
            int size = qu1.size();
            int val = -1;
            for (int i = 0; i < size; i++) {
                val = qu1.poll();
                qu2.offer(val);
            }
            return val;
        }else {
            int size = qu2.size();
            int val = -1;
            for (int i = 0; i < size; i++) {
                val = qu2.poll();
                qu1.offer(val);
            }
            return val;
        }
    }

    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}
