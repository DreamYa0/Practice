package TestNG.Thinking_In_Java_Practice.holding;

import TestNG.Thinking_in_Java.innerclasses.Event;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by DreamYao on 2016/7/8.
 */
class Controller {
    // List changed to a LinkedList:
    private List<Event> eventList =
            new LinkedList<Event>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0) {
            Iterator<Event> it =
                    new LinkedList<Event>(eventList).iterator();
            while (it.hasNext()) {
                Event e = it.next();
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    it.remove();
                }
            }
        }
    }
}

class GreenhouseControls extends Controller {
    private boolean light = false;

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        public void action() {
            light = true;
        }

        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        public void action() {
            light = false;
        }

        public String toString() {
            return "Light is off";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        public void action() {
            water = true;
        }

        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        public void action() {
            water = false;
        }

        public String toString() {
            return "Greenhouse water is off";
        }
    }

    private String thermostat = "Day";

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        public void action() {
            thermostat = "Night";
        }

        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        public void action() {
            thermostat = "Day";
        }

        public String toString() {
            return "Thermostat on day setting";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        public void action() {
            addEvent(new Bell(delayTime));
        }

        public String toString() {
            return "Bing!";
        }
    }

    public class Restart extends Event {
        private Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList)
                addEvent(e);
        }

        public void action() {
            for (Event e : eventList) {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        public String toString() {
            return "Restarting system";
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        public void action() {
            System.exit(0);
        }

        public String toString() {
            return "Terminating";
        }
    }
}

public class Test1113 {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1)
            gc.addEvent(
                    new GreenhouseControls.Terminate(
                            new Integer(args[0])));
        gc.run();
    }
}