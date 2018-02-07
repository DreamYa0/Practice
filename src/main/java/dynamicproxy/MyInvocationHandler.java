package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author dreamyao
 * @date 2017/4/10
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 目标对象的引用，这里设计成Object类型，更具通用性
     */
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用目标对象的方法
        return method.invoke(target, args);
    }
}
