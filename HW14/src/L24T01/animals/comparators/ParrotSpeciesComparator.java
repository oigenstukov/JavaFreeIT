package L24T01.animals.comparators;

import L24T01.animals.Parrot;

import java.util.Comparator;

/**
 * Написать свой компаратор для класса Parrot
 */

public class ParrotSpeciesComparator implements Comparator<Parrot> {
    public int compare(Parrot o1, Parrot o2) {

        return o1.getSpecies().compareTo(o2.getSpecies());
    }
}
