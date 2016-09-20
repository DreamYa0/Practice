package TestNG.testng_test_book;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by DreamYao on 2016/6/8.
 */
public class DatabaseData {
    @DataProvider
    public static Object[][] provideNumbers(Method method){
        Object[][] result=null;
//        if (method.getName().equals("two")){
//            result=new Object[][]{new Object[]{2}};
//        }
//        else if (method.getName().equals("three")){
//            result=new Object[][]{new Object[]{3}};
//        }
        //使用switch效率更高
        switch (method.getName()){
            case "two":
                result=new Object[][]{new Object[]{2}};
            case "three":
                result=new Object[][]{new Object[]{3}};
        }
        return result;
    }
}
