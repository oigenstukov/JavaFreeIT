package task03;

import java.util.List;

/**
 * Напишите параметризованный класс NewYearBox
 *
 * @param <T> list of presents
 * @param <P> price
 * @param <V> owner
 */
public class NewYearBox<T, P, V> {
    private List<T> presents;
    private P price;
    private V owner;

    public NewYearBox(List<T> presents, P price, V owner) {
        this.presents = presents;
        this.price = price;
        this.owner = owner;
    }

    /*
        Реализуйте для класса геттеры, сеттеры и toString.
     */
    public List<T> getPresents() {
        return presents;
    }

    public void setPresents(List<T> presents) {
        this.presents = presents;
    }

    public P getPrice() {
        return price;
    }

    public void setPrice(P price) {
        this.price = price;
    }

    public V getOwner() {
        return owner;
    }

    public void setOwner(V owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "New Year box: " +
                "\npresents: " + presents +
                "\nprice\t" + price +
                "\nowner\t" + owner;
    }
}
