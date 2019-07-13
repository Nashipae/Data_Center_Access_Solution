package models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Visitor {
    private int id;
    private String firstname;
    private String surname;
    private String email;
    private boolean healthAndSafety;
    private String location;
    private String company;
    private LocalDateTime timein;
    private LocalDateTime timeout;
    private String visitReason;
    private String crq;
    private String verifier;
    private boolean verifyDetails;
    private boolean approvalStatus;
    private int mobileNo;
    private String comments;


    public Visitor(String name, int mobileno) {
    }
    public Visitor(String firstname, String surname, String email, boolean healthAndSafety, String location, String company, LocalDateTime timein, LocalDateTime timeout, String visitReason, String crq, String verifier, boolean approvalStatus, int mobileNo,boolean verifyDetails ) {
        this.firstname=firstname;
        this.surname=surname;
        this.email = email;
        this.healthAndSafety = healthAndSafety;
        this.location = location;
        this.company=company;
        this.timein= timein;
        this.timeout = timeout;
        this.visitReason = visitReason;
        this.crq = crq;
        this.verifier = verifier;
        this.approvalStatus = approvalStatus;
        this.mobileNo = mobileNo;
        this.verifyDetails = verifyDetails;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHealthAndSafety() {
        return healthAndSafety;
    }

    public void setHealthAndSafety(boolean healthAndSafety) {
        this.healthAndSafety = healthAndSafety;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDateTime getTimein() {
        return timein;
    }

    public void setTimein(LocalDateTime timein) {
        this.timein = timein;
    }

    public LocalDateTime getTimeout() {
        return timeout;
    }

    public void setTimeout(LocalDateTime timeout) {
        this.timeout = timeout;
    }

    public String getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    public String getCrq() {
        return crq;
    }

    public void setCrq(String crq) {
        this.crq = crq;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public boolean isapprovalStatus() {
        return approvalStatus;
    }

    public void setapprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public boolean isVerifyDetails() {
        return verifyDetails;
    }

    public void setVerifyDetails(boolean verifyDetails) {
        this.verifyDetails = verifyDetails;
    }

    public boolean isApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visitor)) return false;
        Visitor visitor = (Visitor) o;
        return getId() == visitor.getId() &&
                isHealthAndSafety() == visitor.isHealthAndSafety() &&
                isapprovalStatus() == visitor.isapprovalStatus() &&
                getMobileNo() == visitor.getMobileNo() &&
                getFirstname().equals(visitor.getFirstname()) &&
                Objects.equals(getSurname(), visitor.getSurname()) &&
                Objects.equals(getEmail(), visitor.getEmail()) &&
                Objects.equals(getLocation(), visitor.getLocation()) &&
                getCompany().equals(visitor.getCompany()) &&
                Objects.equals(getTimein(), visitor.getTimein()) &&
                Objects.equals(getTimeout(), visitor.getTimeout()) &&
                Objects.equals(getVisitReason(), visitor.getVisitReason()) &&
                Objects.equals(getCrq(), visitor.getCrq()) &&
                getVerifier().equals(visitor.getVerifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstname(), getSurname(), getEmail(), isHealthAndSafety(), getLocation(), getCompany(), getTimein(), getTimeout(), getVisitReason(), getCrq(), getVerifier(), isapprovalStatus(), getMobileNo());
    }
}
