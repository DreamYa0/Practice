package TestNG.Thinking_in_Java.exceptions;

/**
 * Created by DreamYao on 2016/7/19.
 * P258 栈轨迹
 */
public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("---------------------");
        g();
        System.out.println("---------------------");
        h();
    }
}
