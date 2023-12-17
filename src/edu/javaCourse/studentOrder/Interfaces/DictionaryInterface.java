package edu.javaCourse.studentOrder.Interfaces;

import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.domian.CountryStruct;
import edu.javaCourse.studentOrder.domian.PassportOffice;
import edu.javaCourse.studentOrder.domian.RegisterOffice;
import edu.javaCourse.studentOrder.domian.Street;

import java.util.List;

public interface DictionaryInterface  {
    List<Street> findStreet(String pattern) throws DaoException;
    List<PassportOffice> findPassportOffice(String areaId) throws DaoException;
    List<RegisterOffice> findRegisterOffice(String areaId) throws DaoException;
    List<CountryStruct> findArea(String areaId) throws DaoException;
}
