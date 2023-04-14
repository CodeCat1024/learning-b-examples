package thread;

/**
 * 该案例线程不安全的原因：count++到底干了什么？
 * 1.load：把内存中的count的值，给加载到CPU寄存器中
 * 2.add：把寄存器中的值+1
 * 3.save：把寄存器中的值写回到内存的count中
 * 正因为“抢占式执行”，这就导致两个线程同时执行这三个指令的时候，顺序上充满了随机性
 * 我们使用最频繁的是 synchronized 这个关键字
 */

/**
 * 日常开发中产生线程不安全的主要原因：
 * 1.线程是抢占式执行，线程间的调度充满随机性
 * 2.多个线程对同一个变量进行修改操作
 * 3.针对变量的操作不是原子的
 * 4.内存可见性：编译器优化
 * 5.指令重排序：编译器会智能地调整一些代码的前后顺序从而提高程序的效率（保证逻辑不变的前提）
 *            也是使用synchronized来进制指令重排序
 */

/**
 * synchronized 的使用方式
 * 1.直接修饰普通的方法
 * 本质是针对对象进行加锁
 * Java中的每个类都是继承自 Object，每个new出来的实例，里面除了你自己写的属性之外，还包含了“对象头”，也就是对象的一些元数据，这个是给JVM用的，比方说这里的synchronized
 * 这里的 synchronized 就是给对象头里设置了一个标志位
 * 如果针对普通方法去加锁，那么对象就是this
 * 因此两个线程如果是在对同一个对象抢着加锁，就会产生竞争，如果是针对不同对象进行加锁，就不会有竞争
 *
 * 2.修饰一个代码块
 * 需要显示指定针对哪个对象加锁（Java中的任意对象都可以作为锁对象）
 * 大多数语言都有专门的锁对象
 *
 * 3.修饰一个静态方法
 * 静态方法更应该叫“类方法”，普通方法更应该叫“实例方法”
 * 相当于针对当前类的类对象加锁
 * Counter.class （反射）
 */

class Counter {

    public int count;


    // public void increase() { count++; }
    // 写法1
    synchronized public void increase() {
        count++;
    }

    // 写法2
//    public void increase() {
//        synchronized (this) {
//            count++;
//        }
//    }
}

public class A_HelloThreadSafety {

    private static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
           for (int i = 0; i < 50000; i ++) {
               counter.increase();
           }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i ++) {
                counter.increase();
            }
        });

        t1.start();
        t2.start();

        // 必须在t1和t2都执行完之后再去打印count
        // 因为main和这两个线程就是并发的关系，所以有可能t1，t2还没执行完就去打印了count
        t1.join();
        t2.join();

        // 在main方法中打印一下两个线程自增完成之后得到的count结果
        System.out.println(counter.count);
    }

}
