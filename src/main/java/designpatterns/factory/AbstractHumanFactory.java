package designpatterns.factory;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/29 下午8:36
 */
public abstract class AbstractHumanFactory {

    public abstract <T extends Human> T createHuman(Class<T> clazz);
}
