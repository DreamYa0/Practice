package TestNG.Thinking_In_Java_Practice.operators;

/**
 * Created by DreamYao on 2016/5/19.
 */
import java.util.Random;

public class Test307 {
    public static void main(String[] args) {
        Random random=new Random();
        boolean A=random.nextBoolean();
//		if (A==true) {
//			System.out.println("正面");
//		}else {
//			System.out.println("反面");
//		}
        System.out.println(A==true?"正面":"反面");
    }


}
