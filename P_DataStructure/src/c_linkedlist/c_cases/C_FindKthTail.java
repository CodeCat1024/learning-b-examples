package c_linkedlist.c_cases;

import c_linkedlist.a_implement.mySinglelist.MySingleList;

/**
 * 输出链表中倒数第 k 个节点
 */
public class C_FindKthTail {
    /**
     * 让 fast 先走 k-1 步
     * fast 走完之后，和 slow 开始一步一步走
     * 当 fast.next 为空时，slow 所指的位置就是倒数第 k 个
     */
    public static void findKthTail2(MySingleList.ListNode head, int k) {
        int tmp = k;
        if (head == null) {
            System.out.println("抱歉，链表为空！");
        }
        if (k <= 0) {
            System.out.println("抱歉，输入的下标不合法！");
            return;
        }
        MySingleList.ListNode fast = head;
        MySingleList.ListNode slow = head;
        // fast 先走 k - 1 步
        while (tmp - 1 != 0) {
            fast = fast.next;
            if (fast == null) {
                System.out.println("抱歉，输入的下标不合法！");
                return;
            }
            tmp--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println("倒数第 " +  k +  " 个节点为：" + slow.val);

    }
    /**
     *  当 size() - 遍历的次数 = k 时，即表示找到倒数第 k 个节点
     */
    public static void findKthTail(MySingleList mySingleList, int k) {
        if (mySingleList.head == null) {
            System.out.println("抱歉，链表为空！");
            return;
        }
        if (k <= 0 || k > mySingleList.size()) {
            System.out.println("抱歉，输入的下标不合法！");
            return;
        }
        int count = 0;
        MySingleList.ListNode cur = mySingleList.head;
        while (cur != null) {
            if (k == mySingleList.size() - count) {
                // 找到该节点了！
                System.out.println("倒数第 " +  k +  " 个节点为：" + cur.val);
                return;
            }
            count++;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(500);
        mySingleList.addFirst(400);
        mySingleList.addFirst(300);
        mySingleList.addFirst(200);
        mySingleList.addFirst(100);
        mySingleList.display();
        findKthTail(mySingleList, 0);
        findKthTail(mySingleList, 1);
        findKthTail(mySingleList, 2);
        findKthTail(mySingleList, 3);
        findKthTail(mySingleList, 4);
        findKthTail(mySingleList, 5);
        findKthTail(mySingleList, 6);
        System.out.println();

        findKthTail2(mySingleList.head, 0);
        findKthTail2(mySingleList.head, 1);
        findKthTail2(mySingleList.head, 2);
        findKthTail2(mySingleList.head, 3);
        findKthTail2(mySingleList.head, 4);
        findKthTail2(mySingleList.head, 5);
        findKthTail2(mySingleList.head, 6);
    }
}
