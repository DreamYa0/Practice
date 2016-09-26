package spring.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by dreamyao on 16-9-26.
 */
public class PatternResolverTest {
    public static void main(String[] args) throws Throwable{
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:/*");
        for (Resource resource : resources) {
            System.out.println(resource.getDescription());
        }
    }
}
