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
 * Created by DreamYao on 2016/5/27.
 */
public class StudentUser extends PublicFuntion {

    CloseableHttpClient client = HttpClients.createDefault();
    Logger logger;

    public StudentUser() {
        PropertyConfigurator.configure("D:\\IdeaWorkspase\\src\\main\\resources\\log4j.properties");
        logger = Logger.getLogger(StudentUser.class.getName());
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

    //20 学生用户-获得学生基本信息
    @Test(dataProvider = "gsi")
    public void GetStudentInfo(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains(""));
        logger.info(result);
    }

    @DataProvider
    public Object[][] gsi() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/info", ""},
        };
    }

    @Test(dataProvider = "gsi1")
    public void GetStudentInfo1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains(""));
        logger.info(result);
    }

    @DataProvider
    public Object[][] gsi1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/info", ""},
                new Object[]{"http://localhost:8080/student/info", ""},
                new Object[]{"http://localhost:8080/student/info", ""},
                new Object[]{"http://localhost:8080/student/info", ""},
        };
    }

    //21 学生用户-新增学生家庭成员信息
    @Test(dataProvider = "adF")
    public void addFamily(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] adF() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/addFamily", "{\"studentId\":\"2012019070024\",\"name\":\"DreamYao\",\"birthday\":\"19910924\",\"relation\":\"父子\",\"cellphone\":\"17761289412\",\"address\":\"温江\",\"work\":\"IT\",\"income\":\"1\"}"},
        };
    }

    @Test(dataProvider = "adF1")
    public void addFamily1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] adF1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/addFamily", "{\"studentId\":\"2012019070024\",\"name\":1111,\"birthday\":\"19910924\",\"relation\":\"父子\",\"cellphone\":\"17761289412\",\"address\":\"温江\",\"work\":\"IT\",\"income\":\"1\"}"},
                new Object[]{"http://localhost:8080/student/addFamily", "{\"studentId\":\"2012019070024\",\"name\":\"DreamYao\",\"birthday\":19910924,\"relation\":\"父子\",\"cellphone\":17761289412,\"address\":\"温江\",\"work\":\"IT\",\"income\":\"1\"}"},
                new Object[]{"http://localhost:8080/student/addFamily", "{\"studentId\":\"2012019070024111\",\"name\":\"DreamYao\",\"birthday\":\"19910924\",\"relation\":\"父子\",\"cellphone\":\"17761289412\",\"address\":\"温江\",\"work\":\"IT\",\"income\":\"1\"}"},//数据库中不存在的studentId
        };
    }

    //22 学生用户-删除学生家庭成员信息
    @Test(dataProvider = "dlF")
    public void deleteFamily(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dlF() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/deleteFamily", "{\"id\":1}"},
        };
    }

    @Test(dataProvider = "dlF1")
    public void deleteFamily1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dlF1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/deleteFamily", "{\"id\":111}"},
                new Object[]{"http://localhost:8080/student/deleteFamily", "{\"id\":\"aa\"}"},
        };
    }

    //23 学生用户-获取学生家庭成员信息
    @Test(dataProvider = "gtFl")
    public void getFamily(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] gtFl() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/getFamily", "{\"studentId\":\"2012019070024\"}"},
        };
    }

    @Test(dataProvider = "gtFl1")
    public void getFamily1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] gtFl1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/getFamily", "{\"studentId\":2012019070024}"},
                new Object[]{"http://localhost:8080/student/getFamily", "{\"studentId\":201201907002411}"},
                new Object[]{"http://localhost:8080/student/getFamily", "{\"studentId\":\"aaa\"}"},
        };
    }

    //24 学生用户-修改学生基本信息
    @Test(dataProvider = "mfI")
    public void modifyInfo(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains(""));
        logger.info(result);
    }

    @DataProvider
    public Object[][] mfI() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/modifyInfo", "{\"studentId\":\"2014110501001\",\"name\":\"DreamYao\",\"gender\"1:,\"idCard\":\"15656565625262\",\"collegeId\":7,\"gradeId\":8,\"majorId\":913,\"classId\":12}"},
        };
    }

    @Test(dataProvider = "mfI1")
    public void modifyInfo1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains(""));
        logger.info(result);
    }

    @DataProvider
    public Object[][] mfI1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/modifyInfo", "{\"studentId\":\"201411050100111\",\"name\":\"DreamYao\",\"gender\"1:,\"idCard\":\"15656565625262\",\"collegeId\":7,\"gradeId\":8,\"majorId\":913,\"classId\":12}"},//数据库中不存在的studentId
                new Object[]{"http://localhost:8080/student/modifyInfo", "{\"studentId\":\"2014110501001\",\"name\":\"DreamYao\",\"gender\"1:,\"idCard\":\"15656565625262\",\"collegeId\":70,\"gradeId\":8,\"majorId\":913,\"classId\":12}"},
                new Object[]{"http://localhost:8080/student/modifyInfo", "{\"studentId\":\"2014110501001\",\"name\":\"DreamYao\",\"gender\"1:,\"idCard\":\"15656565625262\",\"collegeId\":7,\"gradeId\":80,\"majorId\":913,\"classId\":12}"},
                new Object[]{"http://localhost:8080/student/modifyInfo", "{\"studentId\":\"2014110501001\",\"name\":\"DreamYao\",\"gender\"1:,\"idCard\":15656565625262,\"collegeId\":\"7\",\"gradeId\":8,\"majorId\":913,\"classId\":12}"},
        };
    }

    //25 学生用户-上传材料
//    @Test(dataProvider = "up")
//    public void upload(String Url, String Data) {
//        String result = HttpClient.sendInfo(client, Url, Data);
//        Assert.assertTrue(result.contains(""));
//        logger.info(result);
//    }
//
//    @DataProvider
//    public Object[][] up() {
//        return new Object[][]{
//                new Object[]{"/student/upload", ""},
//        };
//    }

    //26 学生用户-查看修改信息
    @Test(dataProvider = "vMfI")
    public void viewModifyInfo(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] vMfI() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/viewModifyInfo", ""},
        };
    }

    @Test(dataProvider = "vMfI1")
    public void viewModifyInfo1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] vMfI1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/viewModifyInfo", ""},
                new Object[]{"http://localhost:8080/student/viewModifyInfo", ""},
                new Object[]{"http://localhost:8080/student/viewModifyInfo", ""},
        };
    }

    //27 学生用户-提交信息
    @Test(dataProvider = "SM")
    public void commitInfo(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] SM() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/commitInfo", "{\"isPublic\":0}"},
                new Object[]{"http://localhost:8080/student/commitInfo", "{\"isPublic\":1}"},
        };
    }

    @Test(dataProvider = "SM1")
    public void commitInfo1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] SM1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/commitInfo", "{\"isPublic\":3}"},
                new Object[]{"http://localhost:8080/student/commitInfo", "{\"isPublic\":-1}"},
                new Object[]{"http://localhost:8080/student/commitInfo", "{\"isPublic\":\"11\"}"},
                new Object[]{"http://localhost:8080/student/commitInfo", "{\"isPublic\":\"abc\"}"},
        };
    }

    //28 学生用户-获取审核状态
    @Test(dataProvider = "gS")
    public void getStatus3(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] gS() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/getStatus", ""},
        };
    }

    @Test(dataProvider = "gS1")
    public void getStatus4(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] gS1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/getStatus", ""},
                new Object[]{"http://localhost:8080/student/getStatus", ""},
                new Object[]{"http://localhost:8080/student/getStatus", ""},
                new Object[]{"http://localhost:8080/student/getStatus", ""},
        };
    }

    //29 学生用户-获取学院公告
    @Test(dataProvider = "SN")
    public void getCollegeNotice(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] SN() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/getCollegeNotice", "{\"pageIndex\":1,\"pageSize\":10}"},
        };
    }

    @Test(dataProvider = "SN1")
    public void getCollegeNotice1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] SN1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/getCollegeNotice", "{\"pageIndex\":2,\"pageSize\":30}"},
                new Object[]{"http://localhost:8080/student/getCollegeNotice", "{\"pageIndex\":-1,\"pageSize\":10}"},
                new Object[]{"http://localhost:8080/student/getCollegeNotice", "{\"pageIndex\":1,\"pageSize\":-10}"},
                new Object[]{"http://localhost:8080/student/getCollegeNotice", "{\"pageIndex\":\"a\",\"pageSize\":2}"},
                new Object[]{"http://localhost:8080/student/getCollegeNotice", "{\"pageIndex\":1,\"pageSize\":\"aa\"}"},
        };
    }

    //30 学生用户-对学院公告的意见反馈
    @Test(dataProvider = "fCN")
    public void feedbackCollegeNotice(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] fCN() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/feedbackCollegeNotice", "{\"content\":\"\"}"},
        };
    }

    @Test(dataProvider = "fCN1")
    public void feedbackCollegeNotice1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] fCN1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/feedbackCollegeNotice", "{\"content\":\"\"}"},
                new Object[]{"http://localhost:8080/student/feedbackCollegeNotice", "{\"content\":\"\"}"},
                new Object[]{"http://localhost:8080/student/feedbackCollegeNotice", "{\"content\":\"\"}"},
        };
    }

    //31 学生用户-获取学校公告
    @Test(dataProvider = "gSN")
    public void getSchoolNotice(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] gSN() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/getSchoolNotice", "{\"pageIndex\":1,\"pageSize\":10}"},
        };
    }

    @Test(dataProvider = "gSN1")
    public void getSchoolNotice1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] gSN1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/getSchoolNotice", "{\"pageIndex\":2,\"pageSize\":30}"},
                new Object[]{"http://localhost:8080/student/getSchoolNotice", "{\"pageIndex\":-1,\"pageSize\":10}"},
                new Object[]{"http://localhost:8080/student/getSchoolNotice", "{\"pageIndex\":1,\"pageSize\":-10}"},
                new Object[]{"http://localhost:8080/student/getSchoolNotice", "{\"pageIndex\":\"a\",\"pageSize\":2}"},
                new Object[]{"http://localhost:8080/student/getSchoolNotice", "{\"pageIndex\":1,\"pageSize\":\"aa\"}"},
        };
    }

    //32 学生用户-对学校公告的意见反馈
    @Test(dataProvider = "fSN")
    public void feedbackSchoolNotice(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] fSN() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/feedbackSchoolNotice", "{\"content\":\"评定不合理\"}"},
        };
    }

    @Test(dataProvider = "fSN1")
    public void feedbackSchoolNotice1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("true"));
    }

    @DataProvider
    public Object[][] fSN1() {
        return new Object[][]{
                new Object[]{"http://localhost:8080/student/feedbackSchoolNotice", "{\"content\":12345}"},
        };
    }
}