import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DB;
import dao.Sql2oVisitorDao;
import models.Visitor;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        Sql2oVisitorDao visitorDao = new Sql2oVisitorDao(DB.sql2o);

        ProcessBuilder process = new ProcessBuilder();
        Integer port;


        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4563;
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
            String surname = req.queryParams("surname");
            String email = req.queryParams("email");
            boolean healthAndSafety = Boolean.parseBoolean(req.queryParams("healthAndSafety"));
            String location = req.queryParams("location");
            String company = req.queryParams("company");
            String crq = req.queryParams("crq");
            String visitReason = req.queryParams("visitReason");
            String verifier = req.queryParams("verifier");
//            boolean approvalStatus = Boolean.parseBoolean(req.queryParams("approvalStatus"));
//            int mobileNo = Integer.parseInt("mobileNo");
//            boolean verifyDetails = Boolean.parseBoolean(req.queryParams("verifyDetails"));
            String comments = req.queryParams("comments");
//            Timestamp timein = Timestamp.valueOf(req.queryParams("timein"));
//            Timestamp timeout = Timestamp.valueOf(req.queryParams("timeout"));
            Visitor newVisitor = new Visitor(firstname, surname, email, location, company, healthAndSafety, crq, verifier, comments);
            System.out.println(firstname);
            visitorDao.add(newVisitor);
            model.put("visitors", visitors);
            return new ModelAndView(model, "success.hbs");
//            return null;
        }, new HandlebarsTemplateEngine());
    }



}
