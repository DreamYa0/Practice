package TestNG.Thinking_in_Java.generics;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-9-28.
 *         P353
 */
public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}

class Automobile {
}
