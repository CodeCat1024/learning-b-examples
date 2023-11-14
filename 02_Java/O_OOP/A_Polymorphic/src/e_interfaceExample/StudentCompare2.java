package e_interfaceExample;

/**
 * 前面那个使用的是Comparable，比较的东西写死了，所以我们可以换成Comparator，更加灵活
 * 这样可以达到解耦，不需要写在Student类里面
 */

import java.util.Arrays;
import java.util.Comparator;

class Student2 {
    public String name;
    public int age;
    public int score;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public Student2(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}

class NameComparator implements Comparator<Student2> {

    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o1.name.compareTo(o2.name);
    }
}

class AgeComparator implements Comparator<Student2> {

    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o2.age - o1.age;
    }
}

class ScoreComparator implements Comparator<Student2> {

    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o1.score - o2.score;
    }
}



public class StudentCompare2 {

    public static void main(String[] args) {
        Student2[] students2 = new Student2[3];
        students2[0] = new Student2("zhangsan", 19, 20);
        students2[1] = new Student2("lisi", 20, 41);
        students2[2] = new Student2("wangwu", 24, 55);

        // 比较器
        NameComparator nameComparator = new NameComparator();
        AgeComparator ageComparator = new AgeComparator();
        ScoreComparator scoreComparator = new ScoreComparator();

        System.out.println(Arrays.toString(students2));
        System.out.println("根据姓名比较的结果为：");
        Arrays.sort(students2, nameComparator);
        System.out.println(Arrays.toString(students2));

        System.out.println(Arrays.toString(students2));
        System.out.println("根据年龄比较的结果为：");
        Arrays.sort(students2, ageComparator);
        System.out.println(Arrays.toString(students2));

        System.out.println(Arrays.toString(students2));
        System.out.println("根据分数比较的结果为：");
        Arrays.sort(students2, scoreComparator);
        System.out.println(Arrays.toString(students2));


    }
}

