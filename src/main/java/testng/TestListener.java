package testng;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by DreamYao on 2017/3/14.
 */
public class TestListener implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        ListIterator<IMethodInstance> iterator=methods.listIterator();
        while (iterator.hasNext()) {
            IMethodInstance iMethodInstance=iterator.next();
            Object object=iMethodInstance.getInstance();
        }
        String name=context.getName();
        return null;
    }
}
