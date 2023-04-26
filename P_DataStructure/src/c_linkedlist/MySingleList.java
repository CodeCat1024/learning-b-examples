package c_linkedlist;

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

    // ------------------------- 在线Oj题目----------------

    public void clear() {
        // 其他节点都会被自动回收
        // 没有被指向的对象都会被JVM回收的
        head = null;
    }
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


    public static void main(String[] args) {

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

    // 判断链表是否为回文结构

}
