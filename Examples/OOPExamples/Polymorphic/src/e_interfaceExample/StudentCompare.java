package e_interfaceExample;

/**
 *
 */

import java.util.Arrays;

class Student implements Comparable<Student>{
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

    public Student(String name, int age, int score) {
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

    @Override
    public int compareTo(Student o) {
        /*if(this.age > o.age) {
            return 1;
        }else if (this.age < o.age) {
            return -1;
        } else {
            return 0;
        }*/

        if(this.name.compareTo(o.name) > 0) {
            return 1;
        } else if (this.name.compareTo(o.name) <0) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class StudentCompare {
    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++ ){
            for (int j = 0; j < array.length - 1 - i; j++) {
                /* if(array[j] > array[j+1]) {
                    交换
                }
                 */
                if (array[j].compareTo(array[j + 1]) > 0) {
                    Comparable tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }


            }
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("zhangsan", 19, 20);
        students[1] = new Student("lisi", 20, 41);
        students[2] = new Student("wangwu", 24, 55);

        System.out.println(Arrays.toString(students));
        sort(students);
        //Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
