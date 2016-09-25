package spring.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-9-25.
 *         P52
 */
public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("spring.reflect.PrivateCar");
        PrivateCar pcar = (PrivateCar) clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");
        colorFld.setAccessible(true);
        colorFld.set(pcar, "红色");
        Method driveMtd = clazz.getDeclaredMethod("drive", (Class[]) null);
        driveMtd.setAccessible(true);
        driveMtd.invoke(pcar, (Object[]) null);
    }
}
