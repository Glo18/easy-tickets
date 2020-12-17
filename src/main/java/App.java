import com.google.gson.Gson;
import dao.Sql2oBookingDao;
import models.Booking;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.post;

public class App {

    public static void main(String[] args) {
        Sql2oBookingDao bookingDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/booking_test";
        Sql2o sql2o = new Sql2o(connectionString, "glory", "myPassword");

        bookingDao = new Sql2oBookingDao(sql2o);
        conn = sql2o.open();

        post("/booking/new", "application/json", (req, res) -> {
            Booking booking = gson.fromJson(req.body(), Booking.class);
            bookingDao.add(booking);
            res.status(201);
            res.type("application/json");
            return gson.toJson(booking);
        });
    }
}
