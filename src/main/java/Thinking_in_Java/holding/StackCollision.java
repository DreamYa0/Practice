package Thinking_in_Java.holding;

/**
 * Created by DreamYao on 2016/7/4.
 * P231栈的操作
 */
public class StackCollision {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();//自己定义的Stack
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        java.util.Stack<String> stack2 = new java.util.Stack<String>();//java自带的Stack
        for (String s : "My dog has fleas".split(" ")) {
            stack2.push(s);
        }
        while (!stack2.empty()) {
            System.out.print(stack2.pop() + " ");
        }
    }
}
