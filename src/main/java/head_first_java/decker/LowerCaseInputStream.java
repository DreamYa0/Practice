package head_first_java.decker;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.lang.Character.toLowerCase;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/7/12 12:57
 */
public class LowerCaseInputStream extends FilterInputStream {

    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    /**
     * 把所有都转换为小心
     * @return
     * @throws IOException
     */
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : toLowerCase((char) c));
    }

    /**
     * 把索引段内的转换为小写
     * @param b
     * @param offset
     * @param len
     * @return
     * @throws IOException
     */
    public int read(byte[] b, int offset, int len) throws IOException {
        int result = super.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte) toLowerCase((char) b[i]);
        }
        return result;
    }
}
