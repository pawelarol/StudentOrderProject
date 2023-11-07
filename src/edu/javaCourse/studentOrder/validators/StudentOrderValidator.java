package edu.javaCourse.studentOrder.validators;

import edu.javaCourse.studentOrder.Senders.MailSender;
import edu.javaCourse.studentOrder.answers.AnswerChildren;
import edu.javaCourse.studentOrder.answers.AnswerCityRegister;
import edu.javaCourse.studentOrder.answers.AnswerStudents;
import edu.javaCourse.studentOrder.answers.AnswerWedding;
import edu.javaCourse.studentOrder.checks.CheckChildren;
import edu.javaCourse.studentOrder.checks.CheckStudents;
import edu.javaCourse.studentOrder.checks.CheckWedding;
import edu.javaCourse.studentOrder.checks.СheckCityRegister;
import edu.javaCourse.studentOrder.domian.StudentOrder;

public class StudentOrderValidator {
    public static void main(String[] args) {

        checkAll();
    }

    private static void checkAll() {
        while (true){
        StudentOrder so = readStudentOrder();
        if(so == null) {
            break;
        }
        AnswerCityRegister ansCityRegister = checkCityRegister(so);
            if (!ansCityRegister.setSuccses(true)) {
                sendBadMail(so);
                continue;
            }
            checkStudents(so);
            checkWedding(so);
            checkChildren(so);
            sendMail(so);
        }
      }

    private static void sendBadMail(StudentOrder studentOrder) {
        MailSender ms = new MailSender();
        ms.sendBadMail(studentOrder);
    }

    private static StudentOrder readStudentOrder() {
        return new StudentOrder();
    }
    private static void sendMail(StudentOrder studentOrder) {
        MailSender ms = new MailSender();
        ms.sendMail(studentOrder);
    }


    private static AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        СheckCityRegister checkCity = new СheckCityRegister();
       checkCity.setHost("1");
       checkCity.setLogin("CityRegister");
       checkCity.setPassword("12345678");
       AnswerCityRegister ans = checkCity.checkCityRegister(studentOrder);
       return ans;
    }

    private static AnswerChildren checkChildren(StudentOrder studentOrder) {
        CheckChildren checkChild = new CheckChildren();
        checkChild.setHost("2");
        checkChild.setLogin("checkChildren");
        checkChild.setPassword("12345123");
        AnswerChildren ansChildren = checkChild.checkChildren(studentOrder);
        return ansChildren;
    }

    private static AnswerWedding checkWedding(StudentOrder studentOrder) {
       CheckWedding checkWed = new CheckWedding();
       checkWed.setHost("3");
       checkWed.setLogin("CheckWedding");
       checkWed.setPassword("12341234");
        AnswerWedding ansWedding = checkWed.checkWedding(studentOrder);
        return ansWedding;
    }

    private static AnswerStudents checkStudents(StudentOrder studentOrder) {
        CheckStudents checkStud = new CheckStudents();
        checkStud.setHost("4");
        checkStud.setLogin("CheckStudents");
        checkStud.setPassword("12344321");
        AnswerStudents ansStudents = checkStud.checkStudents(studentOrder);
        return ansStudents;
    }
}
