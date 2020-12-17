package dao;

import models.Booking;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import java.sql.Connection;

import static org.junit.Assert.*;

public class Sql2oBookingDaoTest {
      private Connection conn;
      private Sql2oBookingDao bookingDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/booking_test";
        Sql2o sql2o = new Sql2o(connectionString, "glory", "myPassword");
       bookingDao = new Sql2oBookingDao(sql2o);
        conn = (Connection) sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

//    @Test
//    public void name() {
//    }

//    @Test
//    public void clearAll() throws Exception{
//        Booking testBooking= setupBooking();
////        Booking otherBooking = setupBooking();
//        bookingDao.clearAll();
//        assertEquals(0, bookingDao.getAll().size());
//    }
//    public Booking setupBooking() {
//        Booking = new Booking("kim", "nakuru", "VIP", "Juice");
//        bookingDao.add(booking);
//        return booking;
//    }
}