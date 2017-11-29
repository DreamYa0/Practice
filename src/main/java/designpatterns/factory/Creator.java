package designpatterns.factory;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/29 下午8:49
 */
public abstract class Creator {

    public abstract <T extends Product> T createProduct(Class<T> clazz);
}
