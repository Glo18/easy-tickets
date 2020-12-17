package dao;

import models.Booking;

import java.util.List;

public interface BookingDao {
    void  add (Booking booking);
    List<Booking> getName();
    void clearAll();

}
