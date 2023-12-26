package edu.javaCourse.studentOrder.dao;

import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.Interfaces.StudentOrderDao;
import edu.javaCourse.studentOrder.config.Config;
import edu.javaCourse.studentOrder.domian.*;

import java.sql.*;
import java.time.LocalDateTime;

public class StudentOrderDaoImpl implements StudentOrderDao {

    private static final String INSERT_ORDER = "INSERT INTO jc_student_order(" +
            " student_order_status, student_order_date, h_first_name," +
            " h_second_name, h_patronymic, h_passport_number, h_passport_serial," +
            " h_issue_data_passport, h_issue_department, h_student_number, h_university," +
            " h_city, h_area, h_street, h_building, h_apartment, h_post_code, h_index_street," +
            " w_first_name, w_second_name, w_patronymic, w_passport_number, w_passport_serial, " +
            "w_issue_data_passport, w_issue_department, w_student_number, w_university, w_city," +
            " w_area, w_street, w_building, w_apartment, w_post_code, w_index_street, " +
            "marriage_certificate_id, marriage_date, department_marriage)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    Config.getProperties(Config.DB_URL),
                    Config.getProperties(Config.DB_LOGIN),
                    Config.getProperties(Config.DB_PASSWORD));
            return con;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }


    @Override
    public Long saveStudentOrder(StudentOrder so) throws DaoException {
        long result = -1L;
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_ORDER, new String[]{"student_order_id"})) {
            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));

            Adult husband = so.getHusband();
            setParamsAdult(stmt, 3, husband);

            Address hAddress = husband.getAdress();
            setParamsAddress(stmt, 12, hAddress);

            Adult wife = so.getWife();
            setParamsAdult(stmt, 19, wife);

            Address wAddress = wife.getAdress();
            setParamsAddress(stmt,28,wAddress);

            stmt.setString(35, so.getMarriageCertificateId());
            stmt.setDate(36, java.sql.Date.valueOf(so.getMarriageDate()));
            stmt.setLong(37, so.getDepartmentMarriage().getRegisterId());


            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                result = generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);

        }
        return result;
    }


    private static void setParamsAddress(PreparedStatement stmt, int start, Address address) throws SQLException {
        stmt.setString(start, address.getCity());
        stmt.setString(start + 9, address.getArea());
        stmt.setString(start + 10, address.getStreet().getStreet_name());
        stmt.setString(start + 11, address.getBuilding());
        stmt.setString(start + 12, address.getApartment());
        stmt.setString(start + 13, address.getPostcode());
        stmt.setLong(start + 14, address.getStreet().getStreet_code());
    }

    private static void setParamsAdult(PreparedStatement stmt, int start, Adult adult) throws SQLException {
        stmt.setString(start, adult.getFirstName());
        stmt.setString(start + 1, adult.getSecondName());
        stmt.setString(start + 2, adult.getPatronymic());
        stmt.setString(start + 3, adult.getPassportNumber());
        stmt.setString(start + 4, adult.getPassportSerial());
        stmt.setDate(start + 5, Date.valueOf(adult.getIssueDatePassport()));
        stmt.setLong(start + 6, adult.getIssueDepartment().getpOfficeId());
        stmt.setString(start + 7, adult.getStudentNumber());
        stmt.setString(start + 8, adult.getUniversity());
    }
}
