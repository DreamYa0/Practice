package TestNG.Thinking_in_Java.interfaces;

import java.util.Random;

/**
 * Created by DreamYao on 2016/5/21.P184初始化接口中的域
 */
public interface RandVals {
    Random RAND=new Random(47);
    int RANDOM_INT=RAND.nextInt(10);
    long RANDOM_LONG=RAND.nextLong()*10;
    float RANDOM_FLOAT=RAND.nextFloat()*10;
    double RANDOM_DOUBLE=RAND.nextDouble()*10;
}
