package dynamicproxy;

/**
 * Created by dreamyao on 2017/4/10.
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getName() {
        return "DreamYao";
    }

    @Override
    public String getAge() {
        return "25";
    }
}
