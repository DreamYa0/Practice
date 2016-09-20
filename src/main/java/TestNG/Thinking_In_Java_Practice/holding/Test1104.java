package TestNG.Thinking_In_Java_Practice.holding;

import java.util.*;

/**
 * Created by DreamYao on 2016/7/8.
 */
class MovieNameGenerator implements Generator<String> {String[] characters = {
        "Grumpy", "Happy", "Sleepy", "Dopey", "Doc", "Sneezy",
        "Bashful", "Snow White", "Witch Queen", "Prince"
};
    int next;
    public String next() {
        String r = characters[next];
        next = (next + 1) % characters.length;
        return r;
    }
}
public class Test1104 {
    private static final MovieNameGenerator mng =
            new MovieNameGenerator();
    static String[] fill(String[] array) {
        for(int i = 0; i < array.length; i++)
            array[i] = mng.next();
        return array;
    }
    static Collection<String>
    fill(Collection<String> collection) {
        for(int i = 0; i < 5; i++)
            collection.add(mng.next());
        return collection;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fill(new String[5])));
        System.out.println(fill(new ArrayList<String>()));
        System.out.println(fill(new LinkedList<String>()));
        System.out.println(fill(new HashSet<String>()));
        System.out.println(fill(new LinkedHashSet<String>()));
        System.out.println(fill(new TreeSet<String>()));
    }
}
