package thinkinginjava.generics.coffee;

/**
 * Created by dreamyao on 16-9-30.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
