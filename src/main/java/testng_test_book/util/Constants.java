package testng_test_book.util;

/**
 * Created by dreamyao on 2017/5/5.
 */
public class Constants {
    /**
     * 期望结果，为 Y 时才执行断言
     */
    public static final String ASSERTRESULT_NAME = "assertResult";
    /**
     * 为 Y 时启动自动化测试
     */
    public static final String AUTOTEST_NAME = "autotest";
    /**
     * 单参数，比如Request<Integer>时，excel中的默认属性名称
     */
    public static final String DEFAULT_SINGLE_PARAM_NAME = "data";

    public static final String RESULT_NAME = "m_result";
    public static final String PARAMETER_NAME_ = "m_parameter_";
    public static final String EXCEL_YES = "Y";
    public static final String EXCEL_NO = "N";
    public static final String EXCEL_NULL = "null";
    public static final String EXCEL_FOREACH = "foreach";

    /**
     * 断言的时候，旧值是执行接口前的数据库值，需要先保存
     */
    public static final String ASSERT_ITEM_ = "m_assertItem_";

    /**
     * 断言的时候，旧值是执行接口前的数据库值，需要先保存SQL，以供打印
     */
    public static final String OLD_SQL_ = "m_old_sql_";

    /**
     * 测试用例的说明，比如参数type无效
     */
    public static final String EXCEL_DESC = "err";

    public static final String TESTMETHODMETA = "testmethodmeta";

    public static final String EXCEL_IPANDPORT = "ipPort";

    /**
     * 测试用例的序号
     */
    public static final String CASE_INDEX = "CASE_INDEX";

    /**
     * 如果有测试用例此标志设置为1，则单独运行，其他没带此标志的测试用例跳过
     */
    public static final String TEST_ONLY = "testOnly";

    /**
     * 如果有测试用例设置此值，则开启多线程同时调用此测试用例，测试并发
     */
    public static final String THREAD_COUNT = "threadCount";
}
