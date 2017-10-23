package thinkinginjava.concurrency;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017 09 24 22:21
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<String>> results = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            results.add(service.submit(new TaskWithResult(i)));
        }
        results.forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            }finally {
                service.shutdown();
            }
        });
    }
}

class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
