package Thinking_in_Java.holding;

import java.util.ArrayList;

/**
 * Created by DreamYao on 2016/6/21.
 * P217泛型与类型安全的容器使用泛型
 */
public class ApplesAndOrangesWithoutGenerice {
    public static void main(String[] args){
        ArrayList<Apple> apples=new ArrayList<Apple>();
        for (int i=0;i<3;i++){
            apples.add(new Apple());
        }
        for (int i=0;i<apples.size();i++){
            System.out.println(apples.get(i).id());
        }
        for (Apple c:apples){
            System.out.println(c.id());
        }
    }
}
class Apple{
    private static long counter;
    private final long id=counter++;
    public long id(){return id;}
}
class Orange{}