import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        ProcessBuilder process = new ProcessBuilder();
        Integer port;


        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
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
            List<Engineer> engineers = engineerDao.getAll();
            model.put("engineers", engineers);
            return new ModelAndView(model, "engineer-add-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/engineers", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Engineer> engineers = engineerDao.getAll();
//            int id = Integer.parseInt(request.queryParams("id"));
            int emp_no = Integer.parseInt(request.queryParams("emp_no"));
            String name = request.queryParams("eng-name");
            Engineer newEngineer = new Engineer(name, emp_no);
            System.out.println(name);
            newEngineer.getEngineerDetails();
            return new ModelAndView(model, "engineer-success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
/visitorsdetails