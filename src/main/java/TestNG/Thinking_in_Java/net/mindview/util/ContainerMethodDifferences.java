package TestNG.Thinking_in_Java.net.mindview.util;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/17.
 *         P369 使用Sets.difference()打印出java.util包中各种
 *         Collection类与Map类之间的方法差异
 */
public class ContainerMethodDifferences {
    //获取Class的方法的Set集合
    static Set<String> methodSet(Class<?> type) {
        //获得方法名的Set集合
        Set<String> result = new TreeSet<>();
        for (Method m : type.getMethods()) {
            result.add(m.getName());
        }
        return result;
    }

    //获取接口的实现类
    static void interfaces(Class<?> type) {
        System.out.println("Interfaces in " + type.getSimpleName() + ": ");
        List<String> result = new ArrayList<>();
        for (Class<?> c : type.getInterfaces()) {
            result.add(c.getSimpleName());
        }
        System.out.println(result);
    }

    static Set<String> object = methodSet(Object.class);

    static {
        object.add("clone");
    }

    static void difference(Class<?> superset, Class<?> subset) {
        System.out.println(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds: ");
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class, Collection.class);
        difference(HashSet.class, Set.class);
        difference(LinkedHashSet.class, HashSet.class);
        difference(TreeSet.class, Set.class);
        difference(List.class, Collection.class);
        difference(ArrayList.class, List.class);
        difference(LinkedList.class, List.class);
        difference(Queue.class, Collection.class);
        difference(PriorityQueue.class, Queue.class);
        System.out.println("Map: " + methodSet(Map.class));
        difference(HashMap.class, Map.class);
        difference(LinkedHashMap.class, HashMap.class);
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
    }
}
