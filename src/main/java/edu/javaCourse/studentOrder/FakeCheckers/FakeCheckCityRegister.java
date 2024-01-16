package edu.javaCourse.studentOrder.FakeCheckers;

import edu.javaCourse.studentOrder.Exceptions.CityRegisterException;
import edu.javaCourse.studentOrder.Exceptions.TransportException;
import edu.javaCourse.studentOrder.Interfaces.CheckOnePerson;
import edu.javaCourse.studentOrder.domian.Adult;
import edu.javaCourse.studentOrder.domian.Child;
import edu.javaCourse.studentOrder.domian.Person;
import edu.javaCourse.studentOrder.responses.CityRegisterResponce;

public class FakeCheckCityRegister implements CheckOnePerson {

    private static final String GOOD_H = "1000";
    private static final String GOOD_W = "2000";
    private static final String BAD_H = "1001";
    private static final String BAD_W = "2001";
    private static final String ERRORH = "1002";
    private static final String ERRORW = "2002";
    private static final String ERROR_T1 = "1003";
    private static final String ERROR_T2 = "2003";

    //почему не работают константы


    public CityRegisterResponce checkPersonInterface(Person person) throws CityRegisterException, TransportException {
        CityRegisterResponce responce = new CityRegisterResponce();
        if (person instanceof Adult) {
            Adult adultObject = (Adult) person;
            String passportSeria = adultObject.getPassportSerial();
            if (passportSeria.equals(GOOD_W) || passportSeria.equals(GOOD_H)) {
                // System.out.println("passport checkPerson" + passportSeria);
                responce.setStatusResident(true);
                responce.setExists(true);
            }

            if (passportSeria.equals(BAD_H) || passportSeria.equals(BAD_W)) {
                responce.setExists(false);
            }

            if (passportSeria.equals(ERRORH) || passportSeria.equals(ERRORW)) {
                CityRegisterException ex = new CityRegisterException("GRN Error" + passportSeria);
                throw ex;
            }

            if (passportSeria.equals(ERROR_T1) || passportSeria.equals(ERROR_T2)) {
                TransportException tex = new TransportException("Transport Error" + passportSeria);
                throw tex;
            }

        }
        if (person instanceof Child) {
            responce.setExists(true);
            responce.setStatusResident(true);
        }

        System.out.println(responce);
        return responce;
    }
}


