package b_arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示了ArrayList的四种构造方式
 */

public class A_Constructor {
    public static void main(String[] args) {
        // 1.构造空的列表
        List<Integer> list1 = new ArrayList<>();

        // 2.构造一个具体10个容量的列表
        List<Integer> list2 = new ArrayList<>(10);

        // 3.list3构造之后，与list1中的元素一致
        List<Integer> list3 = new ArrayList<>(list1);

        // 4.可以存放所有类型的元素（不推荐）
        List list4 = new ArrayList();

    }
}
