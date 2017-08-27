package lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/7/22 20:48
 */
@FunctionalInterface
public interface BufferReaderProcessor {
    String process(BufferedReader bufferedReader) throws IOException;
}
