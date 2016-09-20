package TestNG.httpclient;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by DreamYao on 2016/5/17.
 */
 class TestBase {

    @DataProvider
    public Object[][] dp() {
        return this.getTestData();
    }

    private Object[][] getTestData() {
        PropertiesData testData = new PropertiesData();
        List<Map<String, String>> listData = testData.getTestMethodData();
        Object[][] object = new Object[listData.size()][];
        for (int i = 0; i < listData.size(); i++) {
            object[i] = new Object[]{listData.get(i)};
        }
        return object;
    }

}
class PropertiesData {

    public List<Map<String, String>> getTestMethodData(){
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list.add(PropertiesHandler.getPropertyData("file/data.properties"));
        return list;
    }

}
public class TestDemo extends TestBase{
    @Test(dataProvider="dp")
    public void testDemo(Map<String, String> param){
        System.out.println(param.get("username"));
        System.out.println(param.get("password"));
    }

}