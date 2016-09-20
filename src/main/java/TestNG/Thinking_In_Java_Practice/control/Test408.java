package TestNG.Thinking_In_Java_Practice.control;

/**
 * Created by DreamYao on 2016/5/19.
 */
import java.util.Random;

public class Test408 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        for (int i = 0; i < 100; i++) {
            int a =(new Random()).nextInt(100);
            switch (a) {
                case 50:
                    System.out.println(a);
                case 60:
                    System.out.println(a);
                case 90:
                    System.out.println(a);
                default:
                    break;
            }
        }
    }
}

