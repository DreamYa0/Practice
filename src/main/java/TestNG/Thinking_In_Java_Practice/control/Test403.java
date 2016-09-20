package TestNG.Thinking_In_Java_Practice.control;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test403 {
    public static long f(int x) {
        if (x==0) {
            return 0;
        }else {
            return 2*f(x-1)+x*x;
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long a = f(40);
        System.out.println(a);
    }
}

