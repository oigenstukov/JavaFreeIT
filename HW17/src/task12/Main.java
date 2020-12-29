package task12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Дана коллекция строк, состоящих из буквы и числа «a1», «a2», «a3», «a1»,... 
    и коллекция строк, состоящих из цифр «1,2,0», «4,5», «1023,231», «34,0», ...
    а) Из первой коллекции убрать первый символ и вернуть массив чисел (int[])
    b) Из второй коллекции получить все числа, перечисленные через запятую
    c) Из второй коллекции получить сумму всех чисел
    d) Получить максимальное значение из всех чисел
    е) Преобразовать первую коллекцию в Map, где первый символ – ключ, второй –
    значение
 */
public class Main {
    public static void main(String[] args) {
        List<String> stringListA = new ArrayList<>();
        stringListA.add("a1");
        stringListA.add("c2");
        stringListA.add("b3");
        stringListA.add("a6");

        List<String> stringListN = new ArrayList<>();
        stringListN.add("1,2,0");
        stringListN.add("4,5");
        stringListN.add("1023,231");
        stringListN.add("34,0");

        // a
        System.out.println("First list to array:");
        int[] array = stringListA.stream()
                .mapToInt(value -> Integer.parseInt(value.substring(1)))
                .toArray();
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // b
        System.out.println("All numbers from the second list: ");
        stringListN.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // c
        System.out.print("Sum of all elements of the second list: ");
        int sum = stringListN.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(sum);

        // d
        System.out.print("Max value: ");
        int max = stringListN.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();
        System.out.println(max);

        // e
        System.out.println("First list to map:");
        Map<String, String> listAToMap = stringListA.stream()
                .collect(Collectors.toMap(o -> o.substring(0, 1), o -> o.substring(1), (o, o2) -> o2));
        for (Map.Entry<String, String> e : listAToMap.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
