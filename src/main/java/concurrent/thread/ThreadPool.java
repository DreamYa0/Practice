package concurrent.thread;

/**
 * @author dreamyao
 * @title
 * @date 2018/2/16 下午2:45
 * @since 1.0.0
 */
public interface ThreadPool<T extends Runnable> {
    /**
     * 执行一个job,这个job需要实现Runable
     * @param job
     */
    void execute(T job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 增加工作者线程
     * @param num
     */
    void addWorkers(int num);

    /**
     * 减少工作者线程
     * @param num
     */
    void removeWorker(int num);

    /**
     * 得到正在等待执行的任务数
     * @return
     */
    int getJobSize();
}
