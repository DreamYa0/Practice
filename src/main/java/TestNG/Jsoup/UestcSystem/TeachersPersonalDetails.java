package TestNG.Jsoup.UestcSystem;

import TestNG.Jsoup.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.dataset.db.JSONUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by DreamYao on 2016/6/17.
 */
public class TeachersPersonalDetails {
    CloseableHttpClient client= HttpClients.createDefault();
    //教师个人详情-人事信息-基本信息
    @Test(priority = 1)
    public void basicInfo() {
        String result = HttpClient.sendInfo(client, UrlAndData.url1, UrlAndData.data1);
        System.out.println(result);
        Map mapresult=JSONUtils.toHashMap(result);
        Map value= (Map) mapresult.get("data");
        System.out.println(value);
        String value1= (String) value.get("sn");
        System.out.println(value1);
        Assert.assertEquals(value1,"20084512");
    }
    @Test(dataProvider = "bsI",priority = 2)
    public void basicInfo(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] bsI() {
        return new Object[][]{
                new Object[]{"http://192.168.2.49:8080/teacherDetails/HRInfo/basicInfo", "{\"id\":\"1\"}"},
                new Object[]{"http://192.168.2.49:8080/teacherDetails/HRInfo/basicInfo", "{\"id\":\"qqq\"}"},
        };
    }
    //教师个人详情-人事信息-岗位聘任
    @Test(priority = 3)
    public void station(){
        String result=HttpClient.sendInfo(client,UrlAndData.url2,UrlAndData.data2);
        System.out.println(result);
        Map mapresult=JSONUtils.toHashMap(result);
        System.out.println(mapresult);
        List value= (List) mapresult.get("data");
        Map value1= (Map) value.get(0);
        String value2= (String) value1.get("level");
        Assert.assertEquals(value2,"高级");
    }
    @Test(dataProvider = "stn",priority = 4)
    public void station(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] stn() {
        return new Object[][]{
                new Object[]{"http://192.168.2.49:8080/teacherDetails/HRInfo/station", "{\"id\":\"1\"}"},
                new Object[]{"http://192.168.2.49:8080/teacherDetails/HRInfo/station", "{\"id\":\"aa\"}"},
        };
    }
    //教师个人详情-人事信息-学习经历
    @Test(priority = 5)
    public void learn(){
        String result=HttpClient.sendInfo(client,UrlAndData.url3,UrlAndData.data3);
        Map mapresult=JSONUtils.toHashMap(result);
        System.out.println(mapresult);
        List value= (List) mapresult.get("data");
        Map value1= (Map) value.get(0);
        Map value2= (Map) value1.get("teacher");
        String value3= (String) value2.get("name");
        Assert.assertEquals(value3,"旺旺");
    }
    @Test(dataProvider = "lea",priority = 6)
    public void learn(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] lea() {
        return new Object[][]{
                new Object[]{"http://192.168.2.49:8080/teacherDetails/HRInfo/learn", "{\"id\":\"1\"}"},
                new Object[]{"http://192.168.2.49:8080/teacherDetails/HRInfo/learn", "{\"id\":\"qq\"}"},
        };
    }
    //教师个人详情-人事信息-海外学习
    @Test(priority = 7)
    public void abroad(){
        String result=HttpClient.sendInfo(client,UrlAndData.url4,UrlAndData.data4);
        System.out.println(result);
        Map mapresult=JSONUtils.toHashMap(result);
        System.out.println(mapresult);
        List value= (List) mapresult.get("data");
        Map value1= (Map) value.get(0);
        Map value2= (Map) value1.get("teacher");
        String value3= (String) value2.get("name");
        Assert.assertEquals(value3,"小明");
    }
    @Test(dataProvider = "abod",priority = 8)
    public void abroad(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] abod() {
        return new Object[][]{
                new Object[]{"http://192.168.2.49:8080/teacherDetails/HRInfo/abroad", "{\"id\":\"1\"}"},
                new Object[]{"http://192.168.2.49:8080/teacherDetails/HRInfo/abroad", "{\"id\":\"ff\"}"},
        };
    }
    //教师个人详情-人事信息-入校前工作经历
    @Test(priority = 9)
    public void workExprirence(){
        String result=HttpClient.sendInfo(client,UrlAndData.url5,UrlAndData.data5);
        Map mapresult=JSONUtils.toHashMap(result);
        System.out.println(mapresult);
        List value= (List) mapresult.get("data");
        Map value1= (Map) value.get(0);
        String value2= (String) value1.get("job");
        Assert.assertEquals(value2,"经理");
    }
    @Test(dataProvider = "wEpc",priority = 10)
    public void workExprirence(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] wEpc() {
        return new Object[][]{
                new Object[]{"http://192.168.2.49:8080/teacherDetails/HRInfo/workExperience", "{\"id\":\"1\"}"},
                new Object[]{"http://192.168.2.49:8080/teacherDetails/HRInfo/workExperience", "{\"id\":\"ewr\"}"},
        };
    }
    //教师个人详情-科研项目-项目列表(未完成)
    @Test(dataProvider = "li",priority = 12)
    public void list(String Url,String Data){
        String result=HttpClient.sendInfo(client,Url,Data) ;
        Map mapresult=JSONUtils.toHashMap(result);
        System.out.println(mapresult);
        List value= (List) mapresult.get("data");
        Map value1= (Map) value.get(0);
        String value2= (String) value1.get("projectLevel");
        Assert.assertEquals(value2,"0");
    }
    @DataProvider
    public Object[][] li() {
        return new Object[][]{
                new Object[]{"http://192.168.2.49:8080/teacherDetails/projects/list", "{\"id\":\"2\",\"start\":\"2015\",\"end\":\"2016\"}"},
        };
    }
    @Test(dataProvider = "lis",priority = 13)
    public void list1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] lis() {
        return new Object[][]{
                new Object[]{"http://192.168.2.49:8080/teacherDetails/projects/list", "{\"id\":\"1\",\"start\":\"\",\"end\":\"\"}"},
                new Object[]{"http://192.168.2.49:8080/teacherDetails/projects/list", "{\"id\":\"ewr\",\"start\":\"\",\"end\":\"\"}"},
        };
    }
    //教师个人详情-科研项目-项目详情(未完成)
    @Test(priority = 14)
    public void detail(){
        String result=HttpClient.sendInfo(client,ProjectsUrlAndData.url3,ProjectsUrlAndData.data3);
        Map mapresult=JSONUtils.toHashMap(result);
        System.out.println(mapresult);
        List value= (List) mapresult.get("data");
        Map value1= (Map) value.get(0);
        String value2= (String) value1.get("name");
        Assert.assertEquals(value2,"project1");
    }
    @Test(dataProvider = "deta",priority = 15)
    public void detail(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] deta() {
        return new Object[][]{
                new Object[]{"http://192.168.2.49:8080/teacherDetails/projects/detail", "{\"id\":\"1\"}"},
                new Object[]{"http://192.168.2.49:8080/teacherDetails/projects/detail", "{\"id\":\"ewr\"}"},
                new Object[]{"http://192.168.2.49:8080/teacherDetails/projects/detail", "{\"id\":10}"},
        };
    }

    //教师个人详情-科研成果-论文列表
    @Test(dataProvider = "RetPL",priority = 16)
    public void ResultPaperList(String Url, String Data){
        String result=HttpClient.sendInfo(client, Url, Data);
        Map mapresult=JSONUtils.toHashMap(result);
        System.out.println(mapresult);
        List value= (List) mapresult.get("data");
        Map value1= (Map) value.get(0);
        String value2= (String) value1.get("type");
        Assert.assertEquals(value2,"");
    }
    @DataProvider
    public Object[][] RetPL() {
        return new Object[][]{
                new Object[]{"http://192.168.2.49:8080/teacherDetails/result/paperList", "{\"id\":1,\"start\":\"2015\",\"end\":\"2016\"}"},
        };
    }
    @Test(dataProvider = "RetPL1",priority = 17)
    public void ResultPaperList1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] RetPL1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.49:8080/teacherDetails/result/paperList", "{\"id\":\"1\",\"start\":\"\",\"end\":\"\"}"},
                new Object[]{"http://192.168.2.49:8080/teacherDetails/result/paperList", "{\"id\":\"ewr\",\"start\":\"\",\"end\":\"\"}"},
        };
    }

    //教师个人详情-人才培养-人才培养列表(未完成)
    @Test(priority = 18)
    public void TalentTalentsList(){
        String result=HttpClient.sendInfo(client,TalentUrlAndData.url2,TalentUrlAndData.data2);
        Map mapresult=JSONUtils.toHashMap(result);
        String value= (String) mapresult.get("");
        Assert.assertSame(value,"");
        Assert.assertTrue(result.contains("true"));
    }
    @Test(dataProvider = "RePaL",priority = 19)
    public void TalentTalentsList(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] RePaL() {
        return new Object[][]{
                new Object[]{"http://192.168.2.49:8080/teacherDetails/talent/talentsList", "{\"id\":\"1\",\"start\":\"\",\"end\":\"\"}"},
                new Object[]{"http://192.168.2.49:8080/teacherDetails/talent/talentsList", "{\"id\":\"ewr\",\"start\":\"\",\"end\":\"\"}"},
                new Object[]{"http://192.168.2.49:8080/teacherDetails/talent/talentsList", "{\"id\":10,\"start\":\"\",\"end\":\"\"}"},
        };
    }
    //信息聚合-人事信息-基本信息
}
