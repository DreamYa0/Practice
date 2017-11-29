package poi;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by DreamYao on 2016/6/7.使用操作系统的环境变量
 */
public class EnvProp {
    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv();
        Iterator iter = envMap.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            System.out.println(key + " = " + envMap.get(key));
        }
    }
}
