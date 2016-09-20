package TestNG.POI;

import java.util.Properties;
import java.util.Iterator;

/**
 * Created by DreamYao on 2016/6/7.使用Java的系统属性
 */
public class SysProp {
    public static final String USER_HOME=System.getProperty("user.home");
    public static void main(String[] args) {
        Properties props = System.getProperties();
        Iterator iter = props.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            System.out.println(key + " = " + props.get(key));
            System.out.println(USER_HOME);
        }
    }
}
