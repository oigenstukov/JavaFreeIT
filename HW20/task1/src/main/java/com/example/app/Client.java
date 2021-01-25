package task1.src.main.java.com.example.app;

import java.util.List;
import java.util.Objects;

/*
Создать класс Клиент (покупатель)
 */
public class Client {
    private int id;
    private String name;
    private String email;
    private List<Purchase> purchaseList;

    public Client(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Client(int id, String name, String email, List<Purchase> purchaseList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.purchaseList = purchaseList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(name, client.name) &&
                Objects.equals(email, client.email) &&
                Objects.equals(purchaseList, client.purchaseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, purchaseList);
    }

    @Override
    public String toString() {
        return id +
                ", '" + name + '\'' +
                ", " + email +
                " :" + purchaseList;
    }
}
