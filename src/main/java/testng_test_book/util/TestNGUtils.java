package testng_test_book.util;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by dreamyao on 2017/5/5.
 */
public class TestNGUtils {
    /**
     * 把参数和结果注入到测试函数，先注入默认值，防止执行时参数不匹配
     *
     * @param map
     * @param testMethod
     * @return
     * @throws Exception
     */
    public static Object[] injectResultAndParametersByDefault(Map<String, Object> map, Method testMethod) throws Exception {
        int parameters = testMethod.getGenericParameterTypes().length;
        Object[] objects;
        if (parameters > 1) {
            objects = new Object[parameters];
            objects[0] = map;
            // 第一个参数是Map<String,Object> context，不处理；第二个参数是Object result
            for (int i = 1; i < parameters; i++) {
                objects[i] = null;
//				// 基本类型要重新赋值
//				if (testMethod.getGenericParameterTypes()[i] instanceof Class) {
//					Class paramClass = (Class) testMethod.getGenericParameterTypes()[i];
//					if (paramClass.isPrimitive()) {
//						objects[i] = StringUtil.json2Bean(paramClass.getSimpleName(), "0", null);
//					}
//				}
            }
        } else {
            objects = new Object[]{map};
        }
        return objects;
    }
}
