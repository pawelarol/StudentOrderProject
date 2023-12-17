package edu.javaCourse.studentOrder.domian;

import java.time.LocalDate;

public class Adult extends Person{
    private String studentNumber;
    private String university;

    public Adult(String firstName, String secondName, String patronymic, LocalDate dateOfBirth){
    super (firstName, secondName, patronymic, dateOfBirth);
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
