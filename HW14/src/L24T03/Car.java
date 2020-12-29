package L24T03;

import L24T03.util.BodyStyle;
import L24T03.util.CarClass;

public class Car {
    private String manufacturer;
    private String model;
    private int production;
    private CarClass carClass;
    private BodyStyle bodyStyle;
    private int consumption;
    private int price;
    private int speed;

    public Car() {
    }

    public Car(String manufacturer, String model, int production, CarClass carClass,
               BodyStyle bodyStyle, int consumption, int price, int speed) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.production = production;
        this.carClass = carClass;
        this.bodyStyle = bodyStyle;
        this.consumption = consumption;
        this.price = price;
        this.speed = speed;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }

    public BodyStyle getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(BodyStyle bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return manufacturer +
                " " + model +
                " '" + production % 100;
    }
}
