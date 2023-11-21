package edu.javaCourse.studentOrder.CityRegister;

import edu.javaCourse.studentOrder.Exceptions.CityRegisterException;
import edu.javaCourse.studentOrder.FakeCheckers.FakeCheckCityRegister;
import edu.javaCourse.studentOrder.Interfaces.CheckOnePerson;
import edu.javaCourse.studentOrder.domian.Child;
import edu.javaCourse.studentOrder.domian.Person;
import edu.javaCourse.studentOrder.domian.StudentOrder;
import edu.javaCourse.studentOrder.responses.CityRegisterResponce;

import java.util.List;

public class CheckCityRegister {
    public static final String T_CODE = "T_CODE";
    private String host;
    private String login;
    private String password;

    private CheckOnePerson personChecker ;

    public CheckCityRegister(){
        personChecker = new FakeCheckCityRegister();
    }

   public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
       AnswerCityRegister answerCityRegister = new AnswerCityRegister();
       answerCityRegister.addItem(checkPerson(studentOrder.getHusband()));
       answerCityRegister.addItem(checkPerson(studentOrder.getWave()));
       List<Child> childList = studentOrder.getChildren();
       for (Child child : childList) {
           answerCityRegister.addItem(checkPerson(child));
       }
        System.out.println("CheckCityRegister is running!");
       // System.out.println("Hostname: " + host + "; " + "Login: " + login + "; " + "Password: " + password + "; ");
        return answerCityRegister;
    }

    private CityRegisterItem checkPerson(Person person) {
         CityRegisterItem.CityError error = null;
         CityRegisterItem.StatusCheck status;
        try {
            CityRegisterResponce ansCity = personChecker.checkPerson(person);
            status = ansCity.isExists() ?
                    CityRegisterItem.StatusCheck.YES:
                    CityRegisterItem.StatusCheck.NO;
        } catch (CityRegisterException e) {
            e.printStackTrace(System.out);
            status = CityRegisterItem.StatusCheck.ERROR;
            error = new CityRegisterItem.CityError(e.getMessage(), e.getErrorCode());
        }catch(Exception tex){
            tex.printStackTrace(System.out);
            status = CityRegisterItem.StatusCheck.ERROR;
            error= new CityRegisterItem.CityError(tex.getMessage(), T_CODE);
        }

        CityRegisterItem ans = new CityRegisterItem(person,status,error);
        return ans;
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
