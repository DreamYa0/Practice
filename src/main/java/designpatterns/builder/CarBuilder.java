package designpatterns.builder;

import java.util.List;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/30 下午5:30
 */
public abstract class CarBuilder {

    public abstract void setSequence(List<String> sequence);

    public abstract CarModel getCarModel();
}
