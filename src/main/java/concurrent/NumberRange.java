package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/4 下午9:03
 * @since 1.0.0
 */
public class NumberRange {

    /**
     * 不变性条件：lower <= upper
     */
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    /**
     * 虽然lower和upper都是原子操作，但是在serLower中为复合操作，但setLower不是原子操作（没进行加锁）所有setLower不是线程安全的
     * @param i
     */
    public void setLower(int i) {
        // 注意--不安全的“先检查后执行”
        if (i > upper.get()) {
            throw new IllegalArgumentException("can't set lower to " + i + " > upper");
        }
        lower.set(i);
    }

    /**
     * 虽然lower和upper都是原子操作，但是在setUpper中为复合操作，但setUpper不是原子操作（没进行加锁）所有setUpper不是线程安全的
     * @param i
     */
    public void setUpper(int i) {
        // 注意--不安全的“先检查后执行”
        if (i < lower.get()) {
            throw new IllegalArgumentException("can't set upper to " + i + " > lower");
        }
        upper.set(i);
    }
}
