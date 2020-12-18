package dao;

import models.passenger;

import java.util.List;

public interface passengerDao {
    List<passenger> getAll();
    void add(passenger passenger);
    passenger findById(int id);
    void update(int id, String name);
   void deleteById(int id);
   void clearAll();
}
