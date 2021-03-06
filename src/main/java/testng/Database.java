package testng;

import org.testng.annotations.Test;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/6/8.
 *         Method参数
 */
public class Database extends CommonTest<Database>{

    @Test(dataProvider = "provideNumbers", dataProviderClass = DatabaseData.class)
    public void two(int param) {
        System.out.println("Two received: " + param);
    }

    @Test(dataProvider = "provideNumbers", dataProviderClass = DatabaseData.class)
    public void three(int param) {
        System.out.println("Three received: " + param);
    }
}
