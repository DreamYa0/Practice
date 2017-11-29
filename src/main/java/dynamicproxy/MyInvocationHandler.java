package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dreamyao on 2017/4/10.
 */
public class MyInvocationHandler implements InvocationHandler {//注意实现这个Handler接口

    private Object target; //目标对象的引用，这里设计成Object类型，更具通用性

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args); //调用目标对象的方法
    }
}
