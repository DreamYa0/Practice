package Thinking_in_Java.concurrency;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017 09 27 21:31
 */
public class Daemon implements Runnable {

    private Thread[] threads = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new SimpleDaemons());
        }
    }
}
