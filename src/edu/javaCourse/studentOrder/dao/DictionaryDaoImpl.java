package edu.javaCourse.studentOrder.dao;

import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.Interfaces.DictionaryInterface;
import edu.javaCourse.studentOrder.domian.Street;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryInterface {

    public static final String GET_STREET = ("SELECT street_code, street_name, street_area FROM" +
            " jc_street WHERE UPPER (street_name) LIKE UPPER(?)");
    private Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/studentOrder",
                    "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public List<Street> findStreet(String pattern)  throws DaoException {
        List<Street> result = new LinkedList<>();
       try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(GET_STREET)){
           stmt.setString(1, "%" + pattern + "%");
           ResultSet rs = stmt.executeQuery();
           while (rs.next()) {
               Street str = new Street(rs.getInt("street_code"),
                       rs.getString("street_name"),
                       rs.getString("street_area"));
               result.add(str);
           }
       }catch (SQLException ex){
           throw new DaoException(ex);
       }
        return result;
    }
}
