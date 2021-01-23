package main.java.com.example.task2;

public class Ship extends Thread {
    private int capacity;
    private Shipyard shipyard;
    private int containersOnShip;

    public Ship(String name, int capacity, Shipyard shipyard, int containersOnShip) {
        super(name);
        this.capacity = capacity;
        this.shipyard = shipyard;
        this.containersOnShip = containersOnShip;
    }

    @Override
    public void run() {
        System.out.println("The " + getName() + " sailing to the shipyard.");
        shipyard.enter();
        unloading();
        loading();
        System.out.println("The " + getName() + " sails out of the shipyard.");
        shipyard.exit();
    }

    public synchronized void loading() {
        while (containersOnShip != capacity && shipyard.getContainersNum() != 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Interrupted exception");
            }
            shipyard.setContainersNum(shipyard.getContainersNum() - 1);
            containersOnShip++;
            System.out.println("Container loaded to the " + getName());
        }
    }

    public synchronized void unloading() {
        while (containersOnShip != 0 && shipyard.getContainersNum() != shipyard.getCapacity()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Interrupted exception");
            }
            shipyard.setContainersNum(shipyard.getContainersNum() + 1);
            containersOnShip--;
            System.out.println("Container unloaded from " + getName());
        }
    }

}
