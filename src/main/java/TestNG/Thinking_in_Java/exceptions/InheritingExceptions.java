package TestNG.Thinking_in_Java.exceptions;

/**
 * Created by DreamYao on 2016/7/16.
 * P252创建自定义异常
 */
public class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}

class SimpleException extends Exception {
}