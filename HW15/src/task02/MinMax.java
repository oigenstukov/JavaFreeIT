package task02;

import java.util.Arrays;

/**
 * Написать обобщенный класс MinMax.
 * Элементы в массиве могут быть разного типа (integer,double,long).
 *
 * @param <T> extends Number
 */
public class MinMax<T extends Comparable<T>> {
    /*
        Массив является переменной класса.
     */
    private final T[] array;

    /*
        Массив должен передаваться в класс через конструктор.
     */
    public MinMax(T[] array) {
        this.array = array;
    }

    /**
     * содержит метод для нахождения минимального элемента массива.
     *
     * @return min value
     */
    public T min() {
        T min = array[0];
        for (T t : array) {
            if (min.compareTo(t) > 0) {
                min = t;
            }
        }
        return min;
    }

    /**
     * содержит метод для нахождения максимального элемента массива.
     *
     * @return max value
     */
    public T max() {
        T max = array[0];
        for (T t : array) {
            if (max.compareTo(t) < 0) {
                max = t;
            }
        }
        return max;
    }

    public T[] getArray() {
        return array;
    }

    public MinMax<T> setArray(T[] array) {
        return new MinMax<>(array);
    }

    @Override
    public String toString() {
        return "Array: " + Arrays.toString(array);
    }
}
