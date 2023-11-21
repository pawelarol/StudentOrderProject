package edu.javaCourse.studentOrder.FakeCheckers;

import edu.javaCourse.studentOrder.Exceptions.CityRegisterException;
import edu.javaCourse.studentOrder.Exceptions.TransportException;
import edu.javaCourse.studentOrder.Interfaces.CheckOnePerson;
import edu.javaCourse.studentOrder.domian.Adult;
import edu.javaCourse.studentOrder.domian.Child;
import edu.javaCourse.studentOrder.domian.Person;
import edu.javaCourse.studentOrder.responses.CityRegisterResponce;

public class FakeCheckCityRegister implements CheckOnePerson {

    private static final String rightHusband = "1000";
    private static final String rightWave = "2000";
    private static final String badHusband = "1020";
    private static final String badWave = "2020";
    private static final String ERRORHusband = "1120";
    private static final String ERRORWave = "2120";
    private static final String ERROR_T1 = "1122";
    private static final String ERROR_T2 = "2122";


    public CityRegisterResponce checkPerson(Person person) throws CityRegisterException, TransportException {
         CityRegisterResponce responce = new CityRegisterResponce();
         if(person instanceof Adult){
             Adult adultObject = (Adult) person;
             String passportSeria = adultObject.getPassportSeria();
             if(passportSeria.equals(rightHusband) || passportSeria.equals(rightWave)){
                 responce.setExists(true);
                 responce.setStatusResident(true);
                 if (passportSeria.equals(badHusband) || passportSeria.equals(badWave)){
                     responce.setExists(false);
                 } if(passportSeria.equals(ERRORHusband) || passportSeria.equals(ERRORWave)){
                     CityRegisterException ex = new CityRegisterException("GRN Error" + passportSeria);
                     throw ex;
                 }if (passportSeria.equals(ERROR_T1) || passportSeria.equals(ERROR_T2)){
                     TransportException tex = new TransportException("Transport Error" + passportSeria);
                     throw tex;
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
