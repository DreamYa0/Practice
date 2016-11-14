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
public class AdvisorUser extends PublicFuntion {

    private final CloseableHttpClient client = HttpClients.createDefault();
    Logger logger;

    public AdvisorUser() {
        PropertyConfigurator.configure("D:\\IdeaWorkspase\\src\\main\\resources\\log4j.properties ");
        logger = Logger.getLogger(AdvisorUser.class.getName());
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

    //33 辅导员用户-上传评议结果


    //34 辅导员用户-提交至辅导员
    @Test(dataProvider = "sD")
    public void sureDiscussion(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] sD() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/sureDiscussion", ""},
        };
    }

    @Test(dataProvider = "sD1")
    public void sureDiscussion1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] sD1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/sureDiscussion", ""},
                new Object[]{"http://localhost:8080/advisor/sureDiscussion", ""},
                new Object[]{"http://localhost:8080/advisor/sureDiscussion", ""},
        };
    }

    //35 辅导员用户-提交至学院
    @Test(dataProvider = "cAA")
    public void commitAdvisorAffirm(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] cAA() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/commitAdvisorAffirm", ""},
        };
    }

    @Test(dataProvider = "cAA1")
    public void commitAdvisorAffirm1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] cAA1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/commitAdvisorAffirm", ""},
                new Object[]{"http://localhost:8080/advisor/commitAdvisorAffirm", ""},
                new Object[]{"http://localhost:8080/advisor/commitAdvisorAffirm", ""},
        };
    }

    //36辅导员用户-辅导员修改学生贫困等级
    @Test(dataProvider = "mPL")
    public void modifyPoorLevel(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] mPL() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/modifyPoorLevel", "{\"studentId\":\"2014070901002\",\"povertyLevel\":\"6\"}"},
        };
    }

    @Test(dataProvider = "mPL1")
    public void modifyPoorLevel1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] mPL1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/modifyPoorLevel", "{\"studentId\":\"2014070901002\",\"povertyLevel\":\"3\"}"},
                new Object[]{"http://localhost:8080/advisor/modifyPoorLevel", "{\"studentId\":\"201407090100211\",\"povertyLevel\":\"6\"}"},
                new Object[]{"http://localhost:8080/advisor/modifyPoorLevel", "{\"studentId\":\"aaaaaaaaaaa\",\"povertyLevel\":\"6\"}"},
        };
    }

    //37 辅导员用户-获取动态管理删除学生
    @Test(dataProvider = "gDSL")
    public void deleteStudent(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] gDSL() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/deleteStudent", "{\"studentId\":\"2014070901001\"}"},
        };
    }

    @Test(dataProvider = "gDSL1")
    public void deleteStudent1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] gDSL1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/deleteStudent", "{\"studentId\":\"2014070901001133\"}"},
                new Object[]{"http://localhost:8080/advisor/deleteStudent", "{\"studentId\":\"aaaaaaaaaaaaaa\"}"},
                new Object[]{"http://localhost:8080/advisor/deleteStudent", "{\"studentId\":2014070901001}"},
        };
    }

    //38 辅导员用户-获取学生资料审核列表
    @Test(dataProvider = "gCML")
    public void getCheckMaterialList(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] gCML() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/getCheckMaterialList", ""},
        };
    }

    @Test(dataProvider = "gCML1")
    public void getCheckMaterialList1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] gCML1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/getCheckMaterialList", ""},
                new Object[]{"http://localhost:8080/advisor/getCheckMaterialList", ""},
                new Object[]{"http://localhost:8080/advisor/getCheckMaterialList", ""},
        };
    }

    //39 辅导员用户-审核学生信息
    @Test(dataProvider = "cSI")
    public void checkStudentInfo(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] cSI() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/checkStudentInfo", "{\"studentId\":\"2014110901001\",\"Status\":1}"},
                new Object[]{"http://localhost:8080/advisor/checkStudentInfo", "{\"studentId\":\"2014110901001\",\"Status\":0}"},
        };
    }

    @Test(dataProvider = "cSI1")
    public void checkStudentInfo1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] cSI1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/checkStudentInfo", "{\"studentId\":\"2014110901001\",\"Status\":3}"},
                new Object[]{"http://localhost:8080/advisor/checkStudentInfo", "{\"studentId\":\"2014110901001\",\"Status\":\"1\"}"},
                new Object[]{"http://localhost:8080/advisor/checkStudentInfo", "{\"studentId\":\"2014110901001111\",\"Status\":1}"},
                new Object[]{"http://localhost:8080/advisor/checkStudentInfo", "{\"studentId\":\"aaaaaaaaaa\",\"Status\":1}"},
        };
    }

    //40 辅导员用户-获取民族评议信息
    @Test(dataProvider = "gDsI")
    public void getDiscussionInfo(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] gDsI() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/getDiscussionInfo", ""},
        };
    }

    @Test(dataProvider = "gDsI1")
    public void getDiscussionInfo1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] gDsI1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/getDiscussionInfo", ""},
                new Object[]{"http://localhost:8080/advisor/getDiscussionInfo", ""},
                new Object[]{"http://localhost:8080/advisor/getDiscussionInfo", ""},
        };
    }

    //41 辅导员用户-设置民族评议信息
    @Test(dataProvider = "sDsI")
    public void setDiscussionInfo(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] sDsI() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/checkStudentInfo", "{\"Status\":1}"},//1开启，0关闭
        };
    }

    @Test(dataProvider = "sDsI1")
    public void setDiscussionInfo1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] csDsI1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/advisor/checkStudentInfo", "{\"Status\":2}"},
                new Object[]{"http://localhost:8080/advisor/checkStudentInfo", "{\"Status\":3}"},
                new Object[]{"http://localhost:8080/advisor/checkStudentInfo", "{\"Status\":\"1\"}"},
                new Object[]{"http://localhost:8080/advisor/checkStudentInfo", "{\"Status\":\"a\"}"},
        };
    }
}
