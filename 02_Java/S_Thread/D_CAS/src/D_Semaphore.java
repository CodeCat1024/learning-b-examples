import java.util.concurrent.Semaphore;

public class D_Semaphore {
    public static void main(String[] args) throws InterruptedException {
        // 初始化的值表示可用資源有4个
        Semaphore semaphore = new Semaphore(4);
        // 申请资源，P操作，参数表示申请的资源数
        // 最多只能申请4个，接下来就会产生阻塞，除非释放之后再次申请
        semaphore.acquire();
        System.out.println("申请成功");
        semaphore.acquire();
        System.out.println("申请成功");
        semaphore.acquire();
        System.out.println("申请成功");
        semaphore.acquire();
        System.out.println("申请成功");
        semaphore.acquire();
        System.out.println("申请成功");

        // semaphore.acquire(2);


        // 释放资源，V操作，参数表示释放的资源数
        semaphore.release();
        System.out.println("释放成功");
        //semaphore.release(2);

    }
}
