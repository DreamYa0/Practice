package designpatterns.builder;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/30 下午9:03
 */
public class Director {

    private List<String> sequence = Lists.newArrayList();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BMWBuilder bmwBuilder = new BMWBuilder();

    public BenzModel getBenzModel(){
        sequence.clear();
        sequence.add("start");
        sequence.add("stop");
        benzBuilder.setSequence(sequence);
        return (BenzModel) benzBuilder.getCarModel();
    }

    public BMWModel getBMWModel() {
        sequence.clear();
        sequence.add("alarm");
        sequence.add("start");
        sequence.add("stop");
        bmwBuilder.setSequence(sequence);
        return (BMWModel) bmwBuilder.getCarModel();
    }
}
