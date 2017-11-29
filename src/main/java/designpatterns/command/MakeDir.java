package designpatterns.command;

import java.io.File;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/7 20:47
 */
public class MakeDir {

    public void createDir(String filePath) {
        File file = new File(filePath);
        file.mkdir();
    }

    public void deleteDir(String filePath) {
        File file = new File(filePath);
        file.delete();
    }
}
