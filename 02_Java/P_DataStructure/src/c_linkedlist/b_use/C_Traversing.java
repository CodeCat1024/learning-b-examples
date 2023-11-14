package c_linkedlist.b_use;

import java.util.LinkedList;
import java.util.ListIterator;

public class C_Traversing {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        // get()方法遍历
        System.out.println("get()方法遍历：");
        for (int i = 0; i < list.size(); i++ ){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // foreach
        System.out.println("foreach 遍历：");
        for (int e : list) {
            System.out.print(e + " ");
        }
        System.out.println();

        // 迭代器 -- 正向遍历
        System.out.println("迭代器正向遍历：");
        ListIterator<Integer> it = list.listIterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 迭代器 -- 反向遍历
        System.out.println("迭代器反向遍历：");
        ListIterator<Integer> rit = list.listIterator(list.size());
        while(rit.hasPrevious()) {
            System.out.print(rit.previous() + " ");
        }
        System.out.println();
    }
}
