package dao;

import models.passenger;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oPassengerDao implements passengerDao{

    private final Sql2o sql2o;

    public Sql2oPassengerDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<passenger> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM passenger") //raw sql
                    .executeAndFetch(passenger.class); //fetch a list
        }
    }




    @Override
    public void add(passenger passenger) {
        String sql = "INSERT INTO passenger (name) VALUES (:name"; //raw sql
        try(Connection con = sql2o.open()){ //try to open a connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .bind(passenger) //map my argument onto the query so we can use information from it
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            passenger.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }




    @Override
    public passenger findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM passenger WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(passenger.class); //fetch an individual item
        }
    }

    @Override
    public void update(int id, String name) {

    }


    @Override
    public void deleteById(int id) {
        String sql = "DELETE from passenger WHERE id=:id";
        try (Connection con = sql2o.open()) {
        con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
        } catch (Sql2oException ex){
        System.out.println(ex);
        }

    }

    @Override
    public void clearAll() {
        String sql = "DELETE from passengers";
        try (Connection con = sql2o.open()) {
        con.createQuery(sql)
        .executeUpdate();
        } catch (Sql2oException ex){
        System.out.println(ex);
        }

    }
}
