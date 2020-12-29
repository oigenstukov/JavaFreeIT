package L24T04;

import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(maxOf(4, 3, 1));
    }

    /**
     * Напишите метод, находящий максимальное из двух чисел,
     * не используя операторы if-else или любые другие
     * операторы сравнения.
     *
     * @param a values to compare
     * @return max value
     */
    private static int maxOf(int... a) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int i : a) {
            set.add(i);
        }
        return set.last();
    }
}
