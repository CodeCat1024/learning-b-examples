package c_linkedlist.mysinglelist;

import java.util.Stack;

/**
 * 无头单向非循环链表实现
 */
public class MySingleList {

    // 加不加 static 都可以
    static class ListNode {
        public int val;   //存储的数据
        public ListNode next; //存储下一个节点的地址

        public ListNode(int val) {
            this.val = val;
        }
    }
    // 代表当前头结点的引用
    public ListNode head;
    // 创建列表
    public void createLink() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(45);
        ListNode node3 = new ListNode(23);
        ListNode node4 = new ListNode(90);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = node1;
    }
    // 遍历列表
    public void display() {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }
    // 从指定位置开始打印链表
    public void display(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }
    // 查找 key 是否在单链表中
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    // 得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    // 头插法 O(1)
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }
    // 尾插法 O(N)
    public void addLast(int data) {
        ListNode node = new ListNode(data);

        // 链表为空的情况
        if (head == null) {
            head = node;
            return;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = node;
    }
    // 任意位置插入，第一个节点为0号下标
    public void addIndex(int index, int data) throws ListIndexOutOfException {
        checkIndex(index);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode cur = findIndexSubOne(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
    }
    // 检查插入的位置是否合法
    private void checkIndex(int index) throws ListIndexOutOfException {
        if (index < 0 || index > size()) {
            throw new ListIndexOutOfException("抱歉，index位置不合法！");
        }
    }
    // 找到 index - 1 位置的节点的地址
    private ListNode findIndexSubOne(int index) {
        ListNode cur = head;
        int count = 0;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
    // 删除第一次出现 key 的节点
    public void remove(int key) {
        // 链表为空
        if (head == null) {
            return;
        }
        if (head.val == key) {
            head = head.next;
            return;
        }
        // 当前节点
        ListNode cur = searchPrev(key);
        if (cur == null) {
            return;
        }
        // 要删除的节点
        ListNode del = cur.next;
        // cur.next = cur.next.next;
        cur.next = del.next;
    }
    // 找到 key 的前一个节点
    private ListNode searchPrev(int key) {

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        // 没有要删除的节点
        return null;
    }
    // 删除所有值为 key 的节点
    public void removeAllKey(int key) {
        if (head == null) {
            return;
        }
//        while (head.val == key) {
//            head = head.next;
//        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        if (head.val == key) {
            head = head.next;
        }
    }
    // 清空链表
    public void clear() {
        // 其他节点都会被自动回收
        // 没有被指向的对象都会被JVM回收的
        head = null;
    }

    // ----------------------- 队列的应用 ----------------
    // 使用递归打印链表
    public void display2(ListNode pHead) {
        if (pHead == null) {
            return;
        }
        if (pHead.next == null) {
            System.out.print(pHead.val + " ");
            return;
        }
        display2(pHead.next);
        System.out.print(pHead.val + " ");
    }
    // 使用栈打印链表
    public void display3() {
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

    // ------------------------- 在线Oj题目----------------

    // 链表反转
    public ListNode reverseList() {
        if (head == null){
            return null;
        }
        // 说明只有一个节点
        if (head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        // 逐个反转
        while (cur != null) {
            ListNode curNext = cur.next;
            // 头插法 插入cur
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }
    // 返回链表的中间节点（若有两个中间节点，则返回第二个）
    public ListNode middleNode() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // 输出链表中倒数第 k 个节点
    public ListNode findKthTail(int k) {
        /**
         * 让 fast 先走 k-1 步
         * fast 走完之后，和 slow 开始一步一步走
         * 当 fast.next 为空时，slow 所指的位置就是倒数第 k 个
         */
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // fast 走 k-1 步
        while (k-1 != 0) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            k--;
        }
        // 一起走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    // 判断链表是否为回文结构
    public boolean checkPalindrome() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        // 找到中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转
        ListNode cur = slow.next; // 代表当前需要反转的节点
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            // 都往后走
            slow = cur;
            cur = curNext;
        }
        // 一个从前往后，一个从后往前
        while (slow != head) {
            if (head.val != slow.val) {
                return false;
            }
            // 偶数情况的判断
            if (head.next == slow) {
                return true;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    // 以 x 将链表分为两部分，将所有小于 x 的节点排在其余节点之前（且不能改变原来的顺序）
    public ListNode partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;

        ListNode cur = head;
        while (cur != null) {
            if(cur.val < x) {
                if(bs == null) {
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        // 有可能不会同时存在小于x 和 大于等于x 的数据
        if(bs == null) {
            return as;
        }
        //第一段不为空
        be.next = as;
        //第2个段为空不为空的问题
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }
    // 创建环
    public void createLoop() {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head.next.next;
    }
    // 判断链表中是否有环，不能仅仅判断是否有null，因为可能链表会很长（追及问题）
    public boolean hasCycle() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
    // 返回第一个入环节点
    public ListNode detectCycle() {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }



    // todo: 写一下测试该方法的代码
    // 找出两个链表的第一个公共节点
    public static void main6(String[] args) {

    }
    // todo: 写一下测试该方法的代码
    // 根据 x 进行分割
    public static void main5(String[] args) {
    }
    // 合并两个链表并排序
    public static void main4(String[] args) {
        MySingleList mySingleList1 = new MySingleList();
        mySingleList1.addLast(11);
        mySingleList1.addLast(21);
        mySingleList1.addLast(31);
        mySingleList1.addLast(41);
        System.out.println("链表1为：");
        mySingleList1.display();

        MySingleList mySingleList2 = new MySingleList();
        mySingleList2.addLast(8);
        mySingleList2.addLast(15);
        mySingleList2.addLast(25);
        mySingleList2.addLast(30);
        System.out.println("链表2为：");
        mySingleList2.display();

        MySingleList.ListNode ret2 =
                mergeTwoLists(mySingleList1.head,mySingleList2.head);
        System.out.println("合并后的链表为：");
        mySingleList2.display(ret2);
    }
    // 判断是否为回文
    public static void main3(String[] args) {
        MySingleList mySingleList3 = new MySingleList();
        mySingleList3.addLast(10);
        mySingleList3.addLast(20);
        mySingleList3.addLast(30);
        mySingleList3.addLast(20);
        mySingleList3.addLast(10);
        System.out.println("要判断的链表为：");
        mySingleList3.display();
        System.out.println("是否为回文列表：" + mySingleList3.checkPalindrome());
    }
    // 判断是否存在环 && 返回入环的第一个节点
    public static void main(String[] args) {
        // 判断是否存在环
        MySingleList mySingleList1 = new MySingleList();
        mySingleList1.addLast(11);
        mySingleList1.addLast(21);
        mySingleList1.addLast(31);
        mySingleList1.addLast(41);
        System.out.println("链表1为：");
        mySingleList1.display2(mySingleList1.head);
        mySingleList1.display3();
        mySingleList1.createLoop();
        System.out.println(mySingleList1.hasCycle());

        // 返回入环的第一个节点
        System.out.println(mySingleList1.detectCycle().val);


    }
    // 基础测试
    public static void main1(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.createLink();
        mySingleList.display();
        mySingleList.display();
        System.out.println(mySingleList.contains(920));
        System.out.println("链表的长度为：" + mySingleList.size());
        mySingleList.addFirst(100);
        mySingleList.addLast(200);
        mySingleList.display();
        mySingleList.addIndex(3, 89);
        mySingleList.addIndex(0, 89);
        mySingleList.addIndex(mySingleList.size(), 666);
        mySingleList.display();
        mySingleList.removeAllKey(89);
        mySingleList.display();
        MySingleList.ListNode ret = mySingleList.reverseList();
        mySingleList.display(ret);
        mySingleList.display(mySingleList.middleNode());
        System.out.println(mySingleList.middleNode().val);
        mySingleList.display(mySingleList.findKthTail(5));

    }





    // 合并两个有序链表，返回为新的升序链表
    public static MySingleList.ListNode mergeTwoLists
    (MySingleList.ListNode head1, MySingleList.ListNode head2) {
        MySingleList.ListNode newHead = new MySingleList.ListNode(0);
        MySingleList.ListNode tmp = newHead;

        while (head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tmp.next = head1;
                head1 = head1.next;
            }else {
                tmp.next = head2;
                head2 = head2.next;
            }
            tmp = tmp.next;
        }
        if(head1 != null) {
            tmp.next = head1;
        }
        if(head2 != null) {
            tmp.next = head2;
        }
        return newHead.next;
    }
    // 找出两个链表的第一个公共节点
    public static MySingleList.ListNode getIntersectionNode
            (MySingleList.ListNode headA, MySingleList.ListNode headB) {

        if(headA == null && headB == null) {
            return null;
        }

        //1、分别求两个链表的长度
        int lenA = 0;
        int lenB = 0;
        MySingleList.ListNode pl = headA;
        MySingleList.ListNode ps = headB;
        while (pl != null) {
            lenA++;
            pl = pl.next;
        }
        while (ps != null) {
            lenB++;
            ps = ps.next;
        }
        //2. 要指回来
        pl = headA;
        ps = headB;
        int len = lenA - lenB;//大小
        //3、根据Length的值 修改指向
        if(len < 0) {
            pl = headB;
            ps = headA;
            len = lenB-lenA;
        }
        //1. len一定是一个正数  2.pl指向的链表一定是最长的  ps 指向的链表一定是最短的

        while (len != 0) {
            pl = pl.next;
            len--;
        }
        while (pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        //pl == ps
       /* if(pl == null) {
            return null;
        }
        return pl;*/
        return pl;
    }

}
