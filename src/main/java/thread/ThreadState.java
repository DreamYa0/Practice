package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author dreamyao
 * @title
 * @date 2018/2/9 下午1:17
 * @since 1.0.0
 */
public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Watting(), "WattingThread").start();
        new Thread(new Blocked(), "BlockingThread-1").start();
        new Thread(new Blocked(), "BlockingThread-2").start();
    }

    private static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            while (true) {
                SleepUilts.second(100);
            }
        }
    }

    private static class Watting implements Runnable{
        @Override
        public void run() {
            while (true) {
                synchronized (Watting.class) {
                    try {
                        Watting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class Blocked implements Runnable{
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUilts.second(100);
                }
            }
        }
    }

    private static class SleepUilts{
        public static final void second(long seconds) {
            try {
                TimeUnit.SECONDS.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
