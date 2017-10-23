package thinkinginjava.control;

/**
 * Created by DreamYao on 2016/5/19.
 */
import java.util.Random;
//P67าณ
public class ForEachFlodt {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        float f[] = new float[10];
        for (int i = 0; i < 10; i++) {
            f[i] = (new Random(47)).nextFloat();
            for (float x : f) {
                System.out.println(x);
            }
        }
    }
}
