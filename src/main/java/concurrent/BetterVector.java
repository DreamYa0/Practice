package concurrent;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Vector;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/6 下午10:01
 * @since 1.0.0
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }
}
