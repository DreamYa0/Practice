package Thinking_in_Java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017 09 24 22:16
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
    }
}
