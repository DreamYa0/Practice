package TestNG.Thinking_In_Java_Practice.holding;

        import java.util.LinkedList;
        import java.util.ListIterator;

/**
 * Created by DreamYao on 2016/7/8.
 */
public class Test1114 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        ListIterator<Integer> it = list.listIterator();
        for (int i = 1; i <= 10; i++) {
            it.add(i);
            if (i % 2 == 0)
                it.previous();
        }
        System.out.println(list);
    }
}
