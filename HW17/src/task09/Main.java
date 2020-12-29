package task09;

import task01.Printable;
import task06.HeavyBox;

/*
    Переделать класс использующий Printable используя ссылку на статический метод.

    Что надо было сделать?
 */
public class Main {
    public static void main(String[] args) {
        Printable printable = System.out::println; // ссылка на статический метод
        printable.print(); // просто выводит пустую строку
        HeavyBox hb = new HeavyBox(2); // HeavyBox implements Printable
        hb.print(); // выводит "Heavy Box " + weight
        Printable hb2 = hb::print; // но это НЕ ссылка на статический метод
        hb2.print(); // то же, что и hb.print()

    }
}
