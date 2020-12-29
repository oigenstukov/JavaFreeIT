package task11;

import java.util.Comparator;
import java.util.List;

/*
    Дана коллекция объектов класса People. Поля класса: name, age, sex.
    a) Получить мужчин-военнообязанных (от 18 до 27 лет)
    b) Получить средний возраст женщин
    c) Получить кол-во потенциально работоспособных людей в выборке (т.е. от 18 лет и
    учитывая что женщины выходят в 55 лет, а мужчина в 60)
    d) Отсортировать коллекцию людей по имени в обратном алфавитном порядке
    e) Получить человека с минимальным возрастом
 */
public class Main {
    public static void main(String[] args) {
        List<People> peopleList = PeopleCreator.createPeople(5);
        peopleList.forEach(System.out::println);

        // a
        System.out.println("a");
        System.out.print("warriors: ");
        peopleList.stream()
                .filter(s -> s.getSex().equals(Sex.MALE))
                .filter(s -> s.getAge() >= 18 && s.getAge() <= 27)
                .forEach(s -> System.out.println(s.getName() + " "));

        // b
        System.out.println("b");
        System.out.print("Average age: ");
        System.out.println(peopleList.stream()
                .filter(s -> s.getSex().equals(Sex.FEMALE))
                .mapToInt(People::getAge)
                .average()
                .getAsDouble());

        // c
        System.out.println("c");
        long count;
        count = peopleList.stream()
                .filter(s -> s.getSex().equals(Sex.MALE) && s.getAge() >= 18 && s.getAge() <= 60 ||
                        s.getSex().equals(Sex.FEMALE) && s.getAge() >= 18 && s.getAge() <= 55)
                .count();
        System.out.println("able to work: " + count);

        // d
        System.out.println("d");
        System.out.println("in back order:");
        peopleList.stream()
                .sorted(((o1, o2) -> o2.getName().compareTo(o1.getName())))
                .forEach(s -> System.out.print(s.getName() + " "));

        // e
        System.out.println("e");
        System.out.print("The youngest: ");
        System.out.println(peopleList.stream()
                .min(Comparator.comparingInt(People::getAge))
                .get()
                .toString());
    }
}

