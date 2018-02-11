package guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author dreamyao
 * @title
 * @date 2018/2/11 下午10:40
 * @since 1.0.0
 */
public class JoinerTest {

    public static void main(String[] args) throws IOException {
        Joiner joiner = Joiner.on("|").skipNulls();
        joiner.useForNull("missing");
        joiner.join("foo", "bar", null);

        StringBuilder stringBuilder = new StringBuilder();
        Joiner.on("|").skipNulls().appendTo(stringBuilder, "foo", "bar", "baz");

        FileWriter fileWriter = new FileWriter(new File("path"));
        List<Date> dates = Lists.newArrayList(new Date(), new Date());
        Joiner.on("#").useForNull(" ").appendTo(fileWriter, dates);
        Joiner.on("#").withKeyValueSeparator("=");
    }
}
