package edu.javaCourse.studentOrder.domian;

import java.time.LocalDate;

public class Adult extends Person{
    private University university;
    private String studentNumber;

    public Adult(String firstName, String secondName, String patronymic, LocalDate dateOfBirth){
    super (firstName, secondName, patronymic, dateOfBirth);
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
