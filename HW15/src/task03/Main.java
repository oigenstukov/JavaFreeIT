package task03;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person pers = new Person("Adam");
        Present pres = new Present("car");
        Present pres1 = new Present("ball");
        List<Present> presents = Arrays.asList(pres,pres1);
        List<String> strings = Arrays.asList("doll", "cookie");

        /*
            Используйте класс в main с разными типами параметров.
         */
        NewYearBox<Present, Integer, Person> box = new NewYearBox<>(presents, 100, pers);
        NewYearBox<String, Double, String> box1 = new NewYearBox<>(strings, 90.50, "Eve");
        System.out.println(box);
        System.out.println(box1);
    }
}
