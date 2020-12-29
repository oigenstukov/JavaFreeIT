package task02;

public class Main {
    public static void main(String[] args) {
        MinMax<Integer> minMax = new MinMax<>(new Integer[]{1, 2, 3, 5, 4, 2});
        MinMax<Double> minMax1 = new MinMax<>(new Double[]{0.2, 0.3, 0.3, 0.5, 0.1});
        System.out.println(minMax.min());
        System.out.println(minMax1.max());
    }
}
