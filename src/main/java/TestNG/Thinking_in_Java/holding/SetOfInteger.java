package TestNG.Thinking_in_Java.holding;

        import java.util.HashSet;
        import java.util.Random;
        import java.util.Set;

/**
 * Created by DreamYao on 2016/7/4.
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> intset = new HashSet<Integer>();
        for (int i = 0; i < 10000; i++) {
            intset.add(rand.nextInt(30));
        }
        System.out.println(intset);
    }
}
