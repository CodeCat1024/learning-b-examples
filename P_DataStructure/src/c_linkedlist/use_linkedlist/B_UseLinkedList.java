package c_linkedlist.use_linkedlist;

import java.util.LinkedList;
import java.util.List;

public class B_UseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list.size());
        System.out.println(list);

        list.add(100);
        list.add(0, 0);
        System.out.println(list);

        list.remove();
        list.removeFirst();
        list.removeLast();
        list.remove(1);
        System.out.println(list);

        if(!list.contains(1)) {
            list.add(0, 1);
        }
        System.out.println(list);
        System.out.println(list.indexOf(1));
        System.out.println(list.lastIndexOf(6));

        int elem = list.get(0);
        System.out.println(elem);
        list.set(0, 100);
        System.out.println(list);

        // 用 list 中[from, to]之间的元素构造一个新的 LinkedList 返回
        List<Integer> copy = list.subList(0, 3);
        System.out.println(list);
        System.out.println(copy);

        list.clear();
        System.out.println(list.size());

    }
}
