package Thinking_in_Java.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dreamyao
 * @version 1.0.0
 *          Created on 2017/10/15 15:23
 */
public class FairReentrantLock {

    private static final ReentrantLock fairLock = new ReentrantLock(true);

    private static class FairTestTask implements Runnable {

        @Override
        public void run() {
            System.out.println("#####线程的名字是：" + Thread.currentThread().getName() + "已经运行");
            try {
                fairLock.lock();
                System.out.println("----线程：" + Thread.currentThread().getName() + "获得锁");
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FairTestTask());
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
