package v_compare;

/**
 * 使用 Comparable 接口进行比较
 */
class Student2 implements Comparable<Student2>{
    private String name;
    public int age;

    public Student2 (String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student2 o) {
        return this.age - o.age;
    }
}

public class B_Comparable {
    public static void main(String[] args) {
        Student2 student1 = new Student2("zhangsan", 10);
        Student2 student2 = new Student2("zhangsan", 10);
        System.out.println(student1.compareTo(student2));
    }
}
