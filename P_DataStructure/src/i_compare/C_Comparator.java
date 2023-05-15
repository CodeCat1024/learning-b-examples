package i_compare;

import java.util.Comparator;

/**
 * 使用 Comparator进行比较
 */
class Student3{

    public String name;
    public int age;
    public Student3(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// 姓名比较器
class NameComparator implements Comparator<Student3> {
    @Override
    public int compare(Student3 o1, Student3 o2) {
        return o1.name.compareTo(o2.name);
    }
}
// 年龄比较器
class AgeComparator implements Comparator<Student3> {
    @Override
    public int compare(Student3 o1, Student3 o2) {
        return o1.age - o2.age;
    }
}

public class C_Comparator {
    public static void main(String[] args) {
        Student3 student1 = new Student3("zhangsan", 10);
        Student3 student2 = new Student3("zhangsan", 10);

        NameComparator nameComparator = new NameComparator();
        System.out.println(nameComparator.compare(student1, student2));

        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(student1, student2));
    }
}
