package Thinking_in_Java.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P131
public class SpaceShip extends SpceShipControls {
    private String name;
    public SpaceShip(String name){
        this.name=name;
    }
    public String toString(){
        return name;
    }
    public static void main(String[] args) {
        SpaceShip protector=new SpaceShip("NSEA Protecetor");
        protector.forward(100);
    }

}
