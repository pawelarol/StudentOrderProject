package edu.javaCourse.studentOrder.domian;

public class StudentOrder extends Adult {


    private String studentOrderId;
    private Adult husband ;
    private String wave;
    private String child;

    public String getDateHusband(){
        return (firstName + " " + secondName + " " + patronymic);
    }


    public String getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(String studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Adult getHusband() {
        return husband;
    }

    public void setHusband(Adult husband) {
        this.husband = husband;
    }

    public String getWave() {
        return wave;
    }

    public void setWave(String wave) {
        this.wave = wave;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }
}