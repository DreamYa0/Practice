package thinkinginjava.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P136名称屏蔽
public class Hide {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Bart bart = new Bart();
        bart.doh(1);
        bart.doh('x');
        bart.doh(1.0f);
        bart.doh(new Milhouse());
    }
}

class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse {
}

class Bart extends Homer {
    void doh(Milhouse m) {
        System.out.println("doh(Milhouse)");
    }
}
