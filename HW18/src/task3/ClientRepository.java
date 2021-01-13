package task3;

import java.io.*;
import java.util.*;

/*
Создать класс ClientRepository, в котором разместить методы для работы с файлом:..
 */
public class ClientRepository {
    private static final String PATH = "src\\task3\\purchases.txt";
    private static final String PATH2 = "src\\task3\\purchases2.txt";


    /**
     * Get clients from .txt file
     *
     * @return set of clients
     */
    public static Set<Client> getClients() {

        Set<Client> clients = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(PATH)))) {

            Scanner scanner = new Scanner(br);
            while (scanner.hasNextLine()) {

                String[] clientLine = scanner.nextLine().split("[_]+");
                int id = Integer.parseInt(clientLine[0]);
                String name = clientLine[1];
                String email = clientLine[2];
                if (clientLine.length > 3) {
                    List<Purchase> purchases = new ArrayList<>();
                    String[] purchasesArr = clientLine[3].split(", ");
                    for (String s : purchasesArr) {
                        purchases.add(new Purchase(s));
                    }
                    clients.add(new Client(id, name, email, purchases));
                } else {
                    clients.add(new Client(id, name, email));
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    /**
     * Set clients to .txt file
     *
     * @param clients new set of clients
     * @throws IOException if there is no such .txt file
     */
    public static void setClients(Set<Client> clients) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(PATH2));
        clients.stream()
                .sorted(Comparator.comparingInt(Client::getId))
                .forEach(client -> {
                    try {
                        if (client.getPurchaseList() == null) {
                            bw.write(client.getId() + "_" + client.getName() + "_" + client.getEmail() + "_\n");
                        } else {
                            bw.write(client.getId() + "_" + client.getName() + "_" + client.getEmail() + "_"
                                    + client.getPurchaseList()
                                    .toString()
                                    .replaceAll("[\\[\\]]", "") + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        bw.close();
    }

    /**
     * добавить нового покупателя со списком покупок
     *
     * @param name client's name
     * @param email of client
     * @param purchases client's purchase list
     * @throws IOException for setClients
     */
    public static void addClient(String name, String email, List<Purchase> purchases) throws IOException {
        Set<Client> newClients = getClients();
        int newId = newClients.stream()
                .max(Comparator.comparingInt(Client::getId))
                .get()
                .getId() + 1;
        if (purchases.isEmpty()) {
            newClients.add(new Client(newId, name, email));
        } else {
            newClients.add(new Client(newId, name, email, purchases));
        }
        setClients(newClients);
    }

    /**
     * по id покупателя найти список его покупок (учитывать то, что покупателя с нужным id или
     * email может не быть, использовать Optional для возвращаемых значений методов)
     *
     * @param id client's id
     * @return list of client's purchases
     */
    public static Optional<List<Purchase>> getPurchasesById(int id) {
        if (getClients().stream()
                .noneMatch(client -> client.getId() == id)) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(getClients().stream()
                    .filter(client -> client.getId() == id)
                    .findFirst()
                    .get()
                    .getPurchaseList());
        }
    }

    /**
     * по email найти покупателя (учитывать то, что покупателя с нужным id или email может не быть,
     * использовать Optional для возвращаемых значений методов)
     *
     * @param email client's email
     * @return client
     */
    public static Optional<Client> getClientByEmail(String email) {
        if (getClients().stream()
                .noneMatch(client -> client.getEmail().equals(email))) {
            return Optional.empty();
        } else {
            return Optional.of(getClients().stream()
                    .filter(client -> client.getEmail().equals(email))
                    .findFirst()
                    .get());
        }
    }

    public static Optional<Client> getClientById(int id) {
        if (getClients().stream().
                noneMatch(client -> client.getId() == id)) {
            return Optional.empty();
        } else {
            return Optional.of(getClients().stream()
                    .filter(client -> client.getId() == id)
                    .findFirst()
                    .get());
        }
    }

}

