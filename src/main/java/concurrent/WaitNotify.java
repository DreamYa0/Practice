package concurrent;

import concurrent.thread.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author dreamyao
 * @title
 * @date 2018/2/10 下午7:14
 * @since 1.0.0
 */
public class WaitNotify {

    private static boolean flag = true;
    private static Object lock = new Object();

    public static void main(String[] args) throws Exception{
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    private static class Wait implements Runnable{
        @Override
        public void run() {
            // 加锁,拥有lock的监视器锁
            synchronized (lock) {
                // 当条件不满足时,继续等待,同时释放锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + "flag is true. wait@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        // 进入等待状态,然后释放锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 条件满足时正常工作
                System.out.println(Thread.currentThread() + "flag is false. wait@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    private static class Notify implements Runnable{
        @Override
        public void run() {
            // 加锁,拥有lock的监视器锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + "hold lock. notify@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                // 获取lock的锁,然后进行通知,通知不会释放lock的锁
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }

            // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + "hold lock again. notify@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }
}
