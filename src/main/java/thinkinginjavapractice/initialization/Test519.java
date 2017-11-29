package thinkinginjavapractice.initialization;

/**
 * Created by DreamYao on 2016/5/19.
 */
public class Test519 {

    static void name(String... args){
        for(String a:args){
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        name(new String[]{"wew","wwwe"});
        name("wo","kao");

    }

}

