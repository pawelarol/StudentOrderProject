package edu.javaCourse.studentOrder.domian;

import java.time.LocalDate;

public class Adult extends Person{
    private String studentNumber;
    private String university;


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
