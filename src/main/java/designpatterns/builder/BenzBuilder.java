package designpatterns.builder;

import java.util.List;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/30 下午5:32
 */
public class BenzBuilder extends CarBuilder {

    private BenzModel benz = new BenzModel();

    @Override
    public void setSequence(List<String> sequence) {
        benz.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return benz;
    }
}
