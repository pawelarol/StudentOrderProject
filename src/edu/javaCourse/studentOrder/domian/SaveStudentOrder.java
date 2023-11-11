package edu.javaCourse.studentOrder.domian;

public class SaveStudentOrder {
    public static void main(String[] args) {
       StudentOrder so = new StudentOrder();
       buildStudentOrder();

    }

   public static StudentOrder buildStudentOrder(){
       StudentOrder so = new StudentOrder();
       so.setFirstName("Arol");
       so.setSecondName("Pavel");
       so.patronymic = "Sergeevich";
       String dateHusband = so.getDateHusband();
       System.out.println(dateHusband);
       return so;
    }
}
