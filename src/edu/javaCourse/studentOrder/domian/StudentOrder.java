package edu.javaCourse.studentOrder.domian;


public class StudentOrder extends Person{

    private long studentOrderId;
    private Person husband;
    private Person wave;
    private Person child;

    public String getDateChild() {
        return (firstName + " " + secondName + " " + patronymic);
    }

    public String getDateWave() {
        return (firstName + " " + secondName + " " + patronymic);
    }

    public String getDateHusband() {
        return (firstName + " " + secondName + " " + patronymic);
    }


    public long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Person getHusband() {
        return husband;
    }

    public void setHusband(String husband, Person person) {
        this.husband = (Person) person;
    }

    public Person getWave() {
        return wave;
    }

    public void setWave(String wave, Person person) {
        this.wave = (Person) person;
    }

    public Person getChild() {
        return child;
    }

    public void setChild(String child, Person person) {
        this.child = (Person) person;
    }
}