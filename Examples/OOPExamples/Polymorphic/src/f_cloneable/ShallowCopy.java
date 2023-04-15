package f_cloneable;

/**
 * 实现对自定义类型的拷贝了，当前实现的是浅拷贝（修改克隆之后的一个会影响另一个）
 * 空接口（标记接口）：作用就是表示当前对象是可以被克隆的
 * 这里面两个student指向的同一块m
 */

class Money {
    public double money = 12.5;

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }
}

class Student implements Cloneable {
    public String name;
    public Money m = new Money();

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                "money='" + m + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException{
        Student student1 = new Student("Kate");
        Student student2 = (Student) student1.clone();
        System.out.println(student1);
        System.out.println(student2);

        student2.m.money = 88;
        System.out.println(student1);
        System.out.println(student2);

    }
}
