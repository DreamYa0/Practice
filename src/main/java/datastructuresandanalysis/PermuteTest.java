package datastructuresandanalysis;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/7/13 22:41
 */
public class PermuteTest {

    public void permute(String string) {
        if (string == null || "".equals(string)) {
            throw new NullPointerException("字符串不能为空！");
        }
        permute(string.toCharArray(), 0, string.toCharArray().length);
    }

    private void permute(char[] chars, int low, int high) {

    }
}
