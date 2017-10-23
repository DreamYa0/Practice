package thinkinginjava.generics;

import thinkinginjava.net.mindview.util.FiveTuple;
import thinkinginjava.net.mindview.util.FourTuple;
import thinkinginjava.net.mindview.util.ThreeTuple;
import thinkinginjava.net.mindview.util.TwoTuple;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-9-28.
 *         P356 一个元组类库
 */
public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<>(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}

class Amphibian {
}

class Vehicle {
}
