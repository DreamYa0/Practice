package thinkinginjavapractice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test508 {
    public static int name(int i) {
        i++;
        return i;
    }

    public static int name1(int b) {
        int a = name(10) + b;
        return a;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(name1(10));
    }
}
