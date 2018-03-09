package concurrent;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/9 下午4:14
 * @since 1.0.0
 */
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
