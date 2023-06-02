package d_stack.c_cases;

import c_linkedlist.a_implement.mySingleLinkedList.MySingleList;

import java.util.Stack;

/**
 * 使用栈打印链表
 */
public class A_DisplayLinkedList {
    public void display(MySingleList.ListNode head) {
        Stack<MySingleList.ListNode> stack = new Stack<>();
        MySingleList.ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 遍历栈
        while (!stack.isEmpty()) {
            MySingleList.ListNode top = stack.pop();
            System.out.print(top.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
