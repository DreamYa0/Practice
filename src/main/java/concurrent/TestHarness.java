package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/9 下午1:30
 * @since 1.0.0
 */
public class TestHarness {

    public long timeTasks(int nxThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(nxThreads);
        final CountDownLatch endGate = new CountDownLatch(nxThreads);
        for (int i = 0; i < nxThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
