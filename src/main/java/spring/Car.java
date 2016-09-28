package spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by dreamyao on 16-9-28.
 */
public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean {

    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("调用Car()构造函数");
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()属性");
        this.brand=brand;
    }
    public void introduce(){
        System.out.println("brand:"+brand+";color:"+color+";maxSpeed:"+maxSpeed);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory(). ");
        this.beanFactory=beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("调用:BeanNameAware.setBeanName(). ");
        this.beanName=beanName;
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("调用:DisposableBean.destroy() . ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用:InitializingBean.afterPropertiesSet(). ");
    }
    public void myInit(){
        System.out.println("调用init-method所指定的myInit(). 将maxSpeed设置为240. ");
        this.maxSpeed=240;
    }
    public void myDestroy(){
        System.out.println("调用destroy-method所指定的myDestroy(). ");
    }
}
