package task04;

import java.util.Objects;
import java.util.function.Predicate;

/*
        Написать программу проверяющую, что строка не null и не пуста, используя
        метод and() функционального интерфейса Predicate.
     */
public class Main {
    public static void main(String[] args) {
        Predicate<String> p1 = Objects::nonNull;
        Predicate<String> p2 = s -> s.length()>0;
        String s = null;

        System.out.println(p1.and(p2).test("Str"));
        System.out.println(p1.and(p2).test(""));
        System.out.println(p1.and(p2).test(s));
    }
}
