package L24T01;

import L24T01.animals.Parrot;
import L24T01.animals.comparators.ParrotNameComparator;
import L24T01.animals.comparators.ParrotSpeciesComparator;
import L24T01.humans.Doctor;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Использовать иерархию из задания 13.2 (животные).
 */
public class Main {

    public static void main(String[] args) {
        /*
            Использовать в качестве ключа для TreeMap объекты
            класса Parrot. В качестве значения использовать объекты
            класса Doctor.
         */
        Parrot parrot1 = new Parrot("Kesha", 6, "Cockatoo", true);
        Parrot parrot2 = new Parrot("Arnold", 2, "Amazon", true);
        Parrot parrot3 = new Parrot("Mike", 20, "African Grey", false);
        Parrot parrot4 = new Parrot("Nick", 26, "Amazon", true);
        Doctor doc1 = new Doctor("Jack", 15);
        Doctor doc2 = new Doctor("Tim", 14);

        Map<Parrot, Doctor> treeMap = new TreeMap<>();
        treeMap.put(parrot1, doc1);
        treeMap.put(parrot2, doc1);
        treeMap.put(parrot3, doc2);
        treeMap.put(parrot4, doc1);

        /*
            Вывести все элементы на экран.
         */
        for(Map.Entry e : treeMap.entrySet()){
            System.out.println(e.getKey()+" "+ e.getValue());

        }

        /*
            Создать второй TreeMap.
         */
        Comparator<Parrot> parrotComparator = new ParrotSpeciesComparator().thenComparing(new ParrotNameComparator());
        Map<Parrot, Doctor> treeMap2 = new TreeMap<>(parrotComparator);
        treeMap2.put(parrot1, doc1);
        treeMap2.put(parrot2, doc1);
        treeMap2.put(parrot3, doc2);
        treeMap2.put(parrot4, doc1);

        /*
            Вывести и его элементы.
         */
        for (Map.Entry p : treeMap2.entrySet()) {
            System.out.println(p.getKey() + " " + p.getValue());
        }

    }
}
