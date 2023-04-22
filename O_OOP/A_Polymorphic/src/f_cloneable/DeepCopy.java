package f_cloneable;

/**
 * 这里会把 money 也克隆一份
 */

class Money2 implements Cloneable{
    public double money = 12.5;

    @Override
    public String toString() {
        return "Money2{" +
                "money=" + money +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Student2 implements Cloneable {
    public String name;
    public Money2 m = new Money2();

    public Student2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                "money='" + m + '\'' +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 只是克隆了Student2对象
        Student2 student = (Student2) super.clone();
        // 克隆了Student2对象里面的Money对象
        student.m = (Money2) this.m.clone();
        return student;
        //return super.clone();
    }
}

public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException{
        Student2 student1 = new Student2("Kate");
        Student2 student2 = (Student2) student1.clone();
        System.out.println(student1);
        System.out.println(student2);

        student2.m.money = 88;
        System.out.println(student1);
        System.out.println(student2);

    }
}
