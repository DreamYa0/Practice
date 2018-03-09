package concurrent;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/9 下午4:17
 * @since 1.0.0
 */
@ThreadSafe
public class Memoizer1<A,V> implements Computable<A,V> {

    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> computable;

    public Memoizer1(Computable<A, V> computable) {
        this.computable = computable;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = computable.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
