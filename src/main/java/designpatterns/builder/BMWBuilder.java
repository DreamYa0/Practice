package designpatterns.builder;

import java.util.List;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/30 下午5:35
 */
public class BMWBuilder extends CarBuilder{

    private BMWModel model = new BMWModel();

    @Override
    public void setSequence(List<String> sequence) {
        model.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return model;
    }
}
