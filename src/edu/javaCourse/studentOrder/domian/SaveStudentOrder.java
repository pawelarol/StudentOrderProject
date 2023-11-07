package edu.javaCourse.studentOrder.domian;

public class SaveStudentOrder {
    public static void main(String[] args) {
       StudentOrder so = new StudentOrder();
       buildStudentOrder();

    }

   public static StudentOrder buildStudentOrder(){
       StudentOrder so = new StudentOrder();
       Adult husband = new Adult();
       husband.setFirstName("Arol");
       so.setHusband(husband);
       return so;
    }
}
