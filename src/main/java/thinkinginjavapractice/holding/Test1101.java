package thinkinginjavapractice.holding;

import java.util.ArrayList;

/**
 * Created by DreamYao on 2016/6/21.
 * P218
 */
class Gerbil {
    private final int gerbilNumber;

    Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public String toString() {
        return "gerbil " + gerbilNumber;
    }

    public void hop() {
        System.out.println(this + " is hopping");
    }
}

public class Test1101 {
    public static void main(String args[]) {
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        for (int i = 0; i < 10; i++)
            gerbils.add(new Gerbil(i));
//        for (int i = 0; i < gerbils.size(); i++)
//            gerbils.get(i).hop();
        for (Gerbil g:gerbils){
            g.hop();
        }
    }
}
