package effectivejava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreamyao on 2017/3/21.
 */
public class ListTest {
    public static void main(String[] args) {

        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

        // 普通方式循环List
        for(String item : items){
            System.out.println(item);
        }

        //lambda
        // Output : A,B,C,D,E
        items.forEach(item->System.out.println(item));

        //Output : C
        items.forEach(item->{
            if("C".equals(item)){
                System.out.println(item);
            }
        });

        //method reference
        // Output : A,B,C,D,E
        items.forEach(System.out::println);

        //Steam and filter
        // Output : B
        items.stream()
                .filter(s->s.contains("B"))
                .forEach(System.out::println);
    }
}
