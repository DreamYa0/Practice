package concurrent;

import java.util.concurrent.Executor;

/**
 * @author dreamyao
 * @title 为每一个请求启动一个新线程的Executor
 * @date 2018/3/12 下午1:06
 * @since 1.0.0
 */
public class ThreadPerTaskExecutor implements Executor{
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
