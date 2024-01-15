package edu.javaCourse.studentOrder.Interfaces;

import edu.javaCourse.studentOrder.Exceptions.CityRegisterException;
import edu.javaCourse.studentOrder.Exceptions.TransportException;
import edu.javaCourse.studentOrder.domian.Person;
import edu.javaCourse.studentOrder.responses.CityRegisterResponce;

public interface CheckOnePerson {
   CityRegisterResponce checkPersonInterface
           (Person person) throws CityRegisterException, TransportException;
}

