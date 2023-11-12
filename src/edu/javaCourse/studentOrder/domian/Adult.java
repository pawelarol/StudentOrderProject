package edu.javaCourse.studentOrder.domian;

import java.time.LocalDate;

public class Adult extends Person{
    private String studentNumber;
    private String university;
    private String issueMarried;
    private String marriageCertificateId;
    private LocalDate marriageDate;

    public Adult(String firstName, String secondName, String patronymic, String age, String male, LocalDate dateOfBirth){
    super (firstName, secondName, patronymic, age, male, dateOfBirth);
    }
    public String getIssueMarried() {
        return issueMarried;
    }

    public void setIssueMarried(String issueMarried) {
        this.issueMarried = issueMarried;
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
