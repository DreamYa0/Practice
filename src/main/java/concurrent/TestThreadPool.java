package concurrent;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/29 下午1:27
 * @since 1.0.0
 */
public class TestThreadPool {

    public void createThreadPool(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(20));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
