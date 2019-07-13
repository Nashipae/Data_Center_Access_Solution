package dao;

import java.time.LocalDateTime;
import java.util.List;

import models.Visitor;

public interface VisitorDao {

    //LIST
    List<Visitor> getAll();

    //CREATE
    void add (Visitor visitor);

    //READ
    Visitor findById(int id);


    //UPDATE
    void update(int id, String firstname, String surname, String email, boolean healthAndSafety, String location, String company, LocalDateTime timein, LocalDateTime timeout, String visitReason, String crq, String verifier, boolean approvalStatus, int mobileNo);

    //DELETE
    void deleteById(int id);
    void clearAllVisitors();

}
