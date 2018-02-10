package concurrent.thread;

/**
 * @author dreamyao
 * @title
 * @date 2018/2/9 下午1:51
 * @since 1.0.0
 */
public class Daemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    private static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                SleepUtils.second(100);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
