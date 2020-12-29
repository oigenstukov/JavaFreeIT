package L24T05;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
          Дана упорядоченная последовательность чисел от 1 до N.
          Из нее удалили одно число, а оставшиеся перемешали.
          Найти удаленное число за 1 проход по массиву (т.е. ыцикл
          for используется только 1 раз).
         */
        Integer[] n = {1,2,3,4,5};  // исходная последовательность
        Integer[] n2 = {1,2,3,5};   // удалили одно число
        Integer[] n21 = {2,1,3,5};  // оставшиеся перемешали.

        for (Integer i : n) {
            if (!Arrays.asList(n21).contains(i)) {  // найденный элемент является пропавшим
                System.out.println(i);
                break;
            }
        }

    }
}
