package concurrent;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/9 下午4:21
 * @since 1.0.0
 */
@ThreadSafe
public class Memoizer3<A,V> implements Computable<A,V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> computable;

    public Memoizer3(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        Future<V> future = cache.get(arg);
        if (future == null) {
            Callable<V> eval= () -> computable.compute(arg);
            FutureTask<V> futureTask = new FutureTask<>(eval);
            future = futureTask;
            cache.put(arg, futureTask);
            futureTask.run();
        }
        try {
            return future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
