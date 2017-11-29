package testng;

import org.testng.IHookable;
import org.testng.annotations.DataProvider;
import testng.util.ExcelUtils;
import testng.util.TestNGUtils;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static testng.util.Constants.TEST_ONLY;
import static testng.util.ParamUtils.isValueTrue;

/**
 * Created by dreamyao on 2017/5/5.
 */
public abstract class BaseTest implements IHookable {
    @DataProvider(name = "excel")
    public java.util.Iterator<Object[]> dataProvider(Method method) throws Exception {
        String className = this.getClass().getSimpleName();
        String resource = this.getClass().getResource("").getPath();
        String xlsx = resource + className + ".xlsx";
        ExcelUtils excelUtil = new ExcelUtils();
        List<Map<String, Object>> list = excelUtil.readDataByRow(xlsx, method.getName());
        Set<Object[]> set = new HashSet<Object[]>();

        // 如果有测试用例 testOnly 标志设置为1或者Y，则单独运行，其他没带此标志的测试用例跳过
        boolean hasTestOnly = false;
        for (Map<String, Object> map : list) {
            if (isValueTrue(map.get(TEST_ONLY))) {
                hasTestOnly = true;
                break;
            }
        }
        for (Map<String, Object> map : list) {
            if (hasTestOnly) {
                if (!isValueTrue(map.get(TEST_ONLY))) {
                    continue;
                }
            }
            // 注入默认值，否则执行时参数不匹配
            set.add(TestNGUtils.injectResultAndParametersByDefault(map, method));
        }

        java.util.Iterator<Object[]> iterator = set.iterator();
        return iterator;
    }
}
