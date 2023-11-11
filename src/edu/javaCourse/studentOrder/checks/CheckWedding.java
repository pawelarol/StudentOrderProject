package edu.javaCourse.studentOrder.checks;

import edu.javaCourse.studentOrder.answers.AnswerWedding;
import edu.javaCourse.studentOrder.domian.StudentOrder;

public class CheckWedding {
    private String host;
   private   String login;
    private String password;

    public AnswerWedding checkWedding(StudentOrder studentOrder) {
        System.out.println("CheckWedding is running!");
        AnswerWedding ansWedding = new AnswerWedding();
        return ansWedding;
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
