/**
 * 打印出线程的所有状态
 *
 * 在PCB里面分为阻塞和就绪
 * 在Java的Thread类又进一步细分了
 * NEW：安排了工作，还未开始行动
 * RUNNABLE：可工作的，又可分为工作中和即将开始工作（就绪状态）
 *
 * -----  以下三个都表示排队等着其他事情
 * BLOCKED：（当前线程在等待锁，导致了阻塞（阻塞状态之一））
 * WAITING：（当前线程在等待唤醒，导致了阻塞（阻塞状态之一））
 * TIME_WAITING: （在一定时间内是阻塞状态：代码中调用了sleep，或者使用.join()）
 *
 * TERMINATED：工作完成了（操作系统中的线程已经执行完毕，但Thread对象还在）
 */

public class J_ThreadState {
    public static void main(String[] args) {
        for (Thread.State state : Thread.State.values()){
            // 列举出线程的所有状态
            System.out.println(state);
        }
    }
}
