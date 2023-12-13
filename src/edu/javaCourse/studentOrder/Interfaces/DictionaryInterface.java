package edu.javaCourse.studentOrder.Interfaces;

import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.domian.Street;

import java.util.List;

public interface DictionaryInterface  {
    List<Street> findStreet(String pattern) throws DaoException;
}
