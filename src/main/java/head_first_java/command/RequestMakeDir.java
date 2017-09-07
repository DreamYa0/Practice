package head_first_java.command;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/7 20:55
 */
public class RequestMakeDir {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void startExceuteCommand(String filePath) {
        command.execute(filePath);
    }

    public void undoCommand(){
        command.undo();
    }
}
