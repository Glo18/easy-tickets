
import dao.passengerDao;
import models.passenger;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/tasks/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            passenger.clearAll(); //change
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/passenger/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPassengerToDelete = Integer.parseInt(req.params("id"));
            passenger deletePassenger = passenger.findById(idOfPassenegerToDelete); //change
            deletePassenger.deletePassenger();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<passenger> passenger = passenger.getAll(); //change
            model.put("passenger", passenger);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/passenger/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "passenger-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/passenger", (req, res) -> { //URL to make new task on POST route
            Map<String, Object> model = new HashMap<>();
            String description = req.queryParams("name");
            passenger newPassenger = new passenger(name); //change
            passengerDao.add(newPassenger);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

    }

}
