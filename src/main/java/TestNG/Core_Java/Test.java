package TestNG.Core_Java;

import java.io.*;

/**
 * Created by DreamYao on 2016/7/5.
 */
public class Test {
    public static void main(String[] args) {
        try {
            DataInputStream din=new DataInputStream(new BufferedInputStream(new FileInputStream("employee.dat")));
            PushbackInputStream pbin=new PushbackInputStream(new BufferedInputStream(new FileInputStream("employee.dat")));
            DataInputStream din1=new DataInputStream(pbin=new PushbackInputStream(new BufferedInputStream(new FileInputStream("employee.dat"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(System.getProperty("user.dir"));
    }
}
