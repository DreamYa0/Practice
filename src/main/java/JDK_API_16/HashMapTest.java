package JDK_API_16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by DreamYao on 2016/11/19.
 */
public class HashMapTest {
    private static HashMapTest ourInstance = new HashMapTest();

    public static HashMapTest getInstance() {
        return ourInstance;
    }

    private HashMapTest() {
    }

    //效率高,以后一定要使用此种方式！
    public void TraverseHashMap(Map map) {
        map = new HashMap();
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
        }
    }

    //效率低,以后尽量少使用！
    public void TraverseHashMap() {
        Map map = new HashMap();
        Iterator iter = map.keySet().iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            Object val = map.get(key);
        }
    }
}
