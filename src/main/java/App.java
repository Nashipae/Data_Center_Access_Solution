import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DB;
import dao.Sql2OVisitorDao;
import models.Visitor;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import dao.VisitorDao;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        Sql2OVisitorDao visitorDao = new Sql2OVisitorDao(DB.sql2o);

        ProcessBuilder process = new ProcessBuilder();
        Integer port;


        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4569;
        }
        port(port);


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

//
//        get("/dashboard.hbs", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "dashboard.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/guard-details-addition-form.hbs", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "guard-details-addition-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/visitors_table.hbs", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "visitors_table.hbs");
//        }, new HandlebarsTemplateEngine());

        get("/visitor/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Visitor> visitors = visitorDao.getAll();
            model.put("visitors", visitors);
            return new ModelAndView(model, "guard-details-addition-form.hbs");
        }, new HandlebarsTemplateEngine());

//        post("/visitors", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            List<Visitor> visitors = visitorDao.getAll();
//            int mobileno = Integer.parseInt(request.queryParams("mobileno"));
//            String firstname = request.queryParams("firstname");
////            boolean verifydetails = Boolean.parseBoolean(request.queryParams("verifydetails"));
//            Visitor newVisitor = new Visitor(firstname, mobileno);
//            System.out.println(firstname);
//            visitorDao.add(newVisitor);
////            newVisitor.getCrq();
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());


        //post: process new Visitor form
        post("/visitors", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Visitor> visitors = visitorDao.getAll();
            String firstname = req.queryParams("firstname");
            int mobileno = Integer.parseInt(req.queryParams("mobileno"));
            Visitor newVisitor = new Visitor(firstname, mobileno);
            System.out.println(firstname);
            visitorDao.add(newVisitor);
            return new ModelAndView(model, "success.hbs");
//            return null;
        }, new HandlebarsTemplateEngine());
    }



}
