package concurrent;

import javax.annotation.concurrent.GuardedBy;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/7 下午8:44
 * @since 1.0.0
 */
public class HiddenIterator {

    @GuardedBy("this")
    private final Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer i) {
        set.add(i);
    }

    public synchronized void remove(Integer i) {
        set.remove(i);
    }

    public void addTenThings(){
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            add(random.nextInt());
        }
        // 隐藏在字符串连接中的迭代操作
        System.out.println("DEBUG: added ten elements to " + set);
    }
}
