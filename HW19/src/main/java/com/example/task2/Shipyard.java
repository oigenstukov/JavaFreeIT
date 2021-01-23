package main.java.com.example.task2;

import java.util.ArrayList;
import java.util.List;

public class Shipyard {
    private int pierNum;
    private int emptyPier;
    private int capacity;
    private int containersNum;
    private List<Thread> ships = new ArrayList<>(capacity);

    public Shipyard(int pierNum, int capacity) {
        if (capacity < 10) {
            System.err.println("Small capacity! Need > 10.");
        }
        this.pierNum = pierNum;
        this.capacity = capacity;
        this.emptyPier = pierNum;
        this.containersNum = capacity - 10;

    }

    public synchronized void enter() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Interrupted exception");
        }

        while (emptyPier < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Interrupted exception!");
            }
        }
        ships.add(Thread.currentThread());
        emptyPier--;
    }

    public synchronized void exit() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Interrupted exception");
        }

        if (ships.contains(Thread.currentThread())) {
            emptyPier++;
        }
        ships.remove(Thread.currentThread());

        System.out.println("Current container's num: " + containersNum);
        System.out.println("Empty piers: " + emptyPier);

        notifyAll();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getContainersNum() {
        return containersNum;
    }

    public int getPierNum() {
        return pierNum;
    }

    public void setContainersNum(int containersNum) {
        this.containersNum = containersNum;
    }
}
