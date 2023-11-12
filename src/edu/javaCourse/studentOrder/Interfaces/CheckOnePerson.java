package edu.javaCourse.studentOrder.Interfaces;

import edu.javaCourse.studentOrder.Exceptions.CityRegisterException;
import edu.javaCourse.studentOrder.answers.AnswerCityRegister;
import edu.javaCourse.studentOrder.domian.Person;
import edu.javaCourse.studentOrder.intermediares.CityRegisterIntermediaries;

public interface CheckOnePerson {
     default CityRegisterIntermediaries checkPerson(Person person) throws CityRegisterException{
        return null;
    }

}
