class OuterClass {
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;

    static class InnerClass {
        public int data4 = 4;
        private int data5 = 5;
        public static int data6 = 6;

        public void func() {
            System.out.println("static->InnerClass::func()");
            // 在静态内部类中无法直接访问外部类的非静态成员
            // System.out.println(data1);
            // System.out.println(data2);

            // 得先实例化一个外部类
            OuterClass outerClass = new OuterClass();
            System.out.println(outerClass.data1);
            System.out.println(outerClass.data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
        }
    }

    public void test() {

        InnerClass innerClass = new InnerClass();

        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
        System.out.println(innerClass.data4);
        System.out.println(innerClass.data5); // 外部类可以访问静态内部类中的所有成员
        System.out.println(InnerClass.data6);
    }
}

public class A_Static {
    public static void main(String[] args) {
        // 实例化静态内部类
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
    }
}
