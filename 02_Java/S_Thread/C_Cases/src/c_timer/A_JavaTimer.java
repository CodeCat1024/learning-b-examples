package c_timer;

import java.util.Timer;
import java.util.TimerTask;

public class A_JavaTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello Timer");
            }
        }, 3000);
        System.out.println("main");
    }
}
