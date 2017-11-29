package thinkinginjavapractice.object;

/**
 * Created by DreamYao on 2016/5/19.
 */
import java.util.Random;
public class Test02 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Random random=new Random(47);
        int s=random.nextInt(100)+1;
        int t=random.nextInt(100)+1;
        double v=s/t;
        System.out.println(v);
    }

}