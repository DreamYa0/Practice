package concurrent;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/4 下午8:26
 * @since 1.0.0
 */
@ThreadSafe
public class DelegatingVehicleTracker {

    private final ConcurrentHashMap<String,Point> locations;
    private final Map<String,Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(points);
    }

    public Map<String,Point> getLocations(){
        return unmodifiableMap;
    }

    /**
     * 此处发布了Point对象，但是Point对象为不可变对象，所以此处发布时线程安全的
     * @param id
     * @return
     */
    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }
}
