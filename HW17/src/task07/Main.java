package task07;

import java.util.function.Function;

/*
    Написать лямбда выражение, которое принимает на вход число и возвращает значение
    “Положительное число”, “Отрицательное число” или  “Ноль”. Используем функциональный
    интерфейс Function.
*/
public class Main {
    public static void main(String[] args) {
        Integer numI = 15;
        Double numD = -0.2;
        Long numL = 0L;
        Function<Number, String> function = number -> {
            if (number == null) {
                return null;
            } else if (number.doubleValue() > 0) {
                return "positive";
            } else if (number.doubleValue() < 0) {
                return "negative";
            } else {
                return "zero";
            }
        };

        System.out.println(function.apply(numI));
        System.out.println(function.apply(numD));
        System.out.println(function.apply(numL));
        System.out.println(function.apply(null));
    }
}
