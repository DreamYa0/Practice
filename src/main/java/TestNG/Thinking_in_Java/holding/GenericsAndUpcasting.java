package TestNG.Thinking_in_Java.holding;

import java.util.ArrayList;

/**
 * Created by DreamYao on 2016/6/21.
 * P218向上转型同样也适用于泛型
 */
public class GenericsAndUpcasting {
    public static void main(String[] args){
        ArrayList<Apple> apples=new ArrayList<Apple>();//泛型
        apples.add(new  GrannySmith());//向上转型
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for (Apple c:apples){
            System.out.println(c);
        }
    }
}
class GrannySmith extends Apple{}
class Gala extends Apple{}
class Fuji extends Apple{}
class Braeburn extends Apple{}
