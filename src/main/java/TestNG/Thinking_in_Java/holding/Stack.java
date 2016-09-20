package TestNG.Thinking_in_Java.holding;

import java.util.LinkedList;

/**
 * Created by DreamYao on 2016/7/4.
 */
public class Stack<T> {
    private LinkedList<T>storage=new LinkedList<T>();
    public void push(T v){
        storage.addFirst(v);
    }
    public T peek(){
        return storage.getFirst();
    }
    public T pop(){
        return storage.removeFirst();
    }
    public boolean empty(){
        return storage.isEmpty();
    }
    public String toString(){
        return storage.toString();
    }
}
