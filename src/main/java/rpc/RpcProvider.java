package rpc;

/**
 * @author dreamyao
 * @title
 * @date 2018/2/7 下午1:40
 * @since 1.0.0
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
