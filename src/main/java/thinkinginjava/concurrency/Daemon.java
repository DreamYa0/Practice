package thinkinginjava.concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

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
        /*for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new SimpleDaemons());
        }*/

    }

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(SimpleDaemons::new);
        singleThreadPool.shutdown();
    }
}
