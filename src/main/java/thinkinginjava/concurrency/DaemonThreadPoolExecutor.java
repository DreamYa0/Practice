package thinkinginjava.concurrency;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dreamyao
 * @title
 * @date 2017/12/23 下午3:53
 * @since 1.0.0
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {

    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(),new DaemonThreadFactory());
    }
}
