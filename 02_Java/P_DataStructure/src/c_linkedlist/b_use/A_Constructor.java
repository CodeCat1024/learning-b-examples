package c_linkedlist.b_use;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A_Constructor {
    public static void main(String[] args) {
        // 1.构造空的 LinkedList
        List<String> list1 = new LinkedList<>();
        System.out.println(list1);

        // 2.使用其他集合容器中的元素构造 LinkedList
        List<String> list2 = new ArrayList<>();
        list2.add("JavaSE");
        list2.add("JavaWeb");
        List<String> list3 = new LinkedList<>(list2);
        System.out.println(list3);
    }
}
