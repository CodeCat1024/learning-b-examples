class OuterClass3 {
    public void func() {
        class InnerClass {
            public int a = 1;
            public void test() {
                System.out.println("Hello");
            }
        }

        // 只能在这里用（基本用不到）
        InnerClass innerClass = new InnerClass();
        innerClass.test();
    }
}


public class D_Local {
    public static void main(String[] args) {
        OuterClass3 outerClass3 = new OuterClass3();
        outerClass3.func();

    }
}
