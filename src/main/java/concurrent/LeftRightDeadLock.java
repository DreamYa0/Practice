package concurrent;

/**
 * @author dreamyao
 * @title
 * @date 2018/4/4 下午1:28
 * @since 1.0.0
 */
public class LeftRightDeadLock {

    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {

            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {

            }
        }
    }
}
