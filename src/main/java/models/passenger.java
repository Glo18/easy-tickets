package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class passenger {
    private String name;
    private String origin;
    private String destination;
    private int id;

    public passenger(String name, String origin, String destination) {
        this.name = name;
        this.origin = origin;
        this.destination = destination;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setComing_from(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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
        passenger passenger = (passenger) o;
        return id == passenger.id &&
                Objects.equals(name, passenger.name) &&
                Objects.equals(origin, passenger.origin) &&
                Objects.equals(destination, passenger.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, origin, destination, id);
    }



}
