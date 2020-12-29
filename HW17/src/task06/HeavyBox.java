package task06;

import task01.Printable;

public class HeavyBox implements Printable {
    int weight;

    public HeavyBox(int weight) {
        this.weight = weight;
    }

    @Override
    public void print() {
        System.out.println("Heavy Box " + weight);
    }
}
