package TestNG.Thinking_in_Java.exceptions;

/**
 * Created by DreamYao on 2016/7/19.
 * P257捕获所有异常
 */
public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("GetMessage(): " + e.getMessage());
            System.out.println("GetLocalizedMessage(): " + e.getLocalizedMessage());
            System.out.println("toString():" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}
