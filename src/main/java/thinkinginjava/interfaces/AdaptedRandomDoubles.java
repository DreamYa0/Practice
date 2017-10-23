package thinkinginjava.interfaces;

import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * Created by DreamYao on 2016/5/21.P183接口适配器模式
 * @author DreamYao
 */
public class AdaptedRandomDoubles extends RandomDoubles implements Readable {
    /**
     *
     */
    private int count;

    public AdaptedRandomDoubles(int count) {
        this.count = count;
    }

    /**
     *
     * @param cb 参数。
     * @return 返回result的长度。
     */
    public final int read(CharBuffer cb) {
        if (count-- == 0) {
            return -1;
        }
        String result = Double.toString(next());
        cb.append(result);
        return result.length();
    }

    /**
     * @param args 参数。
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomDoubles(7));
        while (s.hasNextDouble()) {
            System.out.println(s.nextDouble() + " ");
        }
    }
}
