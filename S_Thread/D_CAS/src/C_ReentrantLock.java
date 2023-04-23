import java.util.concurrent.locks.ReentrantLock;

public class C_ReentrantLock {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        // 指定为公平锁
        // ReentrantLock locker = new ReentrantLock(true);

        // 加锁
        locker.lock();
        // 解锁
        locker.unlock();
    }
}
