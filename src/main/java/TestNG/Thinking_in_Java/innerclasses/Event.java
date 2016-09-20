package TestNG.Thinking_in_Java.innerclasses;

/**
 * Created by DreamYao on 2016/6/20.
 * P208内部类与控制框架
 */
public abstract class Event {
    private long evenTime;
    protected final long delayTime;
    public Event(long delayTime){
        this.delayTime=delayTime;
        start();
    }
    public void start(){
        evenTime=System.nanoTime()+delayTime;
    }
    public boolean ready(){
        return System.nanoTime()>=evenTime;
    }
    public abstract void action();
}
