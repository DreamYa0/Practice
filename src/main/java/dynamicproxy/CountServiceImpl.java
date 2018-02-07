package dynamicproxy;

/**
 * @author dreamyao
 * @title
 * @date 2018/2/7 下午4:41
 * @since 1.0.0
 */
public class CountServiceImpl implements CountService {

    private int count = 0;

    @Override
    public int count() {
        return count ++;
    }
}
