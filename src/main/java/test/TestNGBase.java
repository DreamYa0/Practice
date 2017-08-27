package test;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;

import java.util.*;

/**
 * Created by dreamyao on 2017/5/24.
 */
public abstract class TestNGBase implements IHookable,ITestBase {


    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        Map<String, Object> param = (Map<String, Object>) testResult.getParameters()[0];
        beforeTest(param);//回调
        callBack.runTestMethod(testResult);
    }


    @DataProvider
    public Iterator<Object[]> dataProvider(){
        Map<String, Object> param = new HashMap<>();
        Set<Object[]> set = new HashSet<>();
        set.add(new Object[]{param});
        return set.iterator();
    }
}
