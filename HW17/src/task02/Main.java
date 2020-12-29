package task02;

import java.util.function.Predicate;

    /*
        Создать лямбда выражение, которое возвращает значение true, если строка не null, используя
        функциональный интерфейс Predicate.
     */
public class Main {
    public static void main(String[] args) {
        Predicate p = (s) -> s != null;
    }
}
