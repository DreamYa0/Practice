package designpatterns.command;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/7 20:57
 */
public class Application {

    public static void main(String[] args) {
        MakeDir makeDir = new MakeDir();
        Command command = new ConcreteCommand(makeDir);
        RequestMakeDir requestMakeDir = new RequestMakeDir();
        requestMakeDir.setCommand(command);
        requestMakeDir.startExceuteCommand("jiafei");
        requestMakeDir.undoCommand();
    }
}
