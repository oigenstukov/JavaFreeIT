package task3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/*
Написать класс main с использованием методов класса ClientRepository.
 */
public class Main {
    public static void main(String[] args) {

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.getClients().stream()
                .sorted(Comparator.comparingInt(Client::getId))
                .forEach(client -> ClientRepository.log.info(client.toString()));

        ClientRepository.log.info(clientRepository.getPurchasesById(1).toString());

        ClientRepository.log.info(clientRepository.getClientByEmail("angieSun@gmail.com").toString());
        ClientRepository.log.info(clientRepository.getClientByEmail("igor@mail.ru").toString());

        ClientRepository.log.info(clientRepository.getPurchasesById(3).toString());
        ClientRepository.log.info(clientRepository.getPurchasesById(5).toString());

        ArrayList<Purchase> newPurchases = new ArrayList<>();
        newPurchases.add(new Purchase("tie"));
        newPurchases.add(new Purchase("hat"));
        try {
            clientRepository.addClient("James", "brown@jazz.com", newPurchases);
        } catch (IOException e) {
            ClientRepository.log.error("IOException! " + e);
        }
    }
}
