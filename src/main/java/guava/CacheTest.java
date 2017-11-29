package guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/21 下午8:52
 */
public class CacheTest {

    private static LoadingCache<String, Object> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, Object>() {
        @Override
        public Object load(String key) throws Exception {
            return null;
        }
    });
}
