package Junit_book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.annotations.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by DreamYao on 2016/6/25.
 */
@RunWith(value = Parameterized.class)
public class ParameteriedTest {
    private double expected;
    private double valueOne;
    private double valueTwo;
    @Parameters
    public static Collection<Integer[]>getTestParameters(){
        return Arrays.asList(new Integer[][]{{2,1,1},{3,2,1},{4,3,1}});
    }
    public ParameteriedTest(double expected,double valueOne,double valueTwo){
        this.expected=expected;
        this.valueOne=valueOne;
        this.valueTwo=valueTwo;
    }
    @Test
    public void sum(){
    }
}
