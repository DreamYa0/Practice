package TestNG.Thinking_in_Java.exceptions;

/**
 * Created by DreamYao on 2016/7/16.
 * P252可为异常类定义一个接受字符串参数的构造器
 */
public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throw MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}