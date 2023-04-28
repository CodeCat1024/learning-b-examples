package b_arraylist.b_useArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 演示了ArrayList的三种遍历方式
 */

public class C_Traversing {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        // 1.for循环
        System.out.println("1.for循环遍历的结果：");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\n");

        // 2.foreach
        System.out.println("2.foreach遍历的结果");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println("\n");

        // 3.迭代器
        System.out.println("3.迭代器遍历的结果：");
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n");

    }
}
