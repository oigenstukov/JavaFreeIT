package task01;

public class Main {

    /*
        Написать лямбда выражение для интерфейса Printable, который содержит один метод void print().
     */
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Printable Interface");
    }
}
