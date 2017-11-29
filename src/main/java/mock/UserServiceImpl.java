package mock;

/**
 * Created by dreamyao on 16-9-23.
 */
public class UserServiceImpl implements UserService{
    @Override
    public User findUserByUserName(String name) {
        User user=new User();
        user.setUserName(name);
        user.setUserId("1234");
        return user;
    }

    @Override
    public Boolean hasMatchUser(String name, String id) {
        if (name.equals("tom") && id.equals("1234")) {
            return true;
        }
        return false;
    }

    @Override
    public void registerUser(User user) {
        System.out.println("2222");
    }
}
