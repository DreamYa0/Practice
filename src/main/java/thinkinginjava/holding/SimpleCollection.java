package thinkinginjava.holding;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by DreamYao on 2016/6/23.
 * P219基本概念
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer>c=new ArrayList<Integer>();
        for (int i=0;i<10;i++){
            c.add(i);
        }
        for (Integer i:c){
            System.out.println(i);
        }
    }
}
