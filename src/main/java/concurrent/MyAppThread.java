package concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/30 下午1:03
 * @since 1.0.0
 */
public class MyAppThread extends Thread {

    public static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLifecycle = false;
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger logger = LoggerFactory.getLogger(MyAppThread.class);

    public MyAppThread(Runnable target, String name) {
        super(target, name + "_" + created.incrementAndGet());
        setUncaughtExceptionHandler((t, e) -> logger.info("UNCAUGHT in thread" + t.getName(), e));
    }

    public void run(){
        boolean debug = debugLifecycle;
        if (debug) {
            logger.info("Created" + getName());
        }
        try {
            alive.incrementAndGet();
            super.run();
        }finally {
            alive.decrementAndGet();
            if (debug) {
                logger.info("Exiting " + getName());
            }
        }
    }

    public static int getThreadsCreaded(){
        return created.get();
    }

    public static int getThreadsAlive(){
        return alive.get();
    }

    public static boolean getDebug(){
        return debugLifecycle;
    }

    public static void setDebug(boolean b) {
        debugLifecycle = b;
    }
}
