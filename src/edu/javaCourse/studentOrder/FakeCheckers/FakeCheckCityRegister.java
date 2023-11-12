package edu.javaCourse.studentOrder.FakeCheckers;

import edu.javaCourse.studentOrder.Interfaces.CheckOnePerson;
import edu.javaCourse.studentOrder.checks.CheckCityRegister;
import edu.javaCourse.studentOrder.domian.Person;
import edu.javaCourse.studentOrder.intermediares.CityRegisterIntermediaries;

public class FakeCheckCityRegister implements CheckOnePerson {
    public CityRegisterIntermediaries checkPerson(Person person){
        return null;
    }
}
