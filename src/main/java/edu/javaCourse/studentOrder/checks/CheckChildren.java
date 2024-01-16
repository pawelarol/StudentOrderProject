package edu.javaCourse.studentOrder.checks;

import edu.javaCourse.studentOrder.answers.AnswerChildren;
import edu.javaCourse.studentOrder.domian.StudentOrder;

public class CheckChildren {
   private  String host;
   private String login;
   private String password;

   public AnswerChildren checkChildren(StudentOrder studentOrder) {
        System.out.println("CheckChildren is running!");
        AnswerChildren ansChildren = new AnswerChildren();
        return ansChildren;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
