package designpatterns.factory;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/29 下午8:37
 */
public class HumanFactory extends AbstractHumanFactory {

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Human> T createHuman(Class<T> clazz) {
        Human human = null;
        try {
            human = (Human) Class.forName(clazz.getName()).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) human;
    }
}
