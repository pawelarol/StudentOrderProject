package edu.javaCourse.studentOrder.Interfaces;

import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.domian.Child;
import edu.javaCourse.studentOrder.domian.StudentOrder;

public interface StudentOrderDao {
    Long saveStudentOrder(StudentOrder so) throws DaoException;
}
