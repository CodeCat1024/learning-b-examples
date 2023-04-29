package b_arraylist.b_use;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示了ArrayList的基本使用
 * add(), get(), set(), size(), remove(), contains(), indexOf(), lastIndexOf(), subList(), clear(), isEmpty()
 */
public class B_UseArrayList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        // 新增元素
        list.add("JavaSE");
        list.add("JavaWeb");
        list.add("JavaEE");
        list.add("JVM");
        System.out.println(list);

        System.out.println(list.isEmpty());

        // 根据下标新增元素
        list.add(1, "数据结构");
        System.out.println(list);

        // 获取元素个数
        System.out.println(list.size());

        // 根据下标修改元素以及获取元素
        list.set(2, "NewJavaWeb");
        System.out.println(list.get(2));

        // 根据名称移除元素
        list.remove("JVM");
        System.out.println(list);

        // 根据下标移除元素
        list.remove(list.size() - 1);
        System.out.println(list);

        // 检测list中是否包含指定元素，是则返回true，否则返回false
        if (!list.contains("计算机网络")) {
            list.add("计算机网络");
        }
        System.out.println(list);

        // 查找指定元素第一次出现的位置
        System.out.println(list.indexOf("数据结构"));

        // 从后往前找
        System.out.println(list.lastIndexOf("数据结构"));

        // 使用list中[0, 4)之间的元素构成一个新的subList返回,但是和ArrayList共用一个elementData数组
        // 还是不太明白这个 subList
        List<String> ret = list.subList(0, 4);
        System.out.println(ret);

        // 清空列表
        list.clear();
        System.out.println(list.size());
    }
}
