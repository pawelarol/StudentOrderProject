package edu.javaCourse.studentOrder.domian;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentOrder {

    private long studentOrderId;
    private Adult husband;
    private Adult wave;
    private List<Child> children;
    private RegisterOffice departmentMarriage;
    private String marriageCertificateId;
    private LocalDate marriageDate;



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

    public Adult getWave() {
        return wave;
    }

    public void setWave(Adult wave) {
        this.wave = wave;
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
                ", wave=" + wave +
                ", children=" + children +
                '}';
    }
}