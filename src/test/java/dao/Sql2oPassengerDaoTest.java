package dao;

import models.passenger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oPassengerDaoTest {
    private Sql2oPassengerDao taskDao; //ignore me for now. We'll create this soon.
    private Connection conn; //must be sql2o class conn

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        taskDao = new Sql2oPassengerDao(sql2o); //ignore me for now
        conn = sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }
    @Test
    public void addingPassengerSetsId() throws Exception {
        passenger passenger = new passenger ("jane","","");
        int passengerId = passenger.getId();
        passenger.add(passenger);
        assertNotEquals(passengerId, passenger.getId()); //how does this work?
    }
    @Test
    public void travellingPassengerCanBeFoundById() throws Exception {
        passenger passenger = new passenger ("","","");
        passengerDao.add(passenger); //add to dao (takes care of saving)
        passenger foundPassenger= passengerDao.findById();passenger.getId(); //retrieve
        assertEquals(passenger, foundPassenger); //should be the same
    }

    @Test
    public void addedPassengersAreReturnedFrom_getAll() throws Exception {
        passenger passenger = new passenger ("","","");
        passengerDao.add(passenger);
        assertEquals(1, passengerDao.getAll());
    }

    @Test
    public void noPassengerReturnsEmptyList() throws Exception {
        assertEquals(0, passengerDao.getAll());
    }
}