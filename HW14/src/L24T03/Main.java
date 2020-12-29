package L24T03;

import L24T03.util.BodyStyle;
import L24T03.util.CarClass;
import L24T03.util.CarConsumptionComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Porsche", "911", 1981, CarClass.SPORTS, BodyStyle.COUPE,
                11, 40000, 250);
        Car car2 = new Car("BMW", "E34", 1992, CarClass.REGULAR, BodyStyle.COUPE,
                9, 17000, 210);
        Car car3 = new Car("Fiat", "Punto", 2006, CarClass.REGULAR, BodyStyle.HATCHBACK,
                5, 7000, 140);
        Car car4 = new Car("Volkswagen", "Multivan", 2020, CarClass.FAMILY, BodyStyle.MINIVAN,
                7, 70000, 170);

        /*
            Создать таксопарк.
         */
        List<Car> cars = Arrays.asList(car1, car2, car3, car4);
        cars.forEach(System.out::println);
        System.out.println();

        /*
            Подсчитать стоимость автопарка.
         */
        int total = 0;
        for (Car c : cars) {
            total += c.getPrice();
        }
        cars.forEach(car -> System.out.println(car.toString() + " price: " + car.getPrice()));
        System.out.println("Total price: " + total);
        System.out.println();

        /*
            Провести сортировку автомобилей парка по расходу топлива.
         */
        Comparator<Car> carConsComp = new CarConsumptionComparator();
        cars.sort(carConsComp);
        System.out.println("Sorted cars by fuel consumption:");
        cars.forEach(System.out::println);
        System.out.println();

        /*
            Найти автомобиль в компании, соответствующий заданному диапазону
            параметров скорости.
         */
        int min = 150;
        int max = 250;
        System.out.printf("Cars with max speed between %d and %d:\n", min, max);
        cars.forEach(c -> {
            if (c.getSpeed() > min &&
                    c.getSpeed() < max) {
                System.out.println(c);
            }
        });
    }
}
