package TestNG.Jsoup.JingZhunZiZhu;

import TestNG.Jsoup.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by DreamYao on 2016/6/1.
 */
public class SchoolUser extends PublicFuntion {
    CloseableHttpClient client = HttpClients.createDefault();
    Logger logger;

    public SchoolUser() {
        PropertyConfigurator.configure("D:\\IdeaWorkspase\\src\\main\\resources\\log4j.properties ");
        logger = Logger.getLogger(PublicFuntion.class.getName());
    }

    @Test(dataProvider = "dp", priority = 1)
    public void Login(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][]{new Object[]{"http://localhost:8080/user/login", "{\"username\":\"\",\"password\":\"\"}"},};
    }

    //49 学校用户-学校用户修改学生贫困等级
    @Test(dataProvider = "mfPL")
    public void modifyPoorLevel(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] mfPL() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/modifyPoorLevel", "{\"studentId\":2014110501001,\"povertyLevel\":\"1\"}"},
        };
    }

    @Test(dataProvider = "mfPL1")
    public void modifyPoorLevel1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] mfPL1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/modifyPoorLevel", "{\"studentId\":2014110501001,\"povertyLevel\":\"6\"}"},
                new Object[]{"http://localhost:8080/school/modifyPoorLevel", "{\"studentId\":2014110501001,\"povertyLevel\":\"20\"}"},
                new Object[]{"http://localhost:8080/school/modifyPoorLevel", "{\"studentId\":2014110501001666,\"povertyLevel\":\"1\"}"},
                new Object[]{"http://localhost:8080/school/modifyPoorLevel", "{\"studentId\":\"2014110501001\",\"povertyLevel\":\"1\"}"},
                new Object[]{"http://localhost:8080/school/modifyPoorLevel", "{\"studentId\":\"wawwewe\",\"povertyLevel\":\"1\"}"},
        };
    }

    //50 学校用户-驳回至学院
    @Test(dataProvider = "rjTC")
    public void rejectToCollege(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] rjTC() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/rejectToCollege", "{\"collegeId\":11,\"Content\":\"不合格\"}"},
        };
    }

    @Test(dataProvider = "rjTC1")
    public void rejectToCollege1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] rjTC1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/rejectToCollege", "{\"collegeId\":111,\"Content\":\"不合格\"}"},
                new Object[]{"http://localhost:8080/school/rejectToCollege", "{\"collegeId\":11,\"Content\":1234}"},
                new Object[]{"http://localhost:8080/school/rejectToCollege", "{\"collegeId\":1234,\"Content\":1234}"},
        };
    }

    //51 学校用户-获取意见反馈表
    @Test(dataProvider = "gFdb")
    public void getFeedback(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] gFdb() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/getFeedback", "{\"Status\":0}"},
                new Object[]{"http://localhost:8080/school/getFeedback", "{\"Status\":1}"},
                new Object[]{"http://localhost:8080/school/getFeedback", "{\"Status\":2}"},
                new Object[]{"http://localhost:8080/school/getFeedback", "{\"Status\":3}"},
        };
    }

    @Test(dataProvider = "gFdb1")
    public void getFeedback1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] gFdb1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/getFeedback", "{\"Status\":4}"},
                new Object[]{"http://localhost:8080/school/getFeedback", "{\"Status\":\"4\"}"},
                new Object[]{"http://localhost:8080/school/getFeedback", "{\"Status\":\"aaa\"}"},
        };
    }

    //52 学校用户-处理反馈意见
    @Test(dataProvider = "dlFb")
    public void dealFeedback(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] dlFb() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"studentId\":2014110901002,\"Status\":1}"},
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"studentId\":2015110901001,\"Status\":0}"},
        };
    }

    @Test(dataProvider = "dlFb1")
    public void dealFeedback1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] dlFb1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"studentId\":2015110901001,\"Status\":3}"},
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"studentId\":2015110901001098,\"Status\":1}"},
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"studentId\":2015110901001098,\"Status\":5}"},
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"studentId\":\"aaaaaa\",\"Status\":1}"},
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"studentId\":\"aaaaaawww\",\"Status\":5}"},
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"studentId\":\"aaaaaawww\",\"Status\":\"5\"}"},
        };
    }
    //53 学校用户-查看操作记录
    @Test(dataProvider = "vOtR")
    public void viewOperationRecord(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] vOtR() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"Status\":0}"},
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"Status\":1}"},
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"Status\":2}"},
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"Status\":3}"},
        };
    }
    @Test(dataProvider = "vOtR1")
    public void viewOperationRecord1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] vOtR1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"Status\":4}"},
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"Status\":\"qq\"}"},
                new Object[]{"http://localhost:8080/school/dealFeedback", "{\"Status\":\"1\"}"},
        };
    }

    //54 学校用户-发布公告
    @Test(dataProvider = "isN")
    public void issueNotice(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] isN() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/issueNotice", "{\"Title\":\"Content\":\"\"}"},
        };
    }

    @Test(dataProvider = "isN1")
    public void issueNotice1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] isN1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/school/issueNotice", "{\"Title\":\"Content\":\"\"}"},
                new Object[]{"http://localhost:8080/school/issueNotice", "{\"Title\":\"Content\":\"\"}"},
                new Object[]{"http://localhost:8080/school/issueNotice", "{\"Title\":\"Content\":\"\"}"},
        };
    }
}
