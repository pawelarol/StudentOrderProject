package edu.javaCourse.studentOrder.FakeCheckers;

import edu.javaCourse.studentOrder.Exceptions.CityRegisterException;
import edu.javaCourse.studentOrder.Interfaces.CheckOnePerson;
import edu.javaCourse.studentOrder.checks.CheckCityRegister;
import edu.javaCourse.studentOrder.domian.Adress;
import edu.javaCourse.studentOrder.domian.Adult;
import edu.javaCourse.studentOrder.domian.Child;
import edu.javaCourse.studentOrder.domian.Person;
import edu.javaCourse.studentOrder.intermediares.CityRegisterIntermediaries;

public class FakeCheckCityRegister implements CheckOnePerson {

    private static final String rightHusband = "1000";
    private static final String rightWave = "2000";
    private static final String badHusband = "1020";
    private static final String badWave = "2020";
    private static final String ERRORHusband = "1120";
    private static final String ERRORWave = "2120";


    public CityRegisterIntermediaries checkPerson(Person person) throws CityRegisterException {
         CityRegisterIntermediaries responce = new CityRegisterIntermediaries();
         if(person instanceof Adult){
             Adult t = (Adult) person;
             String passportSeria = t.getPassportSeria();
             if(passportSeria.equals(rightHusband) || passportSeria.equals(rightWave)){
                 responce.setExists(true);
                 responce.setStatusResident(true);
                 if (passportSeria.equals(badHusband) || passportSeria.equals(badWave)){
                     responce.setExists(false);
                 } if(passportSeria.equals(ERRORHusband) || passportSeria.equals(ERRORWave)){
                     CityRegisterException ex = new CityRegisterException("Fake Error");
                     throw ex;
                 }
             }
         }
         if(person instanceof Child){
             responce.setExists(true);
             responce.setStatusResident(true);
         }

        System.out.println(responce);
        return responce;
    }
}
