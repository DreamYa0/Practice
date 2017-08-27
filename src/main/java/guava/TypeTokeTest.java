package guava;

import com.google.common.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by dreamyao on 2017/6/10.
 */
public class TypeTokeTest {

    public static void main(String[] args) {
        TypeToken<List<String>> typeToken=new TypeToken<List<String>>() {};
        typeToken.isPrimitive();
        System.out.println(typeToken.getType().getTypeName());
        System.out.println(typeToken.getType() instanceof ParameterizedType);
    }
}
