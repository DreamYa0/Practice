package concurrent;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/9 下午4:28
 * @since 1.0.0
 */
@ThreadSafe
public class Memoizer<A,V> implements Computable<A,V> {

    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> computable;

    public Memoizer(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        while (true) {
            Future<V> future = cache.get(arg);
            if (future == null) {
                Callable<V> eval = () -> computable.compute(arg);
                FutureTask<V> futureTask = new FutureTask<>(eval);
                cache.putIfAbsent(arg, futureTask);
                future = futureTask;
                futureTask.run();
            }
            try {
                return future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (CancellationException e) {
                cache.remove(arg, future);
            }
        }
    }
}
