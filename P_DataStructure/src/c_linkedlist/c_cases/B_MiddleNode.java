package c_linkedlist.c_cases;

import c_linkedlist.a_implement.mySinglelist.MySingleList;

/**
 * 返回链表的中间节点（若有两个则返回第二个）
 * 使用快慢指针，快指针每次走两步，慢指针每次走一步
 * 当快指针走完时，慢所在位置即为中间节点
 */
public class B_MiddleNode {
    public static MySingleList.ListNode middleNode(MySingleList.ListNode head) {
        MySingleList.ListNode fast = head;
        MySingleList.ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(100);
        mySingleList.addFirst(200);
        mySingleList.addFirst(300);
        mySingleList.addFirst(400);
        mySingleList.addFirst(500);
        mySingleList.display();
        System.out.println(middleNode(mySingleList.head).val);
    }
}
