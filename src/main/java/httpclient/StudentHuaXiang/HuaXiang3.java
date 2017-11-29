package httpclient.StudentHuaXiang;

import httpclient.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HuaXiang3 {
    CloseableHttpClient client = HttpClients.createDefault();
    Logger logger;

    public HuaXiang3() {
        PropertyConfigurator.configure( "D:\\IdeaWorkspase\\src\\main\\resources\\log4j.properties " );
        logger = Logger.getLogger(HuaXiang3. class );
    }

    @Test(dataProvider = "dp", priority = 1)
    public void Login(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("登录成功"));
        logger.info(result);

    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][]{new Object[]{"http://121.49.110.40:8800/user/login",
                "eyJhY2NvdW50IjoiZHVodWlAdWVzdGMuZWR1LmNuIiwicGFzc3dvcmQiOiJ6a2VQczZJMiJ9"},};
    }

    @Test(dataProvider = "dp1", priority = 2)
    public void GetCondition(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        Assert.assertTrue(result.contains("name"));
        System.out.println(result);
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp1() {
        return new Object[][]{new Object[]{"http://121.49.110.40:8800/groupe/compare/getCondition", ""},};
    }

    @Test(dataProvider = "dp2", priority = 3)
    public void GetCondition1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("false"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp2() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCondition", "{\"key\":,\"dsd\":}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCondition", "{\"ddw\":,\"dsd\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCondition", "{\"key\":,\"dsd\":1}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCondition", "{\"key\":,\"dsd\":}"},};
    }

    @Test(dataProvider = "dp3", priority = 4)
    public void GetCommonCompareKey(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("key"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp3() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"option\":\"专业\",\"array\":[\"通信工程(留学生)\",\"电气信息工程\"],\"college\":[],\"major\":[],\"grade\":[],\"class\":[],\"nation\":[],\"age\":[],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"financial\":[],\"loan\":[],\"rank\":[],\"error\":[],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[],\"company\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"option\":\"年级\",\"array\":[\"2014\",\"电气信息工程\"],\"college\":[],\"major\":[],\"grade\":[],\"class\":[],\"nation\":[],\"age\":[],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"financial\":[],\"loan\":[],\"rank\":[],\"error\":[],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[],\"company\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"option\":\"专业\",\"array\":[\"行政管理\",\"电气信息工程\"],\"college\":[],\"major\":[],\"grade\":[],\"class\":[],\"nation\":[],\"age\":[],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"financial\":[],\"loan\":[],\"rank\":[],\"error\":[],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[],\"company\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"option\":\"年级\",\"array\":[\"2015\",\"电气信息工程\"],\"college\":[],\"major\":[],\"grade\":[],\"class\":[],\"nation\":[],\"age\":[],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"financial\":[],\"loan\":[],\"rank\":[],\"error\":[],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[],\"company\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"option\":\"专业\",\"array\":[\"生物技术\",\"电气信息工程\"],\"college\":[],\"major\":[],\"grade\":[],\"class\":[],\"nation\":[],\"age\":[],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"financial\":[],\"loan\":[],\"rank\":[],\"error\":[],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[],\"company\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"option\":\"专业\",\"array\":[\"英语\",\"电气信息工程\"],\"college\":[],\"major\":[],\"grade\":[],\"class\":[],\"nation\":[],\"age\":[],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"financial\":[],\"loan\":[],\"rank\":[],\"error\":[],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[],\"company\":\"\"}}"},
        };
    }

    @Test(dataProvider = "dp4", priority = 5)
    public void GetCommonCompareKey1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.print(result);
        Assert.assertTrue(result.contains("key"));
        logger.info(result);

    }

    @DataProvider
    public Object[][] dp4() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"company\":\"\",\"college\":[\"百度\"],\"major\":[],\"grade\":[165494],\"class\":[],\"nation\":[16646],\"age\":[],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"sleep\":[],\"dorm\":[],\"financial\":[],\"loan\":[],\"active\":[],\"rank\":[],\"error\":[2],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[]}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"company\":\"\",\"college\":[\"wewew\"],\"major\":[],\"grade\":[165494],\"class\":[],\"nation\":[16646],\"age\":[50],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"sleep\":[],\"dorm\":[],\"financial\":[],\"loan\":[],\"active\":[],\"rank\":[],\"error\":[2],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[]}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"company\":\"\",\"college\":[\"表达式的\"],\"major\":[1],\"grade\":[],\"class\":[],\"nation\":[1],\"age\":[20],\"sex\":[1],\"place\":[],\"social\":[],\"type\":[],\"sleep\":[],\"dorm\":[],\"financial\":[],\"loan\":[],\"active\":[],\"rank\":[],\"error\":[2],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[]}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"company\":\"\",\"college\":[\"我我我\"],\"major\":[22],\"grade\":[1654],\"class\":[],\"nation\":[16646],\"age\":[50],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"sleep\":[],\"dorm\":[],\"financial\":[],\"loan\":[],\"active\":[],\"rank\":[],\"error\":[2],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[]}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"company\":\"\",\"college\":[\"\"],\"major\":[],\"grade\":[],\"class\":[],\"nation\":[],\"age\":[50],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"sleep\":[],\"dorm\":[],\"financial\":[],\"loan\":[],\"active\":[],\"rank\":[],\"error\":[2],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[]}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"company\":\"\",\"college\":[\"\"],\"major\":[],\"grade\":[1],\"class\":[],\"nation\":[16646],\"age\":[50],\"sex\":[3],\"place\":[],\"social\":[],\"type\":[],\"sleep\":[7],\"dorm\":[],\"financial\":[],\"loan\":[],\"active\":[],\"rank\":[],\"error\":[2],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[]}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"company\":\"\",\"college\":[\"\"],\"major\":[],\"grade\":[],\"class\":[],\"nation\":[],\"age\":[],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"sleep\":[99],\"dorm\":[],\"financial\":[],\"loan\":[],\"active\":[],\"rank\":[],\"error\":[2],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[]}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"company\":\"\",\"college\":[\"wewew\"],\"major\":[],\"grade\":[],\"class\":[],\"nation\":[16646],\"age\":[50],\"sex\":[],\"place\":[11],\"social\":[],\"type\":[],\"sleep\":[],\"dorm\":[],\"financial\":[],\"loan\":[],\"active\":[],\"rank\":[],\"error\":[2],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[]}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"company\":\"\",\"college\":[\"\"],\"major\":[],\"grade\":[],\"class\":[144],\"nation\":[16646],\"age\":[50],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"sleep\":[],\"dorm\":[],\"financial\":[],\"loan\":[],\"active\":[],\"rank\":[],\"error\":[2],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[]}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCommonCompareKey", "{\"company\":\"\",\"college\":[\"\"],\"major\":[],\"grade\":[],\"class\":[],\"nation\":[16646],\"age\":[50],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"sleep\":[],\"dorm\":[14],\"financial\":[],\"loan\":[],\"active\":[],\"rank\":[],\"error\":[2],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[]}"},
        };
    }

    // @TestComplex(dataProvider = "dp5", priority = 6)
    // public void GetDoubleCompareKey(String Url, String Data) {
    // String result = HttpClient.sendInfo(client, Url, Data);
    // Assert.assertTrue(result.contains(""));
    // System.out.println(result);
    // }
    //
    // @DataProvider
    // public Object[][] dp5() {
    // return new Object[][] { new Object[] {
    // "http://121.49.110.40:8800/groupe/compare/getCommonCompareKey",
    // "{\"company\":\"\",\"college\":[],\"major\":[],\"grade\":[],\"class\":[],\"nation\":[],\"age\":[],\"sex\":[],\"place\":[],\"social\":[],\"type\":[],\"sleep\":[],\"dorm\":[],\"financial\":[],\"loan\":[],\"active\":[],\"rank\":[],\"error\":[2],\"scholarship\":[],\"thinkinginjavapractice\":[],\"library\":[],\"destination\":[],\"city\":[]}"},
    // };
    // }

//    @TestComplex(dataProvider = "dp6", priority = 7)
//    public void GetForcusGroupCompareKey(String Url, String Data) {
//        String result = HttpClient.sendInfo(client, Url, Data);
//        System.out.println(result);
//        Assert.assertTrue(result.contains(""));
//    }
//
//    @DataProvider
//    public Object[][] dp6() {
//        return new Object[][]{new Object[]{"http://121.49.110.40:8800/groupe/compare/getForcusGroupCompareKey",
//                "{\"array1\":[\"分组1\"，\"分组2\"] }"},};
//    }
//
//    @TestComplex(dataProvider = "dp7", priority = 8)
//    public void GetForcusGroupCompareKey1(String Url, String Data) {
//        String result = HttpClient.sendInfo(client, Url, Data);
//        System.out.println(result);
//        Assert.assertTrue(result.contains(""));
//    }
//
//    @DataProvider
//    public Object[][] dp7() {
//        return new Object[][]{
//                new Object[]{"http://121.49.110.40:8800/groupe/compare/getForcusGroupCompareKey",
//                        "{\"array1\":[\"分组1\"，\"分组2\"] }"},
//                new Object[]{"http://121.49.110.40:8800/groupe/compare/getForcusGroupCompareKey",
//                        "{\"array1\":[\"分组1\"，\"分组2\"] }"},
//                new Object[]{"http://121.49.110.40:8800/groupe/compare/getForcusGroupCompareKey",
//                        "{\"array1\":[\"分组1\"，\"分组2\"] }"},
//                new Object[]{"http://121.49.110.40:8800/groupe/compare/getForcusGroupCompareKey",
//                        "{\"array1\":[\"分组1\"，\"分组2\"] }"},};
 //   }

    @Test(dataProvider = "dp8", priority = 9)
    public void GetGroupCompareBaseInfo(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp8() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareBaseInfo", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\"}"},};
    }

    @Test(dataProvider = "dp9", priority = 10)
    public void GetGroupCompareBaseInfo1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("false"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp9() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareBaseInfo", "{\"key\":\"9908f5baadbb0857dd40488\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareBaseInfo", "{\"key\":15454815}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareBaseInfo", "{\"key\":\"grrgrgr\"}"},};
    }

    @Test(dataProvider = "dp10", priority = 11)
    public void GetGroupCompareLifeInfo(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp10() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大一\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2014-01-09\",\"endDate\":\"2015-01-09\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2014-01-09\",\"endDate\":\"2016-01-09\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2012-01-09\",\"endDate\":\"2015-01-09\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大二\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大二\",\"end\":\"下学期\"}"},};
    }

    @Test(dataProvider = "dp11", priority = 12)
    public void GetGroupCompareLifeInfo1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("false"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp11() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo",
                        "{\"key\":\"01fad10729908f5baadbb0857dd404\",\"start\":\"大五\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"startDate\":\"大五\",\"endDate\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo",
                        "{\"key\":\"01fad10729908f5baadbb0857dd404\",\"start\":\"大四\",\"end\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"startDate\":\"大四\",\"endDate\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"\",\"end\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"\",\"end\":\"\",\"startDate\":\"\",\"endDate\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/GetGroupCompareLifeInfo",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\"}"},};
    }

    @Test(dataProvider = "dp12", priority = 13)
    public void getCompareConsum(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp12() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大一\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2014-01-01\",\"endDate\":\"2015-01-01\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2014-01-01\",\"endDate\":\"2016-01-09\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2012-01-09\",\"endDate\":\"2015-01-09\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大二\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大二\",\"end\":\"下学期\"}"},};
    }

    @Test(dataProvider = "dp13", priority = 14)
    public void getCompareConsum1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("false"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp13() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum",
                        "{\"key\":\"01fad10729908f5baadbb0857dd404\",\"start\":\"大五\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"startDate\":\"大五\",\"endDate\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum",
                        "{\"key\":\"01fad10729908f5baadbb0857dd404\",\"start\":\"大四\",\"end\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"startDate\":\"大四\",\"endDate\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"\",\"end\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"\",\"end\":\"\",\"startDate\":\"\",\"endDate\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareConsum",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\"}"},};
    }

    @Test(dataProvider = "dp14", priority = 15)
    public void getCompareSocialContact(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp14() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大一\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2014-01-01\",\"endDate\":\"2015-01-01\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2014-01-01\",\"endDate\":\"2016-01-01\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2012-01-01\",\"endDate\":\"2015-01-01\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大二\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大二\",\"end\":\"下学期\"}"},};
    }

    @Test(dataProvider = "dp15", priority = 16)
    public void getCompareSocialContact1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("false"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp15() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact",
                        "{\"key\":\"01fad10729908f5baadbb0857dd404\",\"start\":\"大五\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"startDate\":\"大五\",\"endDate\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact",
                        "{\"key\":\"01fad10729908f5baadbb0857dd404\",\"start\":\"大四\",\"end\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"startDate\":\"大四\",\"endDate\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"\",\"end\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"\",\"end\":\"\",\"startDate\":\"\",\"endDate\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareSocialContact",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\"}"},};
    }

    @Test(dataProvider = "dp16", priority = 17)
    public void getCompareLibrary(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp16() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大一\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2014-01-01\",\"endDate\":\"2015-01-01\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2014-01-01\",\"endDate\":\"2016-01-01\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2012-01-01\",\"endDate\":\"2015-01-01\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大二\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大二\",\"end\":\"下学期\"}"},};
    }

    @Test(dataProvider = "dp17", priority = 18)
    public void getCompareLibrary1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("false"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp17() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary",
                        "{\"key\":\"01fad10729908f5baadbb0857dd404\",\"start\":\"大五\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"startDate\":\"大五\",\"endDate\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary",
                        "{\"key\":\"01fad10729908f5baadbb0857dd404\",\"start\":\"大四\",\"end\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"startDate\":\"大四\",\"endDate\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"\",\"end\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"\",\"end\":\"\",\"startDate\":\"\",\"endDate\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareLibrary",
                        "{\"key\":\"01fad10729908f5baadbb0857dd40488\"}"},};
    }

    @Test(dataProvider = "dp20", priority = 21)
    public void getCompareGrade(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("true"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp20() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大一\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2014-01-01\",\"endDate\":\"2015-01-01\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2014-01-01\",\"endDate\":\"2016-01-01\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"startDate\":\"2012-01-01\",\"endDate\":\"2015-01-01\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大二\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"78fd4adf8062401085f3d6bfc3151c87\",\"start\":\"大二\",\"end\":\"下学期\"}"},};
    }

    @Test(dataProvider = "dp21", priority = 22)
    public void getCompareGrade1(String Url, String Data) {
        String result = HttpClient.sendInfo(client, Url, Data);
        System.out.println(result);
        Assert.assertTrue(result.contains("false"));
        logger.info(result);
    }

    @DataProvider
    public Object[][] dp21() {
        return new Object[][]{
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857dd404\",\"start\":\"\",\"end\":\"\"}\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857dd40488443\",\"start\":\"\",\"end\":\"\"}\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857dd404881213\",\"start\":\"\",\"end\":\"\"}\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857dd40\",\"start\":\"\",\"end\":\"\"}\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857\",\"start\":\"\",\"end\":\"\"}\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"d10729908f5baadbb0857dd40488\",\"start\":\"\",\"end\":\"\"}\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"\",\"end\":\"\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"大一\",\"end\":\"不限学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"大二\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"大二\",\"end\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"大四\",\"end\":\"下学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"大四\",\"end\":\"上学期\"}"},
                new Object[]{"http://121.49.110.40:8800/groupe/compare/getCompareGrade", "{\"key\":\"01fad10729908f5baadbb0857dd40488\",\"start\":\"大三\",\"end\":\"上学期\"}"},};
    }
}