package TestNG.Thinking_in_Java.exceptions;

/**
 * Created by DreamYao on 2016/7/24.
 * P270异常的限制：如果StormyInning类在扩展了Inning类的同时又实现的Strom接口，
 * 那么Storm里的event()方法就不能改变在Inning中的event()方法的异常接口
 * 否则的话，在使用基类的时候就不能判断是否捕获了正确的异常
 * 如果接口里定义的方法不是来自于基类，那么此方法抛出什么样的异常都没有问题
 */
public class StormyInning extends Inning implements Storm {
    public StormyInning() throws RaineOut,BaseballException {
    }

    public StormyInning(String s) throws Foul, BaseballException {
    }

    @Override
    public void atBat() throws PopFoul {

    }

    @Override
    public void rainHard() throws RaineOut {

    }

    public void event() {
    }

//    public void event() throws RaineOut{
//    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RaineOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RaineOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
    public Inning() throws BaseballException {
    }

    public void event() throws BaseballException {
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {
    }
}

class StormException extends Exception {
}

class RaineOut extends StormException {
}

class PopFoul extends Foul {
}

interface Storm {
    public void event() throws RaineOut;

    public void rainHard() throws RaineOut;
}

