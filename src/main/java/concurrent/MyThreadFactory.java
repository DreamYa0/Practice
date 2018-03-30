package concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/30 下午1:02
 * @since 1.0.0
 */
public class MyThreadFactory implements ThreadFactory {

    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new MyAppThread(r, poolName);
    }
}
