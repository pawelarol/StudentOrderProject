package edu.javaCourse.studentOrder.domian;

public class Child extends Person{
    private String motherFirstName;
    private String motherSecondName;
    private String motherPatronymic;

    private String fatherFirstName;
    private String fatherSecondName;
    private String fatherPatronymic;

    public String getMotherFirstName() {
        return motherFirstName;
    }

    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

    public String getMotherSecondName() {
        return motherSecondName;
    }

    public void setMotherSecondName(String motherSecondName) {
        this.motherSecondName = motherSecondName;
    }

    public String getMotherPatronymic() {
        return motherPatronymic;
    }

    public void setMotherPatronymic(String motherPatronymic) {
        this.motherPatronymic = motherPatronymic;
    }

    public String getFatherFirstName() {
        return fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

    public String getFatherSecondName() {
        return fatherSecondName;
    }

    public void setFatherSecondName(String fatherSecondName) {
        this.fatherSecondName = fatherSecondName;
    }

    public String getFatherPatronymic() {
        return fatherPatronymic;
    }

    public void setFatherPatronymic(String fatherPatronymic) {
        this.fatherPatronymic = fatherPatronymic;
    }
}
