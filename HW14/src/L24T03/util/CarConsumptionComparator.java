package L24T03.util;

import L24T03.Car;

import java.util.Comparator;

public class CarConsumptionComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getConsumption() - o2.getConsumption();
    }
}
