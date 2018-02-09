package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author dreamyao
 * @title
 * @date 2018/2/9 下午1:52
 * @since 1.0.0
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
