package dao;

import models.Visitor;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.time.LocalDateTime;
import java.util.List;

public class Sql2OVisitorDao implements VisitorDao {

    private final Sql2o sql2o;
    public Sql2OVisitorDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
//    public void add(Visitor visitor) {
//        String sql = "INSERT INTO visitors (firstname, surname, email, location, company, timein, timeout, visitReason, crq, verifier, approvalStatus, mobileNo,verifydetails)" + "VALUES (:firstname, :surname, :email, :location, :company, :timein, :timeout, :visitReason, :crq, :verifier, :approvalStatus, :mobileNo, :verifydetails)";
//        try(Connection con = DB.sql2o.open()){
//            int id = (int) con.createQuery(sql, true)
//                    .bind(visitor)
//                    .executeUpdate()
//                    .getKey();
//            visitor.setId(id);
//            System.out.println(sql);
//        } catch (Sql2oException ex) {
//            System.out.println();
//        }
//    }

    public void add(Visitor visitor) {
//        String sql = "INSERT INTO visitors (firstname, surname, email, location, company, timein, timeout, visitReason, crq, verifier, approvalStatus, mobileNo,verifydetails)" + "VALUES (:firstname, :surname, :email, :location, :company, now(), now(), :visitReason, :crq, :verifier, :approvalStatus, :mobileNo, :verifydetails)";
        String sql   = "INSERT INTO visitors (firstname, timein)" + "VALUES (:firstname, now());";
        try(Connection con = DB.sql2o.open()){
            int id = (int) con.createQuery(sql, true)
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
    public List<Visitor> getAll() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM visitors")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Visitor.class);
        }
    }



    @Override
    public Visitor findById(int id) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM visitors WHERE id = :id")
                    .throwOnMappingFailure(false)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Visitor.class);
        }
    }

   @Override
    public void update(int id, String newFirstName, String newSurname, String newEmail, boolean newHealthAndSafety, String newLocation, String newCompany, LocalDateTime newTimein, LocalDateTime newTimeout, String newVisitReason, String newCrq, String newVerifier, boolean newApprovalStaus, int newMobileNo) {
        String sql = "UPDATE visitors SET (firstname, surname, email, location, company, timein, timeout, visitReason, crq, verifier, approvalStatus, mobileNo, verifydetails) = (:firstname, :surname, :email, :location, :company, :timein, :timeout, :visitReason, :crq, :verifier, :approvalStatus, :mobileNo, :verifydetails) WHERE id=:id";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("firstname", newFirstName)
                    .addParameter("firstname", newSurname)
                    .addParameter("id", id)
                    .addParameter("email", newEmail)
                    .addParameter("crq", newCrq)
                    .addParameter("verifier", newVerifier)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println();
        }
    }


    @Override
    public void deleteById(int id) {
        String sql = "DELETE from engineers WHERE id=:id";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println();
        }
    }

    @Override
    public void clearAllVisitors() {
        String sql = "DELETE from visitors";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println();
        }
    }

}