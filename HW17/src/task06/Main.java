package task06;

import java.util.function.Consumer;

/*
        Написать лямбда выражение, которое принимает на вход объект типа HeavyBox и выводит на
        консоль сообщение “Отгрузили ящик с весом n”. “Отправляем ящик с весом n” Используем
        функциональный интерфейс Consumer и метод по умолчанию andThen.
     */
public class Main {
    public static void main(String[] args) {

        Consumer<HeavyBox> heavyBoxConsumer = heavyBox -> {
            System.out.println("Shipped a box with weight " + heavyBox.weight);
        };
        Consumer<HeavyBox> heavyBoxConsumerSend = heavyBox -> {
            System.out.println("Sent a box with weight " + heavyBox.weight);
        };
        HeavyBox hb = new HeavyBox(50);
        heavyBoxConsumer.andThen(heavyBoxConsumerSend).accept(hb);
    }
}
