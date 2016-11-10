package Thinking_in_Java.typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * @author dreamyao
 *         Created by dreamyao on 16-9-21.
 *         P344
 */
public class SnowRemovalRobot implements Robot {
    private String name;

    public SnowRemovalRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot Series 11";
    }

    @Override
    public List<Operation> operation() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String description() {
                        return name + "can shovel snow";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + "shoveling snow");
                    }
                },
                new Operation() {
                    public String description() {
                        return name + "can chip ice";
                    }

                    public void command() {
                        System.out.println(name + "chipping");
                    }
                },
                new Operation() {
                    @Override
                    public String description() {
                        return name + "can clear the roof";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + "clearing roof");
                    }
                });
    }

    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
    }
}
