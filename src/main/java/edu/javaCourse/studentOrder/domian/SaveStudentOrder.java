package edu.javaCourse.studentOrder.domian;


import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.dao.DictionaryDaoImpl;
import edu.javaCourse.studentOrder.dao.StudentOrderDaoImpl;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception {
        StudentOrderDaoImpl dao = new StudentOrderDaoImpl();
        List<StudentOrder> ordersList = dao.getStudentOrders();
        for (StudentOrder s : ordersList) {
            System.out.println(s.getStudentOrderId());

        }
    }
}