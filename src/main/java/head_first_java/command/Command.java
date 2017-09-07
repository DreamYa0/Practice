package head_first_java.command;

/**
 * @author dreamyao
 * @version 1.0.0
 * @title
 * @Date 2017/9/7 20:49
 */
public interface Command {

    void execute(String filePath);
    void undo();
}
