package comsumer;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dreamyao on 2017/3/15.
 */
@Data
public class QaMethod implements Serializable {

    private Integer id;
    /** 项目Id */
    private Integer project_id;
    /** 项目名 */
    private String project_name;
    /** 被测类名 */
    private String class_name;
    /** 被测方法名 */
    private String methods_name;
    /** 入参 */
    private String methods_parameter;
    /** 返回值 */
    private String methods_return;
    /** 测试结果 */
    private Integer is_pass;
    /** 测试轮次数 */
    private Integer round;
    /** 测试用例运行者 */
    private String run_author;
    /** 创建时间 */
    private Date create_time;

}
