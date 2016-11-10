package Thinking_in_Java.generics;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-10-6.
 *         P365
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    public String toString() {
        return "CountedObject " + id;
    }
}
