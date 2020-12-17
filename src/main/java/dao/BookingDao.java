package dao;

import models.Booking;

import java.util.List;

public interface BookingDao {
    void  add(Booking booking);
    List<Booking> getAll();
    List<Booking> getAllNames();

    List<Booking> getAllName();

    void clearAll();

}
