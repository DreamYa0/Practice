package TestNG.Jsoup.UestcSystem;

        import static com.dataset.db.Dbutil.JsonValue;

/**
 * Created by DreamYao on 2016/6/17.
 */
public class UrlAndData {

    //教师个人详情-人事信息-基本信息
    static final String data1 = JsonValue("SELECT id FROM p_teacher LIMIT 0,1");
    static final String url1 = "http://192.168.2.49:8080/teacherDetails/HRInfo/basicInfo";

    //教师个人详情-人事信息-岗位聘任
    static final String data2 = JsonValue("SELECT id FROM p_post LIMIT 0,1");
    static final String url2 = "http://192.168.2.49:8080/teacherDetails/HRInfo/station";

    //教师个人详情-人事信息-学习经历
    static final String data3 = JsonValue("SELECT id FROM p_study LIMIT 0,1");
    static final String url3 = "http://192.168.2.49:8080/teacherDetails/HRInfo/learn";

    //教师个人详情-人事信息-海外学习
    static final String data4 = JsonValue("SELECT id FROM p_teacher LIMIT 1,1");
    static final String url4 = "http://192.168.2.49:8080/teacherDetails/HRInfo/abroad";

    //教师个人详情-人事信息-入校前工作经历
    static final String data5 = JsonValue("SELECT id FROM p_teacher LIMIT 1,1");
    static final String url5 = "http://192.168.2.49:8080/teacherDetails/HRInfo/workExperience";
}

class ProjectsUrlAndData {

    //教师个人详情-科研项目-项目详情
    static final String data3 = JsonValue("SELECT id FROM o_project LIMIT 1,1");
    static final String url3 = "http://192.168.2.49:8080/teacherDetails/projects/detail";
}

class ResultUrlAndData {

    //教师个人详情-科研成果-论文列表
    static final String data2 = JsonValue("SELECT id,startDate,endDate FROM o_project LIMIT 0,1");
    static final String url2 = "http://192.168.2.49:8080/teacherDetails/result/paperList";
}

class TalentUrlAndData {

    //教师个人详情-人才培养-时间段
    static final String url1 = "http://192.168.2.49:8080/teacherDetails/talent/timerange";

    //教师个人详情-人才培养-人才培养列表
    static final String data2 = JsonValue("SELECT A.startDate,A.endDate,B.id FROM o_project A LEFT JOIN  p_teacher B ON A.projectKind_id=B.id UNION SELECT A.startDate,A.endDate,B.id FROM o_project A RIGHT JOIN  p_teacher B ON A.id=B.id LIMIT 1,1");
    static final String url2 = "http://192.168.2.49:8080/teacherDetails/talent/talentsList";
}

class HRInfo {
    //信息聚合-人事信息-基本信息
    static final String data1 = JsonValue("");
    static final String url1 = "http://192.168.2.49:8080/informationFusion/HRInfo/basicInfo";
    //信息聚合-人事信息-岗位聘任
    static final String data2 = JsonValue("");
    static final String url2 = "http://192.168.2.49:8080/informationFusion/HRInfo/station";
    //信息聚合-人事信息-学习经历
    static final String data3 = JsonValue("");
    static final String url3 = "http://192.168.2.49:8080/informationFusion/HRInfo/learn";
    //信息聚合-人事信息-海外学习
    static final String data4 = JsonValue("");
    static final String url4 = "http://192.168.2.49:8080/informationFusion/HRInfo/abroad";
    //信息聚合-人事信息-工作经历
    static final String data5 = JsonValue("");
    static final String url5 = "http://192.168.2.49:8080/informationFusion/HRInfo/workExprirence";
}

class Projects {
    //信息聚合-科研项目-时间段
    static final String url1 = "http://192.168.2.49:8080/informationFusion/projects/timerange";
    //信息聚合-科研项目-纵向·横向·校级项目
    static final String data2 = JsonValue("");
    static final String url2 = "http://192.168.2.49:8080/informationFusion/projects/levelList";
}

class Result {
    //信息聚合-科研成果-时间段
    static final String url1 = "http://192.168.2.49:8080/informationFusion/result/timerange";
    //信息聚合-科研成果-科研成果列表
    static final String data2 = JsonValue("");
    static final String url2 = "http://192.168.2.49:8080/informationFusion/result/resultsList";
}

class TalentTraining {
    //信息聚合-人才培养-时间段
    static final String url1 = "http://192.168.2.49:8080/informationFusion/talent/timerange";
    //信息聚合-人才培养-人才培养列表
    static final String data2 = JsonValue("");
    static final String url2 = "http://192.168.2.49:8080/informationFusion/talent/talentsList";
}

class ThePersonInfo {
    //教师总览-人事信息-统计信息
    static final String data1 = JsonValue("");
    static final String url1 = "http://192.168.2.49:8080/report/HRinfo/count";
    //教师总览-人事信息-基本信息/职务级别
    static final String data2 = JsonValue("");
    static final String url2 = "http://192.168.2.49:8080/report/HRinfo/basic";
    //教师总览-人事信息-基本信息/职务级别
    static final String data3 = JsonValue("");
    static final String url3 = "http://192.168.2.49:8080/report/HRinfo/jobLevel";
    //教师总览-人事信息-教师引进/教师晋升/教师海外学习
    static final String data4 = JsonValue("");
    static final String url4 = "http://192.168.2.49:8080/report/HRinfo/import";
    //教师总览-人事信息-学习经历
    static final String data5 = JsonValue("");
    static final String url5 = "http://192.168.2.49:8080/report/HRinfo/study";
    //教师总览-人事信息-博士学校
    static final String data6 = JsonValue("");
    static final String url6 = "http://192.168.2.49:8080/report/HRinfo/doctorSchool";
}

class ScientificResearchProject {
    //教师总览-科研项目-到账经费/支出经费/到账经费排名
    static final String data1 = JsonValue("");
    static final String url1 = "http://192.168.2.49:8080/report/project/Charges";
    //教师总览-科研项目-到账经费/支出经费/到账经费排名
    static final String data2 = JsonValue("");
    static final String url2 = "http://192.168.2.49:8080/report/project/ChargesView";
    //教师总览-科研项目-拨款单位
    static final String data3 = JsonValue("");
    static final String url3 = "http://192.168.2.49:8080/report/project/source";
    //教师总览-科研项目-排行榜
    static final String data4 = JsonValue("");
    static final String url4 = "http://192.168.2.49:8080/report/project/rank";
}

class ScientificPayoffs {
    //教师总览-科研成果-论文数/高水平论文数/获奖数/专利数/软著数
    static final String data1 = JsonValue("");
    static final String url1 = "http://192.168.2.49:8080/report/result/resultNum";
    //教师总览-科研成果-论文报表
    static final String data2 = JsonValue("");
    static final String url2 = "http://192.168.2.49:8080/report/result/paperReport";
    //教师总览-科研成果-论文报表
    static final String data3 = JsonValue("");
    static final String url3 = "http://192.168.2.49:8080/report/result/paperRank";
    //教师总览-科研成果-其他成果
    static final String data4 = JsonValue("");
    static final String url4 = "http://192.168.2.49:8080/report/result/other";
    //教师总览-科研成果-论文期刊,论文会议
    static final String data5 = JsonValue("");
    static final String url5 = "http://192.168.2.49:8080/report/result/publish";
}

class CultivationOfTalents {
    //教师总览-人才培养-教师课程数量
    static final String data1 = JsonValue("");
    static final String url1 = "http://192.168.2.49:8080/report/result/teacherCourseInfo";
    //教师总览-人才培养-受欢迎教师/受欢迎课程
    static final String data2 = JsonValue("");
    static final String url2 = "http://192.168.2.49:8080/report/result/welcome";
    //教师总览-人才培养-评教分数
    static final String data3 = JsonValue("");
    static final String url3 = "http://192.168.2.49:8080/report/result/welcome";
}