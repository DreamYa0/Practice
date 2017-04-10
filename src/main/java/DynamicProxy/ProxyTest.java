package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by dreamyao on 2017/4/10.
 */
public class ProxyTest {
    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), invocationHandler);
        System.out.println(userServiceProxy.getName());
        System.out.println(userServiceProxy.getAge());
    }
}
