package main.java.com.example.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Shipyard shipyard = new Shipyard(2, 40);
        List<Ship> ships = new ArrayList<>();
        int shipNum = 3;

        for (int i = 0; i < shipNum; i++) {
            ships.add(new Ship("Ship " + i, 10, shipyard, 10));
        }

        for (Ship ship : ships){
            ship.run();
        }

        System.out.println("All ships have finished their task");
    }
}
