package Thinking_in_Java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017 09 24 22:31
 */
public class SleepingTask extends LiftOff {

    @Override
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.println(status());
                TimeUnit.MICROSECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(new SleepingTask());
        }
        service.shutdown();
    }
}
