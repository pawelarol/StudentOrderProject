package edu.javaCourse.studentOrder.domian;


import java.util.ArrayList;
import java.util.List;

public class StudentOrder {

    private long studentOrderId;
    private Adult husband;
    private Adult wave;
    private List<Child> children;

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

    public void addChild(List<Child> child) {
        if(children ==null) {
            this.children = new ArrayList<>(5);
        }
        children.addAll(child);
    }
}