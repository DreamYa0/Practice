package Thinking_in_Java.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P138proteed关键字
public class Orc extends Villain {
    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);//调用基类构造器，在继承的后的导出类里必须完成
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {
        set(name);
        this.orcNumber = orcNumber;
    }

    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Orc orc = new Orc("Limburger", 12);
        System.out.println(orc);
        orc.change("Bob", 19);
        System.out.println(orc);

    }

}

class Villain {
    private String name;

    protected void set(String nm) {
        name = nm;
    }

    public Villain(String name) {//作用是创建Villain时候必须传参数
        this.name = name;
    }

    public String toString() {//惰性初始化name
        return "I'm a Villain and my name is " + name;
    }
}
