package thinkinginjava.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dreamyao
 * @version 1.0.0
 *          Created on 2017/10/15 16:26
 */
public class ThreadPoolTest {

    public static void createCacheThreadPool(){
        // 可缓存线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 8; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName() + "被执行"));
        }
        executorService.shutdown();
    }

    public static void createFixedThreadPool(){
        // 创建一个可重用固定个数的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 6; i++) {
            final int number = i;
            executorService.execute(() -> {
                System.out.println(number);
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    public static void createScheduledThreadPool(){
        // 创建一个定长线程池，支持定时及周期性任务执行
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        System.out.println("调度线程池开始等待");
        scheduledExecutorService.schedule(() -> System.out.println("定时类型：已经延迟2秒，并执行"), 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }

    public static void createScheduleAtFixedRate(){
        // 创建一个定长线程池，支持定时及周期性任务执行
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        System.out.println("调度线程池开始等待");
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("周期类型：延迟2秒，并且没隔3秒执行一次"), 2, 3, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }

    public static void createSingleThreadExecutor(){
        // 创建一个单线程化的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            final int number = i;
            executorService.execute(() -> {
                System.out.println("间隔1秒，顺序打印。。。");
                System.out.println(number);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        // 创建数组型缓冲等待队列
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(10);
        // 创建自定义线程池，池中保持线程数为3，允许最大线程数为6
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 6, 50, TimeUnit.MILLISECONDS, blockingQueue);
        Runnable t1= ThreadPoolTest::getRunnable;
        Runnable t2= ThreadPoolTest::getRunnable;
        Runnable t3= ThreadPoolTest::getRunnable;
        poolExecutor.execute(t1);
        poolExecutor.execute(t2);
        poolExecutor.execute(t3);
        poolExecutor.shutdown();
    }

    private static void getRunnable() {
        System.out.println(Thread.currentThread().getName()+"被执行！");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
