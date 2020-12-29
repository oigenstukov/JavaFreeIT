package L24T02;

import L24T02.util.SeatType;
import L24T02.util.Time;

import java.util.Map;

/**
 * Пункт назначения, Номер поезда, Время отправления,
 * Число мест (общих, купе, плацкарт, люкс).
 */
public class Train {
    private String departure;
    private String destination;
    private int number;
    private Time time;
    private Map<SeatType, Integer> numberOfSeats;

    public Train() {
    }

    public Train(String departure, String destination, int number, Time time, Map<SeatType, Integer> numberOfSeats) {
        this.departure = departure;
        this.destination = destination;
        this.number = number;
        this.time = time;
        this.numberOfSeats = numberOfSeats;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Map<SeatType, Integer> getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Map<SeatType, Integer> numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return departure + " -> " + destination +
                ", number: " + number +
                ", time: " + time +
                ", numberOfSeats:\n" + numberOfSeats;
    }
}
