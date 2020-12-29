package task11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class PeopleCreator {
    public static List<People> createPeople(int number) {
        List<People> peopleList = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {

            String name = randomName(5);

            int age = (int) (Math.random() * 80 + 5);

            Sex sex = randomSex();

            peopleList.add(new People(name, age, sex));
        }
        return peopleList;
    }

    private static String firstUpperCase(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    private static String randomName(int nameSize) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String name = new Random().ints(nameSize, 0, alphabet.length())
                .mapToObj(alphabet::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        name = firstUpperCase(name);
        return name;
    }

    private static Sex randomSex() {
        if ((int) (Math.random() * 2) == 1) {
            return Sex.MALE;
        } else {
            return Sex.FEMALE;
        }
    }
}
