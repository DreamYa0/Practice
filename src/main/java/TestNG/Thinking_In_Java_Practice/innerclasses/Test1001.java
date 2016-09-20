package TestNG.Thinking_In_Java_Practice.innerclasses;

/**
 * Created by DreamYao on 2016/6/1.
 */
public class Test1001 {
    class TestClass{
        public String i;
       public void TestClass(String i){
            this.i=i;
           System.out.println(i);
        }
    }
    public TestClass testClass(){
        return new TestClass();
    }
    public static void main(String[] args){
        Test1001 t=new Test1001();
        Test1001.TestClass a=t.testClass();
        a.TestClass("DreamYao");
    }
}
