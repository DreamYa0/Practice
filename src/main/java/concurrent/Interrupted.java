package concurrent;

import concurrent.thread.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author dreamyao
 * @title
 * @date 2018/2/10 下午6:02
 * @since 1.0.0
 */
public class Interrupted {

    public static void main(String[] args) throws Exception{
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        // 设置sleepThread线程的中断标记
        sleepThread.interrupt();
        // 设置busyThread线程的中断标记
        busyThread.interrupt();
        System.out.println("SleepThread interrupt is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupt is " + busyThread.isInterrupted());
        SleepUtils.second(2);
    }

    private static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    private static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
