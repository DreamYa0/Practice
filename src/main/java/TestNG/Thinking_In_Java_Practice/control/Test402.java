package TestNG.Thinking_In_Java_Practice.control;

/**
 * Created by DreamYao on 2016/5/19.
 */
import java.util.Random;

public class Test402 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int b = 0;
        for (int i = 1; i <= 25; i++) {
            int a = (new Random()).nextInt(100);//泛型

            if (i == 1) {
                System.out.print(a + " ");
            } else {
                if (b == a)
                    System.out.print("=" + a + " ");
                else if (b < a)
                    System.out.print("<" + a + " ");
                else
                    System.out.print(">" + a + " ");
            }
            b = a;
        }
    }
}
