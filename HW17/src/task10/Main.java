package task10;

import java.util.ArrayList;
import java.util.List;

/*
    Задачи на Stream API:
    Дана коллекция строк.
    a) Получить первый элемент коллекции или 0, если коллекция пуста
    b) Получить количество вхождений строки «line1»
    c) Получить последний элемент коллекции или «empty», если коллекция пуста
    d) Получить два элемента коллекции, начиная со второго
    e) Получить все элементы, которые начинаются на букву «а»
    f) Найти существуют ли хоть один «line8» элемент в коллекции
    g) Найти есть ли символ «1» у всех элементов коллекции
    h) Отсортировать коллекцию строк по алфавиту и убрать дубликаты
 */
public class Main {
    public static void main(String[] args) {
        List<String> stringsEmp = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        strings.add("line1");
        strings.add("second");
        strings.add("third");
        strings.add("application");
        strings.add("fifth");
        strings.add("all");
        strings.add("line1");
        strings.add("line8");
        String temp = "";
        long i = 0;

        // a
        temp = stringsEmp.stream().findFirst().orElse("0");
        System.out.println(temp);

        // b
        i = strings.stream().filter((s) -> s.equals("line1")).count();
        System.out.println(i);

        // c
        temp = stringsEmp.stream().reduce((a, b) -> b).orElse("empty");
        System.out.println(temp);

        // d
        System.out.println(strings.stream().skip(1).findFirst().get() + " "
                + strings.stream().skip(2).findFirst().get());

        // e
        strings.stream().filter(s -> s.matches("^a.*"))
                .forEach(s -> System.out.println(s + " "));

        // f
        System.out.println(strings.stream().anyMatch(s -> s.equals("line8")));

        // g
        System.out.println(strings.stream().allMatch(s -> s.matches(".*1.*")));

        // h
        strings.stream().sorted().distinct().forEach(s -> System.out.print(s + " "));
    }
}
