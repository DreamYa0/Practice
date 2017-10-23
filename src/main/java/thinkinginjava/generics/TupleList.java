package thinkinginjava.generics;

        import thinkinginjava.net.mindview.util.FourTuple;

        import java.util.ArrayList;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/18.
 *         P371 构造复杂模型
 */
public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> t1 = new TupleList<>();
        t1.add(TupleTest.h());
        t1.add(TupleTest.h());
        for (FourTuple<Vehicle, Amphibian, String, Integer> i : t1) {
            System.out.println(i);
        }
    }
}
