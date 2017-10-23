package thinkinginjava.concurrency;

/**
 * Created by dreamyao on 2017/9/21.
 */
public class BasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.start();
            System.out.println("Waiting for LIftOff!");
        }
    }
}
