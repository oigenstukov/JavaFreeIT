package task05;

import java.util.function.Predicate;

    /*
        Написать программу, которая проверяет, что строка начинается буквой “J”или “N” и заканчивается
        “A”. Используем функциональный интерфейс Predicate.
     */
public class Main {
    public static void main(String[] args) {
        Predicate<String> p0 = s -> s.matches("^[J,N].*A");

        Predicate<String> p1 = s -> s.startsWith("J");
        Predicate<String> p2 = s -> s.startsWith("N");
        Predicate<String> p3 = s -> s.endsWith("A");

        System.out.println(p0.test("JoinA"));
        System.out.println(p1.or(p2).and(p3).test("JoinA"));
    }
}
