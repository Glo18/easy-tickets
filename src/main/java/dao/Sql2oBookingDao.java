package dao;

import models.Booking;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oBookingDao implements BookingDao{

    private final Sql2o sql2o;
    public Sql2oBookingDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void add(Booking booking) {
        String sql = "INSERT INTO booking (name, destination, travelClass, food, number, tickets) VALUES (:name, :destination, :travelClass, :food, :number, :tickets)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(booking)
                    .executeUpdate()
                    .getKey();
            booking.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Booking> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM booking")
                    .executeAndFetch(Booking.class);
        }
    }

    @Override
    public List<Booking> getAllNames() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM booking")
//                    .addParameter("restaurantId", restaurantId)
                    .executeAndFetch(Booking.class);
        }
    }


    @Override
    public List<Booking> getAllName() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM booking")
                    .executeAndFetch(Booking.class);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from booking";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
