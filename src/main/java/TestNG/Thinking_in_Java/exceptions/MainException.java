package TestNG.Thinking_in_Java.exceptions;

        import java.io.FileInputStream;

/**
 * Created by DreamYao on 2016/7/29.
 * P279 把异常传递给控制台
 */
public class MainException {
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("MainException.java");
        file.close();
    }
}
