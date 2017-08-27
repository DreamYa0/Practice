package comsumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dreamyao on 2017/5/8.
 */
public abstract class AbstractResourceUtils {

    private static final String DUBBO_RESOURCES = "applicationContext-consumer.xml";

    private static ApplicationContext getApplicationContext(){
        ApplicationContext context = new ClassPathXmlApplicationContext(DUBBO_RESOURCES);
        return context;
    }

    /**
     * 通过class获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 根据名称获取bean
     * @param className
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String className) {
        return (T) getApplicationContext().getBean(className);
    }
}
