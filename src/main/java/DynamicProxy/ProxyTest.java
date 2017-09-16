package DynamicProxy;

/**
 * Created by dreamyao on 2017/4/10.
 */
public class ProxyTest {
    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        MyInvocationHandler invocationHandler = new MyInvocationHandler();
        UserService userServiceProxy = (UserService) invocationHandler.bind(userService);
        System.out.println(userServiceProxy.getName());
        System.out.println(userServiceProxy.getAge());

        CGLIBProxy proxy = new CGLIBProxy();
        UserServiceImpl service = new UserServiceImpl();
        Object obj = proxy.getInstance(service);
        System.out.println();
    }
}
