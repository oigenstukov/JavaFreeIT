package task08;

import java.util.function.Supplier;

/*
    Написать лямбда выражение, которое возвращает случайное число от 0 до 10. Используем
    функциональный интерфейс Supplier.
 */
public class Main {
    public static void main(String[] args) {
        Supplier<Integer> sup = () -> (int)(Math.random()*11);
        System.out.println(sup.get());
    }
}
