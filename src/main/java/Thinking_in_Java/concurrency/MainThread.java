package Thinking_in_Java.concurrency;

/**
 * Created by dreamyao on 2017/9/21.
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
