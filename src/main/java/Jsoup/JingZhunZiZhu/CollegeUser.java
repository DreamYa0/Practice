package Jsoup.JingZhunZiZhu;

import Jsoup.HttpClient;
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
public class CollegeUser extends PublicFuntion {

    CloseableHttpClient client = HttpClients.createDefault();
    Logger logger;

    public CollegeUser() {
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

    //42 学院用户-提交进行学院公示
    @Test(dataProvider = "cTCN")
    public void commitToCollegeNotice(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] cTCN() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/commitToCollegeNotice", ""},
        };
    }

    @Test(dataProvider = "cTCN1")
    public void commitToCollegeNotice1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] cTCN1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/commitToCollegeNotice", ""},
                new Object[]{"http://localhost:8080/college/commitToCollegeNotice", ""},
                new Object[]{"http://localhost:8080/college/commitToCollegeNotice", ""},
        };
    }

    //43 学院用户-学院用户修改学生贫困等级
    @Test(dataProvider = "mfPL")
    public void modifyPoorLevel(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] mfPL() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/modifyPoorLevel", "{\"studentId\":\"2013070901002\",\"povertyLevel\":\"3\"}"},
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
                new Object[]{"http://localhost:8080/college/modifyPoorLevel", "{\"studentId\":\"20130709010023343\",\"povertyLevel\":\"3\"}"},
                new Object[]{"http://localhost:8080/college/modifyPoorLevel", "{\"studentId\":\"2013070901002\",\"povertyLevel\":\"20\"}"},
                new Object[]{"http://localhost:8080/college/modifyPoorLevel", "{\"studentId\":\"2013070901002\",\"povertyLevel\":\"a\"}"},
                new Object[]{"http://localhost:8080/college/modifyPoorLevel", "{\"studentId\":2013070901002,\"povertyLevel\":\"3\"}"},
        };
    }

    //44 学院用户-获取辅导员列表
    @Test(dataProvider = "gAL")
    public void getAdvisorList(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] gAL() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/getAdvisorList", "{\"collegeId\":13}"},//这个id应该匹配登录用户所属学院
        };
    }

    @Test(dataProvider = "gAL1")
    public void getAdvisorList1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] gAL1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/getAdvisorList", "{\"collegeId\":0}"},
                new Object[]{"http://localhost:8080/college/getAdvisorList", "{\"collegeId\":30}"},
                new Object[]{"http://localhost:8080/college/getAdvisorList", "{\"collegeId\":\"asc\"}"},
        };
    }

    //45 学院用户-驳回至辅导员
    @Test(dataProvider = "rTA")
    public void rejectToAdvisor(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] rTA() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/rejectToAdvisor", "{\"advisorId\":60,\"Content\":\"不合适\"}"},
        };
    }

    @Test(dataProvider = "rTA1")
    public void rejectToAdvisor1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] rTA1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/rejectToAdvisor", "{\"advisorId\":,\"Content\":\"\"}"},
                new Object[]{"http://localhost:8080/college/rejectToAdvisor", "{\"advisorId\":,\"Content\":\"\"}"},
                new Object[]{"http://localhost:8080/college/rejectToAdvisor", "{\"advisorId\":,\"Content\":\"\"}"},
                new Object[]{"http://localhost:8080/college/rejectToAdvisor", "{\"advisorId\":,\"Content\":\"\"}"},
        };
    }

    //46 学院用户-提交到学院审核
    @Test(dataProvider = "cTSlC")
    public void commitToSchoolChec(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] cTSlC() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/commitToSchoolChec", ""},
        };
    }

    @Test(dataProvider = "cTSlC1")
    public void commitToSchoolChec1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] cTSlC1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/commitToSchoolChec", ""},
                new Object[]{"http://localhost:8080/college/commitToSchoolChec", ""},
                new Object[]{"http://localhost:8080/college/commitToSchoolChec", ""},
                new Object[]{"http://localhost:8080/college/commitToSchoolChec", ""},
        };
    }

    //47 学院用户-获取意见反馈表
    @Test(dataProvider = "cTSC")
    public void commitToSchoolCheck(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] cTSC() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/commitToSchoolCheck", "{\"status\":0}"},
                new Object[]{"http://localhost:8080/college/commitToSchoolCheck", "{\"status\":1}"},
                new Object[]{"http://localhost:8080/college/commitToSchoolCheck", "{\"status\":2}"},
        };
    }

    @Test(dataProvider = "cTSC1")
    public void commitToSchoolCheck1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] cTSC1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/commitToSchoolCheck", "{\"status\":3}"},
                new Object[]{"http://localhost:8080/college/commitToSchoolCheck", "{\"status\":\"a\"}"},
        };
    }

    //48 学院用户-处理反馈意见
    @Test(dataProvider = "dFb")
    public void dealFeedback(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] dFb() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/dealFeedback", "{\"studentId\":201503030309,\"Status\":0}"},
                new Object[]{"http://localhost:8080/college/dealFeedback", "{\"studentId\":201503030309,\"Status\":1}"},
        };
    }

    @Test(dataProvider = "dFb1")
    public void dealFeedback1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] dFb1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/college/dealFeedback", "{\"studentId\":201503030309,\"Status\":3}"},
                new Object[]{"http://localhost:8080/college/dealFeedback", "{\"studentId\":\"201503030309\",\"Status\":1}"},
                new Object[]{"http://localhost:8080/college/dealFeedback", "{\"studentId\":\"201503030309111\",\"Status\":1}"},
        };
    }
}