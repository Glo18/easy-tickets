package models;

import java.util.Objects;

public class Booking {
    private String name;
    private String destination;
    private String travel_class;
    private String food;
    private int number;
    private int tickets;
    private int id;

    public Booking(String name, String destination, String travel_class, String food, int number, int tickets) {
        this.name = name;
        this.destination = destination;
        this.travel_class = travel_class;
        this.food = food;
        this.number = number;
        this.tickets = tickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTravel_class() {
        return travel_class;
    }

    public void setTravel_class(String travel_class) {
        this.travel_class = travel_class;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return number == booking.number &&
                tickets == booking.tickets &&
                id == booking.id &&
                Objects.equals(name, booking.name) &&
                Objects.equals(destination, booking.destination) &&
                Objects.equals(travel_class, booking.travel_class) &&
                Objects.equals(food, booking.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, destination, travel_class, food, number, tickets, id);
    }
}
