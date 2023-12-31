package edu.javaCourse.studentOrder.domian;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentOrder {

    private long studentOrderId;
    private StudentOrderStatus studentOrderStatus;
    private LocalDateTime dateOfApplication;
    private Adult husband;
    private Adult wife;
    private List<Child> children;
    private RegisterOffice departmentMarriage;
    private String marriageCertificateId;
    private LocalDate marriageDate;

    public StudentOrderStatus getStudentOrderStatus() {
        return studentOrderStatus;
    }

    public void setStudentOrderStatus(StudentOrderStatus studentOrderStatus) {
        this.studentOrderStatus = studentOrderStatus;
    }

    public LocalDateTime getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(LocalDateTime dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public RegisterOffice getDepartmentMarriage() {
        return departmentMarriage;
    }

    public void setDepartmentMarriage(RegisterOffice departmentMarriage) {
        this.departmentMarriage = departmentMarriage;
    }

    public String getMarriageCertificateId() {
        return marriageCertificateId;
    }

    public void setMarriageCertificateId(String marriageCertificateId) {
        this.marriageCertificateId = marriageCertificateId;
    }

    public LocalDate getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(LocalDate marriageDate) {
        this.marriageDate = marriageDate;
    }

    public long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Adult getHusband() {
        return husband;
    }

    public void setHusband(Adult husband) {
        this.husband = husband;
    }

    public Adult getWife() {
        return wife;
    }

    public void setWife(Adult wife) {
        this.wife = wife;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void addChild(Child child) {
        if(children ==null) {
            this.children = new ArrayList<>(5);
        }
        children.add(child);
    }

    @Override
            public String toString() {
        return "StudentOrder{" +
                "studentOrderId=" + studentOrderId +
                ", husband=" + husband +
                ", wave=" + wife +
                ", children=" + children +
                '}';
    }

}