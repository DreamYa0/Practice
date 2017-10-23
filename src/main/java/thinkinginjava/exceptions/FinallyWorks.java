package thinkinginjava.exceptions;

/**
 * Created by DreamYao on 2016/7/20.
 * P264 使用finally进行清理
 */
public class FinallyWorks {
    static int count = 0;
    public static void main(String[] args) {
        while (true) {
            try {
                if (count++ == 0) {
                    throw new TreeException();
                }
                System.out.println("No exception");
            } catch (TreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if (count == 2) {
                    break;
                }
            }
        }
    }
}

class TreeException extends Exception {
}
