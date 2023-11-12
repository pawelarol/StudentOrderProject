package edu.javaCourse.studentOrder.checks;

import edu.javaCourse.studentOrder.FakeCheckers.FakeCheckCityRegister;
import edu.javaCourse.studentOrder.Interfaces.CheckOnePerson;
import edu.javaCourse.studentOrder.RealCheckers.RealCheckCityRegister;
import edu.javaCourse.studentOrder.answers.AnswerCityRegister;
import edu.javaCourse.studentOrder.domian.StudentOrder;
import edu.javaCourse.studentOrder.intermediares.CityRegisterIntermediaries;

public class CheckCityRegister {
    private String host;
    private String login;
    private String password;

    private CheckOnePerson personChecker ;

    public CheckCityRegister(){
        personChecker = new FakeCheckCityRegister();
    }

   public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        try {
           CityRegisterIntermediaries ansInterH = personChecker.checkPerson(studentOrder.getHusband());
           CityRegisterIntermediaries ansInterW = personChecker.checkPerson(studentOrder.getWave());
           CityRegisterIntermediaries ansInterC = personChecker.checkPerson(studentOrder.getChild());
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("CheckCityRegister is running!");
       // System.out.println("Hostname: " + host + "; " + "Login: " + login + "; " + "Password: " + password + "; ");
        AnswerCityRegister ansCityRegister = new AnswerCityRegister();
        ansCityRegister.setSuccses(true);
        return ansCityRegister;
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
