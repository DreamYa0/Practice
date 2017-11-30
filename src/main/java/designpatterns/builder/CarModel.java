package designpatterns.builder;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/30 下午5:19
 */
public abstract class CarModel {

    private List<String> sequence = Lists.newArrayList();

    public abstract void start();

    public abstract void stop();

    public abstract void alarm();

    public abstract void engineBoom();

    final public void run(){
        for (int i = 0; i < sequence.size(); i++) {
            String actionName = sequence.get(i);
            if (actionName.equalsIgnoreCase("start")) {
                start();
            } else if (actionName.equalsIgnoreCase("stop")) {
                stop();
            } else if (actionName.equalsIgnoreCase("alarm")) {
                alarm();
            } else if (actionName.equalsIgnoreCase("engine boom")) {
                engineBoom();
            }
        }
    }

    final public void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }
}
