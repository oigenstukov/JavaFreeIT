package main.java.com.example.task3;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private static int capacity;
    private static List<Integer> list = new ArrayList<>(capacity);

    public MyList(int capacity) {
        MyList.capacity = capacity;
    }

    public synchronized void del() {
        while (list.size() < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Wait() exception :(");
            }
        }
        int temp = list.get(0);
        list.remove(0);
        System.out.println(temp + " element has been removed.");
        System.out.print("List: ");
        list.forEach(s -> System.out.print(s + " "));
        System.out.println();
        notify();
    }

    public synchronized void add() {
        while (list.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Wait() exception :(");
            }
        }
        int temp = (int) (Math.random() * 101);
        list.add(temp);
        System.out.println(temp + " element has been added.");
        System.out.print("List: ");
        list.forEach(s -> System.out.print(s + " "));
        System.out.println();
        notify();
    }

    public static int getCapacity() {
        return capacity;
    }
}
