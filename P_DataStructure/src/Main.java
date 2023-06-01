import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("hello1");
        list1.add("hello2");
        list1.add("hello3");
        list1.add("hello4");
        list1.add("hello5");
        List<String> list2 = list1.subList(0, 3);
        System.out.println("修改前");
        System.out.println(list1);
        System.out.println(list2);

        list1.set(0, "HELLO1");
        list1.set(1, "HELLO2");
        list1.set(2, "HELLO3");
        System.out.println("修改前");
        System.out.println(list1);
        System.out.println(list2);
    }
}