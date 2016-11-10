package Thinking_in_Java.exceptions;

/**
 * Created by DreamYao on 2016/7/24.
 * P269跟简单异常丢失方式是从finally子句中返回
 */
public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            return;
        }
    }
}