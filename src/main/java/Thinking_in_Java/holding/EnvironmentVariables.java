package Thinking_in_Java.holding;

import java.util.Map;

/**
 * Created by DreamYao on 2016/7/14.
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
