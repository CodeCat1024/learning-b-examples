/**
 * 匿名内部类
 */

interface IA {
    void func();
}

class AA implements IA {

    @Override
    public void func() {
        System.out.println("Hello");
    }
}

public class C_Anonymity {
    public static void main(String[] args) {
        // 这二者是等价的

        AA aa = new AA();
        aa.func();

        // 这就相当于实现了IA接口，但这个类没有名字
        new IA(){
            @Override
            public void func() {
                System.out.println("Hello");
            }
        }.func();
    }
}
