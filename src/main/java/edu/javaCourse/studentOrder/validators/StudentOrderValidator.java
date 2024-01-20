package edu.javaCourse.studentOrder.validators;

import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.Senders.MailSender;
import edu.javaCourse.studentOrder.answers.AnswerChildren;
import edu.javaCourse.studentOrder.CityRegister.AnswerCityRegister;
import edu.javaCourse.studentOrder.answers.AnswerStudents;
import edu.javaCourse.studentOrder.answers.AnswerWedding;
import edu.javaCourse.studentOrder.checks.CheckChildren;
import edu.javaCourse.studentOrder.checks.CheckStudents;
import edu.javaCourse.studentOrder.checks.CheckWedding;
import edu.javaCourse.studentOrder.CityRegister.CheckCityRegister;
import edu.javaCourse.studentOrder.dao.StudentOrderDaoImpl;
import edu.javaCourse.studentOrder.domian.SaveStudentOrder;
import edu.javaCourse.studentOrder.domian.StudentOrder;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private final CheckCityRegister checkCityRegister;
    private final CheckWedding checkWedding;
    private final CheckChildren checkChildren;
    private final CheckStudents checkStudents;

    private final MailSender mailSender;
    public static void main(String[] args) throws DaoException {
      StudentOrderValidator studVal = new StudentOrderValidator();
      studVal.checkAll();
    }

    public StudentOrderValidator(){
        checkCityRegister = new CheckCityRegister();
        checkWedding = new CheckWedding();
        checkStudents = new CheckStudents();
        checkChildren = new CheckChildren();
        mailSender = new MailSender();
    }
    private void checkAll() throws DaoException {
       List <StudentOrder> arraySo = readStudentOrder();
        for( StudentOrder so :arraySo ){
            checkOneOrder(so);
        }
      }

      public void checkOneOrder(StudentOrder so){
     AnswerCityRegister asnCity =  checkCityRegister(so);
//      AnswerStudents ansStud = checkStudents(so);
//      AnswerWedding ansWedd  = checkWedding(so);
//      AnswerChildren ansChild = checkChildren(so);
//      sendMail(so);
      }

    public List<StudentOrder> readStudentOrder() throws DaoException {
       return new StudentOrderDaoImpl().getStudentOrders();
    }

    private void sendMail(StudentOrder studentOrder) {
      mailSender.sendMail(studentOrder);
    }


    private AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
       checkCityRegister.setHost("1");
       checkCityRegister.setLogin("CityRegister");
       checkCityRegister.setPassword("12345678");
       return  checkCityRegister.checkCityRegister(studentOrder);
    }

    private AnswerChildren checkChildren(StudentOrder studentOrder) {
        checkChildren.setHost("2");
        checkChildren.setLogin("checkChildren");
        checkChildren.setPassword("12345123");
        return checkChildren.checkChildren(studentOrder);
    }

    private  AnswerWedding checkWedding(StudentOrder studentOrder) {
       checkWedding.setHost("3");
       checkWedding.setLogin("CheckWedding");
       checkWedding.setPassword("12341234");
        return checkWedding.checkWedding(studentOrder);
    }

    private  AnswerStudents checkStudents(StudentOrder studentOrder) {
        checkStudents.setHost("4");
        checkStudents.setLogin("CheckStudents");
        checkStudents.setPassword("12344321");
        return checkStudents.checkStudents(studentOrder);
    }
}
