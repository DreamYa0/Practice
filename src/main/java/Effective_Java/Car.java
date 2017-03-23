package Effective_Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dreamyao on 2017/3/23.
 */
public class Car {

    private List<String> masters;

    private String brand="";

    private List<Integer> prices;

    public String addCar(String master,Integer price){
        if ("".equals(master) || master == null || price <= 0) {
            return "添加数据有误！";
        }
        masters.add(master);
        prices.add(price);
        return "数据添加成功！";
    }

    public List<String> getMasters() {
        return masters;
    }

    public void setMasters(List<String> masters) {
        this.masters = masters;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }
}

class AutoCar extends Car{

    private List<String> masters;

    private String brand="奥拓";

    private List<Integer> prices;

    public AutoCar(){
        masters = new ArrayList<>();
        prices = new ArrayList<>();

        masters.add("姚军");
        prices.add(10000);

        masters.add("李晓坤");
        prices.add(20000);
    }

    public List<String> getMasters() {
        return masters;
    }

    public void setMasters(List<String> masters) {
        this.masters = masters;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }
}

class BMWCar extends Car{

    private List<String> masters;

    private String brand="宝马";

    private List<Integer> prices;

    public BMWCar(){
        masters = new ArrayList<>();
        prices = new ArrayList<>();

        masters.add("赵香敏");
        prices.add(200000);

        masters.add("杨闵翰");
        prices.add(300000);
    }

    public List<String> getMasters() {
        return masters;
    }

    public void setMasters(List<String> masters) {
        this.masters = masters;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }
}

class BenzCar extends Car{

    private List<String> masters;

    private String brand="奔驰";

    private List<Integer> prices;

    public List<String> getMasters() {
        return masters;
    }

    public void setMasters(List<String> masters) {
        this.masters = masters;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }

    public BenzCar(){
        masters = new ArrayList<>();
        prices = new ArrayList<>();

        masters.add("颜杰");
        prices.add(250000);

        masters.add("周小琴");
        prices.add(350000);
    }
}

class Test{
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(Arrays.asList(new AutoCar(),new BMWCar(),new BenzCar()));
        for (Car car : cars) {
            String name=car.getBrand();
            List<Integer> pices=car.getPrices();
            int total=0;
            for (Integer integer : car.getPrices()) {
                total+=integer;
            }
            System.out.println("品牌: "+name);
            System.out.println("评价价格: "+ total/pices.size());
        }
    }
}