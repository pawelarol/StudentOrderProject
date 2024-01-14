package edu.javaCourse.studentOrder.Senders;

import edu.javaCourse.studentOrder.domian.StudentOrder;

public class MailSender  {
   public  void sendBadMail(StudentOrder studentOrder) {
        System.out.println("Bad mail have sent!");
    }

    public void sendMail(StudentOrder studentOrder) {
        System.out.println("Mail have sent!");
    }
}
