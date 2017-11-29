package thinkinginjavapractice.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P138
public class Test714{
    protected Engine engine=new Engine();
    protected Wheel[] wheels=new Wheel[4];
    protected Door
            left=new Door(),
            right=new Door();
    protected Test714() {
        for (int i = 0; i < 4; i++) {
            wheels[i]=new Wheel();
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test714 car=new Test714();
        car.left.window.rollup();
        car.wheels[0].inflate(72);
        car.engine.service(10, 20);


    }

}
class Engine{
    protected void start(){}
    protected void rev(){}
    protected void stop(){}
    protected void service(int a,int b){
        System.out.println(a+b);
    }

}
class Wheel{
    protected void inflate(int psi) {}
}
class Window{
    protected void rollup() {}
    protected void rolldown() {}
}
class Door{
    protected Window window=new Window();
    protected void open(){}
    protected void close() {}
}

