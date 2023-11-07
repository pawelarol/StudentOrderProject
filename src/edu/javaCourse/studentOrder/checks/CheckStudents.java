package edu.javaCourse.studentOrder.checks;

import edu.javaCourse.studentOrder.answers.AnswerStudents;
import edu.javaCourse.studentOrder.domian.StudentOrder;

public class CheckStudents {
    private String host;
    private String login;
   private   String password;

    public AnswerStudents checkStudents(StudentOrder studentOrder) {
        System.out.println("edu.javaCourse.studentOrder.validators.checks.CheckStudents is running!");
        AnswerStudents ansStudents = new AnswerStudents();
        return ansStudents;
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
