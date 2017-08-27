package testng_test_book;

import org.testng.IHookCallBack;
import org.testng.ITestResult;

/**
 * Created by dreamyao on 2017/5/5.
 */
public abstract class CommonTest<T> extends BaseTest {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        System.out.println("HelloWord");
        //callBack.runTestMethod(testResult);
        Object result=testResult.getParameters()[0];
        System.out.println(result);
    }
}
