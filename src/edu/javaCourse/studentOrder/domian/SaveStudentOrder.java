package edu.javaCourse.studentOrder.domian;

public class SaveStudentOrder {
    public static void main(String[] args) {
       StudentOrder so = new StudentOrder();
       buildStudentOrder(so.getStudentOrderId());

    }
   public static StudentOrder buildStudentOrder(long id){
       StudentOrder so = new StudentOrder();
       so.setStudentOrderId(id);
       return so;
    }
}
