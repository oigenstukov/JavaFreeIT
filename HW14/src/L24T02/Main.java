package L24T02;

import L24T02.util.SeatType;
import L24T02.util.Time;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<SeatType, Integer> trainMap1 = new HashMap<>();
        trainMap1.put(SeatType.COUPE, 24);
        trainMap1.put(SeatType.GENERAL, 124);
        trainMap1.put(SeatType.LUXURY, 6);
        trainMap1.put(SeatType.RESERVED_SEAT, 72);
        Map<SeatType, Integer> trainMap2 = new HashMap<>();
        trainMap2.put(SeatType.COUPE, 48);
        trainMap2.put(SeatType.GENERAL, 124);
        trainMap2.put(SeatType.LUXURY, 0);
        trainMap2.put(SeatType.RESERVED_SEAT, 36);
        Train train1 = new Train("Minsk", "Munich", 1345, new Time(10, 15), trainMap2);
        Train train2 = new Train("Warsaw", "Munich", 2835, new Time(6, 7), trainMap2);
        Train train3 = new Train("Minsk", "Brest", 3126, new Time(23, 20), trainMap1);
        Train train4 = new Train("Warsaw", "Brest", 4347, new Time(19, 42), trainMap1);

        /*
            Создать список объектов.
         */
        List<Train> trains = Arrays.asList(train1, train2, train3, train4);
        trains.forEach(System.out::println);

        /*
            a) список поездов, следующих до заданного пункта назначения;
         */
        System.out.println("a");
        String destination = "Brest";
        for (Train t : trains) {
            if (t.getDestination().equals(destination)) {
                System.out.println(t);
            }
        }

        /*
            b) список поездов, следующих до заданного пункта назначения и
             отправляющихся после заданного часа;
         */
        destination = "Munich";
        System.out.println("\nb");
        Time time = new Time(10, 0);
        for (Train t : trains) {
            if (t.getDestination().equals(destination)) {
                if (t.getTime().getHour() > time.getHour()) {
                    System.out.println(t);
                } else if (t.getTime().getHour() == time.getHour() &&
                        t.getTime().getMinute() > time.getMinute()) {
                    System.out.println(t);
                }
            }
        }

        /*
            c) список поездов, отправляющихся до заданного пункта назначения.
         */
        System.out.println("\nc");
        String departure = "Minsk";
        for (Train t : trains) {
            if (t.getDeparture().equals(departure)) {
                System.out.println(t);
            }
        }
    }
}
