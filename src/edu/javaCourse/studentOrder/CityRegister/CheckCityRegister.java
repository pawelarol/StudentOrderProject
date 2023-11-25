package edu.javaCourse.studentOrder.CityRegister;

import edu.javaCourse.studentOrder.Exceptions.CityRegisterException;
import edu.javaCourse.studentOrder.Exceptions.TransportException;
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
         CityRegisterItem.CityStatus status = null;
        try {
            CityRegisterResponce ansCity = personChecker.checkPersonInterface(person);
            status = ansCity.isExists() ?
                    CityRegisterItem.CityStatus.YES:
                  CityRegisterItem.CityStatus.NO;
        } catch (CityRegisterException e) {
            e.printStackTrace(System.out);
            status = CityRegisterItem.CityStatus.ERROR;
            error = new CityRegisterItem.CityError(e.getMessage(), e.getErrorCode());
        }catch(TransportException tex){
            tex.printStackTrace(System.out);
            status = CityRegisterItem.CityStatus.ERROR;
            error= new CityRegisterItem.CityError(tex.getMessage(), T_CODE);
        }catch(Exception e){
            e.printStackTrace();
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
