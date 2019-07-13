package dao;

import models.Visitor;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.time.LocalDateTime;
import java.util.List;

public class Sql2oVisitorDao implements VisitorDao {
    private final Sql2o sql2o;
    public Sql2oVisitorDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Visitor> getAll() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM visitors")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Visitor.class);
        }
    }

    @Override
    public void add(Visitor visitor) {
        String sql   = "INSERT INTO visitors (firstname, surname, email, location, company, timein, timeout, healthAndSafety, visitReason, crq, verifier, mobileNo, comments)" + "VALUES (:firstname, :surname, :email, :location, :company, now(), now(), :healthAndSafety, :visitReason, :crq, :verifier, :mobileNo, :comments);";
        try(Connection con = DB.sql2o.open()){
            int id  = (int) con.createQuery(sql, true)
                    .bind(visitor)
                    .executeUpdate()
                    .getKey();
            visitor.setId(id);
            System.out.println(sql);
        } catch (Sql2oException ex) {
            System.out.println();
        }
    }

    @Override
    public Visitor findById(int id) {
        return null;
    }

    @Override
    public void update(int id, String firstname, String surname, String email, boolean healthAndSafety, String location, String company, LocalDateTime timein, LocalDateTime timeout, String visitReason, String crq, String verifier, boolean approvalStatus, int mobileNo) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAllVisitors() {

    }
}
