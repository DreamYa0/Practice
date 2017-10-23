package thinkinginjava.exceptions;

/**
 * Created by DreamYao on 2016/7/20.
 * P259
 */
public class RethrowNew {
    public static void f() throws OneExceptoin {
        System.out.println("originating the exception in f()");
        throw new OneExceptoin("thrown from f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneExceptoin e) {
                System.out.println("Caught in inner try, e.printStackTrace()");
                throw new TwoException("from inner try");
            }

        } catch (TwoException e) {
            System.out.println("Caught in outer try, e.printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}

class OneExceptoin extends Exception {
    public OneExceptoin(String s) {
        super(s);
    }
}

class TwoException extends Exception {
    public TwoException(String s) {
        super(s);
    }
}
