package Mock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreamyao on 16-9-23.
 */
public class User {
    private String name;
    private String id;

    public User() {
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return id;
    }

    public void setUserId(String id) {
        this.id = id;
    }
}
