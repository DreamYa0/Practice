package designpatterns.builder;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author dreamyao
 * @version 1.0.0
 * @description
 * @date 2017/11/30 下午5:26
 */
public class Client {
    public static void main(String[] args) {
        BenzModel benz = new BenzModel();
        List<String> sequence = Lists.newArrayList();
        sequence.add("start");
        sequence.add("stop");
        sequence.add("alarm");
        sequence.add("engine boom");
        benz.setSequence(sequence);
        benz.run();
    }
}
