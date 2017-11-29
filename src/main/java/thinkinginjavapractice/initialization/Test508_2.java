package thinkinginjavapractice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test508_2 {
    int i=0;

    Test508_2 name() {
        i++;
        return this;
    }

    public void name1() {
        System.out.println("i:" + i);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test508_2 test508_2 = new Test508_2();
        test508_2.name().name1();
    }
}
