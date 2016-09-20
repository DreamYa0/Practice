package TestNG.Thinking_in_Java.innerclasses;

/**
 * Created by AmyHou on 2016/6/10.
 * P199再访问工厂方法与P187对比了解其区别
 */
public class Factories {
    public static void serviceConsumer(ServiceFactories fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
    }
}

interface Service {
    void method1();

    void method2();
}

interface ServiceFactories {
    Service getService();
}

class Implementation1 implements Service {
    private Implementation1() {
    }

    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2");
    }

    public static ServiceFactories factory = new ServiceFactories() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };
}

class Implementation2 implements Service {
    private Implementation2() {
    }

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }

    public static ServiceFactories factory = new ServiceFactories() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}
