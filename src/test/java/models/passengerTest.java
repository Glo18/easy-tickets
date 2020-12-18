package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class passengerTest {

    @Test
    public void NewTaskObjectGetsCorrectlyCreated_true() throws Exception {
        passenger passenger = setupNewPassenger();
        assertEquals(true, passenger instanceof passenger);
    }

    @Test
    public void PassengerInstantiatesWithName_true() throws Exception {
        passenger passenger = setupNewPassenger();
        assertEquals("", passenger.getName());
    }

    @Test
    public void hasLeftFalseAfterInstantiation() throws Exception {
        passenger passenger = setupNewPassenger();
        assertEquals(false, passenger.getOrigin()); //should never start as completed
    }

    @Test
    public void hasArrivedAfterSometime() throws Exception {
        passenger passenger = setupNewPassenger();
        assertEquals(true, passenger.getDestination());
    }

    //helper methods
    public passenger setupNewPassenger(){
        return new passenger("");
    }
}