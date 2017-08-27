package Core_Java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by dreamyao on 2017/5/6.
 */
public class PersonTest {

    public String getString(String name){
        return name;
    }
    public class modifyName{
        String newName;
        public void setNewName(String name){
            this.newName=name;
        }
    }

    public modifyName getModifyName(){
        return new modifyName();
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        try {
            Class clazz = Class.forName("Core_Java.Person");
            Object o=clazz.newInstance();
            Person person= (Person) o;
            person.setName("DreamYao");
            person.setAge(25);
            person.setSex("男");
            person.setSchool("电子科大");
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getSex());
            System.out.println(person.getSchool());

            Method[] methods=clazz.getMethods();

            for (Method method : methods) {
                System.out.println(method.getName());
            }

            Method method = clazz.getMethod("setName", String.class);
            method.invoke(clazz.newInstance());
            Method method1 = clazz.getMethod("getName");
            Object result = method1.invoke(method);
            System.out.println(result.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
