package edu.javaCourse.studentOrder.domian;

import java.sql.SQLException;

public enum StudentOrderStatus {
    START,CHECKED,DENIED,APPROVED;

    public  static StudentOrderStatus getStatus(int value) throws SQLException{
       for(StudentOrderStatus sos : StudentOrderStatus.values()){
           if(sos.ordinal() == value){
               return sos;
           }
       } throw new RuntimeException("Unknown value: " + value);
    }
}
