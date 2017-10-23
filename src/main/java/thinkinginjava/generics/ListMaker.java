package thinkinginjava.generics;

        import java.util.ArrayList;
        import java.util.List;

/**
 * @author DreamYao
 *         Created by DreamYao on 2016/10/24.
 *         P378
 */
public class ListMaker<T> {
    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
        List<String> stringList = stringMaker.create();
    }
}
