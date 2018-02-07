package rpc;

/**
 * @author dreamyao
 * @title
 * @date 2018/2/7 下午1:40
 * @since 1.0.0
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
