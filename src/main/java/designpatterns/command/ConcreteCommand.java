package designpatterns.command;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/7 20:50
 */
public class ConcreteCommand implements Command {

    List<String> dirNameList;
    private MakeDir makeDir;

    public ConcreteCommand(MakeDir makeDir) {
        dirNameList = Lists.newArrayList();
        this.makeDir = makeDir;
    }

    @Override
    public void execute(String filePath) {
        makeDir.createDir(filePath);
        dirNameList.add(filePath);
    }

    @Override
    public void undo() {
        if (dirNameList.size() > 0) {
            String str = dirNameList.get(dirNameList.size() - 1);
            makeDir.deleteDir(str);
            dirNameList.remove(dirNameList.size() - 1);
        } else {
            System.out.println("没有需要撤销的操作!");
        }
    }
}
