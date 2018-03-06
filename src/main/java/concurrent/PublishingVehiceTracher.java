package concurrent;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/6 下午9:32
 * @since 1.0.0
 */
public class PublishingVehiceTracher {

    private final Map<String,SafePoint> locations;
    private final Map<String,SafePoint> unmodifiableMap;

    public PublishingVehiceTracher(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String,SafePoint> getLocations(){
        return unmodifiableMap;
    }

    /**
     * 此处发布了Point对象，但是Point对象为不可变对象，所以此处发布时线程安全的
     * @param id
     * @return
     */
    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new SafePoint(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }
}
