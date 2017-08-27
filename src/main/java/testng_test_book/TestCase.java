package testng_test_book;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Created by dreamyao on 2017/5/6.
 */
public class TestCase implements IInvokedMethodListener{
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("beforeInvocation");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("afterInvocation");
    }
}
