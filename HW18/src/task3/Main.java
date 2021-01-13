package task3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/*
Написать класс main с использованием методов класса ClientRepository.
 */
public class Main {
    public static void main(String[] args) {

        ClientRepository.getClients().stream()
                .sorted(Comparator.comparingInt(Client::getId))
                .forEach(System.out::println);

        System.out.println(ClientRepository.getPurchasesById(1));

        System.out.println(ClientRepository.getClientByEmail("angieSun@gmail.com"));
        System.out.println(ClientRepository.getClientByEmail("igor@mail.ru"));

        System.out.println(ClientRepository.getPurchasesById(3));
        System.out.println(ClientRepository.getPurchasesById(5));

        ArrayList<Purchase> newPurchases = new ArrayList<>();
        newPurchases.add(new Purchase("tie"));
        newPurchases.add(new Purchase("hat"));
        try {
            ClientRepository.addClient("James", "brown@jazz.com", newPurchases);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
