package thinkinginjava.concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * @author dreamyao
 * @title
 * @date 2017/12/23 下午3:47
 * @since 1.0.0
 */
public class DaemonThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread();
        thread.setDaemon(true);
        return thread;
    }
}
