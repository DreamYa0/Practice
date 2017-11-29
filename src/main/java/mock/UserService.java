package mock;

/**
 * Created by dreamyao on 16-9-23.
 */
public interface UserService {
    User findUserByUserName(String name);

    Boolean hasMatchUser(String name, String id);

    void registerUser(User user);
}
