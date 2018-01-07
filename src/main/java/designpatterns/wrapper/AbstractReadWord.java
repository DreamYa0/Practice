package designpatterns.wrapper;


import java.io.File;
import java.util.List;

/**
 * @author dreamyao
 * @title
 * @date 2018/1/7 下午9:21
 * @since 1.0.0
 */
public abstract class AbstractReadWord {

    public abstract List<String> readWord(File file);
}
