package designpatterns.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/29 下午8:57
 */
public class SingletonFactory {

    private static Singleton singleton;

    static {
        try {
            Class clazz = Class.forName(Singleton.class.getName());
            Constructor concreteCreator = clazz.getDeclaredConstructor();
            // 实例化私有构造器
            concreteCreator.setAccessible(true);
            singleton = (Singleton) concreteCreator.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public <T> T create(Class<T> clazz) {
        T t = null;
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            t = constructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    public Singleton getSingleton(){
        return singleton;
    }
}
