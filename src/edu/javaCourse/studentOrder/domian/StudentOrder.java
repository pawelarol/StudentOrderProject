package edu.javaCourse.studentOrder.domian;


public class StudentOrder {

    private long studentOrderId;
    private Adult husband;
    private Adult wave;
    private Child child;

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

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}