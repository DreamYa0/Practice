package httpclient.JingZhunZiZhu;

import httpclient.HttpClient;
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

/**
 * Created by DreamYao on 2016/5/27.
 */
public class PublicFuntion {
    CloseableHttpClient client = HttpClients.createDefault();
    Logger logger;

    //1 公共接口-登录
    public PublicFuntion() {
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
        return new Object[][]{new Object[]{"http://192.168.2.36:8080/common/login", "{\"roleType\":\"100\"}"},};
    }

    //2 公共接口-根据年级ID获取学院列表
    @Test(dataProvider = "gg")
    public void getCollegeByGradeId(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        System.out.println(result);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] gg() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getCollegeByGradeId", "{\"gradeId\":9}"},
                new Object[]{"http://192.168.2.36:8080/common/getCollegeByGradeId", "{\"gradeId\":6}"},
                new Object[]{"http://192.168.2.36:8080/common/getCollegeByGradeId", "{\"gradeId\":8}"},
        };
    }

    @Test(dataProvider = "gg1")
    public void getCollegeByGradeId1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        System.out.println(result);
        Assert.assertTrue(result.contains("false"));
    }

    @DataProvider
    public Object[][] gg1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getCollegeByGradeId", "{\"gradeId\":12344}"},
                new Object[]{"http://192.168.2.36:8080/common/getCollegeByGradeId", "{\"gradeId\":\"abc\"}"},
                new Object[]{"http://192.168.2.36:8080/common/getCollegeByGradeId", "{\"gradeId\":\"123\"}"},
                new Object[]{"http://192.168.2.36:8080/common/getCollegeByGradeId", "{\"gradeId\":\"1a\"}"},
        };
    }

    //3 公共接口-根据学院ID获取专业
    @Test(dataProvider = "gc")
    public void getMajorByCollegeId(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] gc() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getMajorByCollegeId", "{\"collegeId\":9}"},
                new Object[]{"http://192.168.2.36:8080/common/getMajorByCollegeId", "{\"collegeId\":10}"},
        };
    }

    @Test(dataProvider = "gc1")
    public void getMajorByCollegeId1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] gc1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getMajorByCollegeId", "{\"collegeId\":12234}"},
                new Object[]{"http://192.168.2.36:8080/common/getMajorByCollegeId", "{\"collegeId\":\"abc\"}"},
                new Object[]{"http://192.168.2.36:8080/common/getMajorByCollegeId", "{\"collegeId\":\"123\"}"},
                new Object[]{"http://192.168.2.36:8080/common/getMajorByCollegeId", "{\"collegeId\":\"1a\"}"},
        };
    }

    //4 公共接口-获取年级列表
    @Test(dataProvider = "gG")
    public void getGrade(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] gG() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getGrade", ""},
                new Object[]{"http://192.168.2.36:8080/common/getGrade", ""},
        };
    }

    @Test(dataProvider = "gG1")
    public void getGrade1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] gG1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getGrade", ""},
                new Object[]{"http://192.168.2.36:8080/common/getGrade", ""},
                new Object[]{"http://192.168.2.36:8080/common/getGrade", ""},
                new Object[]{"http://192.168.2.36:8080/common/getGrade", ""},
        };
    }


    //5 公共接口-获取民族列表
    @Test(dataProvider = "gN")
    public void getNation(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] gN() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getNation", ""},
                new Object[]{"http://192.168.2.36:8080/common/getNation", ""},
        };
    }

    @Test(dataProvider = "gN1")
    public void getNation1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] gN1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getNation", ""},
                new Object[]{"http://192.168.2.36:8080/common/getNation", ""},
                new Object[]{"http://192.168.2.36:8080/common/getNation", ""},
                new Object[]{"http://192.168.2.36:8080/common/getNation", ""},
        };
    }

    //6 公共接口-获取省列表
    @Test(dataProvider = "gP")
    public void getProvince(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] gP() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getProvince", ""},
                new Object[]{"http://192.168.2.36:8080/common/getProvince", ""},
        };
    }

    @Test(dataProvider = "gP1")
    public void getProvince1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] gP1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getProvince", ""},
                new Object[]{"http://192.168.2.36:8080/common/getProvince", ""},
                new Object[]{"http://192.168.2.36:8080/common/getProvince", ""},
                new Object[]{"http://192.168.2.36:8080/common/getProvince", ""},
        };
    }

    //7 公共接口-获取总流程状态码
    @Test(dataProvider = "gT")
    public void getStatus(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] gT() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getStatus", ""},
                new Object[]{"http://192.168.2.36:8080/common/getStatus", ""},
        };
    }

    @Test(dataProvider = "gT1")
    public void getStatus1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] gT1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getStatus", ""},
                new Object[]{"http://192.168.2.36:8080/common/getStatus", ""},
                new Object[]{"http://192.168.2.36:8080/common/getStatus", ""},
                new Object[]{"http://192.168.2.36:8080/common/getStatus", ""},
        };
    }

    //8 公共接口-通过省获取市列表
    @Test(dataProvider = "gCBP")
    public void getCityByProvinceId(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] gCBP() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getCityByProvinceId", "{\"provinceId\":20}"},
                new Object[]{"http://192.168.2.36:8080/common/getCityByProvinceId", "{\"provinceId\":25}"},
        };
    }

    @Test(dataProvider = "gCBP1")
    public void getCityByProvinceId1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] gCBP1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getCityByProvinceId", "{\"provinceId\":123}"},
                new Object[]{"http://192.168.2.36:8080/common/getCityByProvinceId", "{\"provinceId\":\"dde\"}"},
                new Object[]{"http://192.168.2.36:8080/common/getCityByProvinceId", "{\"provinceId\":\"123acv\"}"},
                new Object[]{"http://192.168.2.36:8080/common/getCityByProvinceId", "{\"provinceId\":\"123445\"}"},
        };
    }

    //9 公共接口-通过市获取县列表
    @Test(dataProvider = "gCBC")
    public void getCountyByCityId(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] gCBC() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getCountyByCityId", "{\"cityId\":220}"},
                new Object[]{"http://192.168.2.36:8080/common/getCountyByCityId", "{\"cityId\":270}"},
        };
    }

    @Test(dataProvider = "gCBC1")
    public void getCountyByCityId1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] gCBC1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getCountyByCityId", "{\"cityId\":12333}"},
                new Object[]{"http://192.168.2.36:8080/common/getCountyByCityId", "{\"cityId\":\"dde\"}"},
                new Object[]{"http://192.168.2.36:8080/common/getCountyByCityId", "{\"cityId\":\"123acv\"}"},
                new Object[]{"http://192.168.2.36:8080/common/getCountyByCityId", "{\"cityId\":\"123445\"}"},
        };
    }

    //10 公共接口-获取政治面貌列表
    @Test(dataProvider = "Si")
    public void getParty(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] Si() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getParty", ""},
        };
    }

    @Test(dataProvider = "Si1")
    public void getParty1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] Si1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getParty", ""},
                new Object[]{"http://192.168.2.36:8080/common/getParty", ""},
                new Object[]{"http://192.168.2.36:8080/common/getParty", ""},
                new Object[]{"http://192.168.2.36:8080/common/getParty", ""},
        };
    }

    //11 公共接口-查看学生申请材料
    @Test(dataProvider = "vAMBS")
    public void viewApplyMaterialByStuId(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] vAMBS() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/viewApplyMaterialByStuId", "{\"studentId\":\"201503030307\"}"},
                new Object[]{"http://192.168.2.36:8080/common/viewApplyMaterialByStuId", "{\"studentId\":\"2012043030023\"}"},
                new Object[]{"http://192.168.2.36:8080/common/viewApplyMaterialByStuId", "{\"studentId\":\"2014070901003\"}"},
        };
    }

    @Test(dataProvider = "vAMBS1")
    public void viewApplyMaterialByStuId1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] vAMBS1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/viewApplyMaterialByStuId", "{\"studentId\":\"qwer1234\"}"},
                new Object[]{"http://192.168.2.36:8080/common/viewApplyMaterialByStuId", "{\"studentId\":23345}"},
                new Object[]{"http://192.168.2.36:8080/common/viewApplyMaterialByStuId", "{\"studentId\":\"33434\"}"},
                new Object[]{"http://192.168.2.36:8080/common/viewApplyMaterialByStuId", "{\"studentId\":\"abcdefg\"}"},
                new Object[]{"http://192.168.2.36:8080/common/viewApplyMaterialByStuId", "{\"studentId\":\"201407090100311\"}"},
        };
    }

    //12 公共接口-贫困申请认定下载
    @Test(dataProvider = "dlL")
    public void downloadList(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] dlL() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/downloadList", "{\"gradeId\":9,\"collegeId\":9,\"majorId\":875,\"classId\":4}"},
        };
    }

    @Test(dataProvider = "dlL1")
    public void downloadList1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] dlL1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/downloadList", "{\"gradeId\":50,\"collegeId\":50,\"majorId\":875,\"classId\":4}"},
                new Object[]{"http://192.168.2.36:8080/common/downloadList", "{\"gradeId\":50,\"collegeId\":9,\"majorId\":875,\"classId\":4}"},
                new Object[]{"http://192.168.2.36:8080/common/downloadList", "{\"gradeId\":50,\"collegeId\":50,\"majorId\":40,\"classId\":40}"},
                new Object[]{"http://192.168.2.36:8080/common/downloadList", "{\"gradeId\":\"50\",\"collegeId\":\"50\",\"majorId\":\"40\",\"classId\":40}"},
                new Object[]{"http://192.168.2.36:8080/common/downloadList", "{\"gradeId\":\"aa\",\"collegeId\":\"cc\",\"majorId\":\"40\",\"classId\":40}"},
        };
    }
    //13 公共接口-获取困难认定
    @Test(dataProvider = "gPl")
    public void getPoorList(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] gPl() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getPoorList", "{\"gradeId\":6,\"collegeId\":10,\"majorId\":877,\"classId\":9,\"pageIndex\":1,\"pageSize\":1}"},
        };
    }

    @Test(dataProvider = "gPl1")
    public void getPoorList1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] gPl1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getPoorList", "{\"gradeId\":6,\"collegeId\":10,\"majorId\":877,\"classId\":9,\"pageIndex\":0,\"pageSize\":0}"},
                new Object[]{"http://192.168.2.36:8080/common/getPoorList", "{\"gradeId\":60,\"collegeId\":100,\"majorId\":877,\"classId\":9,\"pageIndex\":1,\"pageSize\":1}"},
                new Object[]{"http://192.168.2.36:8080/common/getPoorList", "{\"gradeId\":\"60\",\"collegeId\":\"10\",\"majorId\":877,\"classId\":9,\"pageIndex\":1,\"pageSize\":1}"},
                new Object[]{"http://192.168.2.36:8080/common/getPoorList", "{\"gradeId\":\"aa\",\"collegeId\":\"wc\",\"majorId\":877,\"classId\":9,\"pageIndex\":1,\"pageSize\":1}"},
        };
    }

    //14 公共接口-获取个人信息
    @Test(dataProvider = "gPsI3")
    public void getPersonalInfo3(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] gPsI3() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getPersonalInfo", ""},
        };
    }

    @Test(dataProvider = "gPsI4")
    public void getPersonalInfo4(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] gPsI4() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getPersonalInfo", ""},
                new Object[]{"http://192.168.2.36:8080/common/getPersonalInfo", ""},
                new Object[]{"http://192.168.2.36:8080/common/getPersonalInfo", ""},
                new Object[]{"http://192.168.2.36:8080/common/getPersonalInfo", ""},
        };
    }
    //15 公共接口-获取贫困告警列表
    @Test(dataProvider = "getPAL2")
    public void getPoorAlarmList2(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] getPAL2() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getPoorAlarmList", ""},
        };
    }
    @Test(dataProvider = "getPAL3")
    public void getPoorAlarmList3(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] getPAL3() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getPoorAlarmList", ""},
                new Object[]{"http://192.168.2.36:8080/common/getPoorAlarmList", ""},
                new Object[]{"http://192.168.2.36:8080/common/getPoorAlarmList", ""},
                new Object[]{"http://192.168.2.36:8080/common/getPoorAlarmList", ""},
        };
    }

    //16 公共接口-获取动态管理学生列表
    @Test(dataProvider = "gDSL2")
    public void getDynamicStudentList2(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] gDSL2() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getDynamicStudentList", "{\"gradeId\":6,\"collegeId\":10,\"majorId\":877,\"classId\":9,\"pageIndex\":1,\"pageSize\":1}"},
                new Object[]{"http://192.168.2.36:8080/common/getDynamicStudentList", "{\"gradeId\":6,\"collegeId\":10,\"majorId\":877,\"classId\":9,\"pageIndex\":1,\"pageSize\":5}"},
                new Object[]{"http://192.168.2.36:8080/common/getDynamicStudentList", "{\"gradeId\":6,\"collegeId\":10,\"majorId\":877,\"classId\":9,\"pageIndex\":1,\"pageSize\":10}"},
        };
    }
    @Test(dataProvider = "gDSL3")
    public void getDynamicStudentList3(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] gDSL3() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/getDynamicStudentList", "{\"gradeId\":6,\"collegeId\":10,\"majorId\":877,\"classId\":9,\"pageIndex\":0,\"pageSize\":0}"},
                new Object[]{"http://192.168.2.36:8080/common/getDynamicStudentList", "{\"gradeId\":60,\"collegeId\":100,\"majorId\":877,\"classId\":9,\"pageIndex\":1,\"pageSize\":1}"},
                new Object[]{"http://192.168.2.36:8080/common/getDynamicStudentList", "{\"gradeId\":\"60\",\"collegeId\":\"10\",\"majorId\":877,\"classId\":9,\"pageIndex\":1,\"pageSize\":1}"},
                new Object[]{"http://192.168.2.36:8080/common/getDynamicStudentList", "{\"gradeId\":\"aa\",\"collegeId\":\"wc\",\"majorId\":877,\"classId\":9,\"pageIndex\":1,\"pageSize\":1}"},
        };
    }

    //17 公共接口-动态管理修改学生贫困等级
    @Test(dataProvider = "mdPyL")
    public void modifyPovertyLevel(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] mdPyL() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/modifyPovertyLevel", "{\"povertyLevel\":\"8\",\"studentId\":\"2014070901003\"}"},
        };
    }
    @Test(dataProvider = "mdPyL1")
    public void modifyPovertyLevel1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] mdPyL1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/modifyPovertyLevel", "{\"povertyLevel\":\"7\",\"studentId\":\"2014070901003\"}"},//与数据库中原有等级相同
                new Object[]{"http://192.168.2.36:8080/common/modifyPovertyLevel", "{\"povertyLevel\":\"7\",\"studentId\":\"201407090100311\"}"},//数据库中不存在的ID
                new Object[]{"http://192.168.2.36:8080/common/modifyPovertyLevel", "{\"povertyLevel\":\"7\",\"studentId\":2014070901003}"},
                new Object[]{"http://192.168.2.36:8080/common/modifyPovertyLevel", "{\"povertyLevel\":\"a\",\"studentId\":\"wwwewew\"}"},
        };
    }
    //18 公共接口-导出贫困告警名单
    @Test(dataProvider = "ddPAL")
    public void downloadPoorAlarmList(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] ddPAL() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/downloadPoorAlarmList", "{\"povertyLevel\":\"7\"}"},
                new Object[]{"http://192.168.2.36:8080/common/downloadPoorAlarmList", "{\"povertyLevel\":\"22\"}"},
        };
    }
    @Test(dataProvider = "ddPAL1")
    public void downloadPoorAlarmList1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] ddPAL1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/downloadPoorAlarmList", "{\"povertyLevel\":\"1\"}"},
                new Object[]{"http://192.168.2.36:8080/common/downloadPoorAlarmList", "{\"povertyLevel\":\"100\"}"},
                new Object[]{"http://192.168.2.36:8080/common/downloadPoorAlarmList", "{\"povertyLevel\":\"aa\"}"},
                new Object[]{"http://192.168.2.36:8080/common/downloadPoorAlarmList", "{\"povertyLevel\":111}"},
        };
    }
    //19 公共接口-下载动态管理名单
    @Test(dataProvider = "dDSL")
    public void downloadDynamicStudentList(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("true"));

    }

    @DataProvider
    public Object[][] dDSL() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/downloadDynamicStudentList", "{\"gradeId\":8,\"collegeId\":13,\"majorId\":884,\"classId\":2}"},
        };
    }
    @Test(dataProvider = "dDSL1")
    public void downloadDynamicStudentList1(String Url, String data) {
        String result = HttpClient.sendInfo(client, Url, data);
        Assert.assertTrue(result.contains("false"));

    }

    @DataProvider
    public Object[][] dDSL1() {
        return new Object[][]{
                new Object[]{"http://192.168.2.36:8080/common/downloadDynamicStudentList", "{\"gradeId\":80,\"collegeId\":13,\"majorId\":884,\"classId\":2}"},//gradeId在数据库中不存在
                new Object[]{"http://192.168.2.36:8080/common/downloadDynamicStudentList", "{\"gradeId\":8,\"collegeId\":13,\"majorId\":8,\"classId\":40}"},
                new Object[]{"http://192.168.2.36:8080/common/downloadDynamicStudentList", "{\"gradeId\":\"aa\",\"collegeId\":13,\"majorId\":884,\"classId\":2}"},
        };
    }
}