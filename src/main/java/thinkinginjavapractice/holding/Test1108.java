package thinkinginjavapractice.holding;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by DreamYao on 2016/7/8.
 */
public class Test1108 {
    public static void main(String args[]) {
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        for (int i = 0; i < 10; i++)
            gerbils.add(new Gerbil(i));
        for (Iterator<Gerbil> it = gerbils.iterator();
             it.hasNext();
             it.next().hop())
            ;
    }
}
