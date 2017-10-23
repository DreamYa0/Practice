package thinkinginjava.innerclasses;

/**
 * Created by AmyHou on 2016/6/10.
 * P202接口内部类
 */
public interface ClassInInterface {
    void howdy();

    /**放到接口中的任何类都自动的是public和static的，可以接口内部
     * 实现其外围接口
     */

    class Test implements ClassInInterface{
        @Override
        public void howdy() {
            System.out.println("Howdy");
        }
        public static void main(String[] args){
            new Test().howdy();
        }
    }
}
