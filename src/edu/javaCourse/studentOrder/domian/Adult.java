package edu.javaCourse.studentOrder.domian;

import java.time.LocalDate;

public class Adult extends Person{
    private String studentNumber;
    private String university;
    private String departmentMarriage;
    private String marriageCertificateId;
    private LocalDate marriageDate;

    public Adult(String firstName, String secondName, String patronymic, LocalDate dateOfBirth){
    super (firstName, secondName, patronymic, dateOfBirth);
    }
    public String getDepartmentMarriage() {
        return departmentMarriage;
    }

    public void setDepartmentMarriage(String departmentMarriage) {
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

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
