package task03;

import java.util.function.Predicate;

public class Main {
    /*
        Создать лямбда выражение, которое проверяет, что строка не пуста, используя функциональный
        интерфейс Predicate.
     */
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length()>0;
    }
}
