package testng.util;

/**
 * Created by dreamyao on 2017/5/5.
 */
public class ParamUtils {

    /**
     * 只有 1 或 Y 返回true
     *
     * @param value
     * @return
     */
    public static boolean isValueTrue(Object value) {
        if (value == null) {
            return false;
        }
        return "1".equalsIgnoreCase(value.toString()) || "Y".equalsIgnoreCase(value.toString());
    }
}
