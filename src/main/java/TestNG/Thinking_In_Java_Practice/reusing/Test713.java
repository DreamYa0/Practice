package TestNG.Thinking_In_Java_Practice.reusing;

/**
 * Created by DreamYao on 2016/5/19.
 */
//P136
public class Test713 extends B{

    int name(B g){
        return a-b;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test713 test713=new Test713();
        float c=test713.name(1.0f, 1.0f);
        int d=test713.name(1, 1);
        int f=test713.name(1,1);
        String e=test713.name("1", "1");
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

    }

}
class B{
    int a,b;
    public int name(int a,int b) {
        return a+b;
    }
    public String name(String a,String b) {
        return a+b;
    }
    public float name(float a,float b) {
        return a+b;
    }
}
