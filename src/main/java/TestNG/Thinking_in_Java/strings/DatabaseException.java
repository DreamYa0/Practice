package TestNG.Thinking_in_Java.strings;

/**
 * Created by DreamYao on 2016/8/8.
 * P294 String.format()
 */
public class DatabaseException extends Exception {
    public DatabaseException(int transactionID, int queryID, String message) {
        super(String.format("(t%d,q%d).%s", transactionID, queryID, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, "Write failed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
