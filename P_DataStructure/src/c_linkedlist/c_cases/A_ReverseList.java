package c_linkedlist.c_cases;

import c_linkedlist.a_implement.mySinglelist.MySingleList;

/**
 * 逆置链表：将 head.next 置空之后，再把 head 后的所有节点以头插的方式进行插入
 */
public class A_ReverseList {
    public static MySingleList.ListNode reverseList(MySingleList.ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        MySingleList.ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            // 记录下 cur 的下一个节点
            MySingleList.ListNode curNext = cur.next;
            // 进行头插
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }
    // todo:试一下从穷举到最终得出普适规律
    public static MySingleList.ListNode MyReverseList(MySingleList.ListNode head) {
        // 0个节点
        if (head == null) {
            System.out.println("抱歉，链表为空！");
        }
        // 1个节点
        if (head.next == null) {
            System.out.println("链表只有一个节点，反转后仍为原节点！");
        }
        // 2个节点
        if (head.next.next == null) {
            // 1.头尾相连
            head.next.next = head;
            // 2.进行逆置
            head = head.next;
            // 3.让最初头的下一个节点为空
            head.next.next = null;
        }
        // 3个节点
        if (head.next.next.next == null) {
            // 1.头尾相连
            head.next.next.next = head;
            // 2.进行逆置
            head = head.next.next;

            // 3.让最初头的下一个节点为空
            head.next.next.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(100);
        mySingleList.addFirst(200);
        mySingleList.addFirst(300);
        mySingleList.addFirst(400);
        mySingleList.addFirst(500);
        mySingleList.display();
        mySingleList.head = reverseList(mySingleList.head);
        mySingleList.display();
    }
}
