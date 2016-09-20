package TestNG.Thinking_in_Java.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by DreamYao on 2016/6/23.
 * P221
 */
public class AsListInference {
    public static void main(String[] args) {
        List<Snow>snow1= Arrays.asList(new Crusty(),new Slush(),new Power());
        List<Snow>snow3=new ArrayList<Snow>();
        Collections.addAll(snow3,new Light(),new Heavy());//存放对象
        List<Snow>snow4=Arrays.<Snow>asList(new Light(),new Heavy());
    }
}
class Snow{}
class Power extends Snow{}
class Light extends Power{}
class Heavy extends Power{}
class Crusty extends Snow{}
class Slush extends Snow{}

