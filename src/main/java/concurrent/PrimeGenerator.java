package concurrent;


import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/14 下午8:23
 * @since 1.0.0
 */
@ThreadSafe
public class PrimeGenerator implements Runnable {

    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }
}
