package TestNG.testng_test_book;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/6/8.
 *         37接受ITestContext参数的数据提供者
 */
public class TestData {
    @DataProvider
    public Object[][] randomIntegers(ITestContext context) {
        String[] groups = context.getIncludedGroups();
        int size = 2;
        for (String group : groups) {
            if (group.equals("functional-test")) {
                size = 10;
                break;
            }
        }
        Object[][] result = new Object[size][];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = new Object[]{new Integer(r.nextInt())};
        }
        return result;
    }

    @Test(dataProvider = "randomIntegers", groups = {"unit-test", "functional-test"})
    public void random(Integer n) {
        System.out.println(n);
    }
}
