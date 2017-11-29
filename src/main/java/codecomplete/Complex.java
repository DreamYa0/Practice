package codecomplete;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/11/12.
 *         用静态工厂方法来代替构造函数
 */
public class Complex {
    private final long re;
    private final long im;

    private Complex(long re, long im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(long re, long im) {
        return new Complex(re, im);
    }

    public static Complex valueOfPolar(long r, long theta) {
        long result = r << 2 + theta << 4;
        return new Complex(result,0);
    }

    @Override
    public String toString() {
        return "result= " + re;
    }
}
