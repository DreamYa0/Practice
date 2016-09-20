package TestNG.Thinking_in_Java.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P131
public class SpaceShipDelegation {
    private String name;
    private SpceShipControls controls=new SpceShipControls();
    public SpaceShipDelegation(String name){
        this.name=name;
    }
    public String toString(){
        return name;
    }
    public void back(int velocity) {
        controls.back(velocity);
    }
    public void down(int velocity) {
        controls.down(velocity);
    }
    public void forward(int velocity) {
        controls.forward(velocity);
    }
    public void left(int velocity) {
        controls.left(velocity);
    }
    public void right(int velocity) {
        controls.right(velocity);
    }
    public void turboBoost() {
        controls.turboBoost();
    }
    public void up(int velocity) {
        controls.up(velocity);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpaceShipDelegation protector=new SpaceShipDelegation("NAEA Protector");
        protector.forward(100);

    }

}

