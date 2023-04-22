class OuterClass2 {
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;

    // 非静态内部类
    class InnerClass2 {
        public int data1 = 111;

        public int data4 = 4;
        private int data5 = 5;

        // 非静态内部类中无法定义静态变量
        // public static  int data6 = 6;

        // 除非变成常量的方式
        public static final int data6=  6;

        public void func() {
            System.out.println("NonStatic->InnerClass2::func()");

            System.out.println(this.data1); // 调用内部类的data1
            System.out.println(OuterClass2.this.data1); // 调用外部类的data1
            System.out.println(data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
        }
    }

    public void test() {

        InnerClass2 innerClass2 = new InnerClass2();

        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
        System.out.println(innerClass2.data4);
        System.out.println(innerClass2.data5);
        System.out.println(innerClass2.data6);
    }
}

public class B_NonStatic {
    public static void main(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        OuterClass2.InnerClass2 innerClass2 = outerClass2.new InnerClass2();
        innerClass2.func();
    }
}
