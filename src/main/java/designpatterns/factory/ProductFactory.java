package designpatterns.factory;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/29 下午9:15
 */
public class ProductFactory {

    private static final Map<String, Product> prMap = Maps.newHashMap();

    public static Product createProduct(String type) throws Exception {
        Lock lock = new ReentrantLock();
        lock.lock();
        Product product = null;
        if (prMap.containsKey(type)) {
            product = prMap.get(type);
        } else {
            if (type.equals("Product1")) {
                product = new ConcreteProduct1();
            } else {
                product = new ConcreteProduct2();
            }
            prMap.put(type, product);
        }
        return product;
    }
}
