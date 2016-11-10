package Thinking_in_Java.exceptions;

/**
 * Created by DreamYao on 2016/7/24.
 * P266 finally用来做什么
 */
public class Switch {
    private boolean state=false;
    public boolean read(){return state;}
    public void on(){
        state=true;
        System.out.println(this);
    }
    public void off(){
        state=false;
        System.out.println(this);
    }
    public String toString(){
        return state ? "on" : "off";
    }
}
