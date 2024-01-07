package edu.javaCourse.studentOrder.dao;

import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.Interfaces.StudentOrderDao;
import edu.javaCourse.studentOrder.config.Config;
import edu.javaCourse.studentOrder.domian.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class StudentOrderDaoImpl implements StudentOrderDao {

    private static final String INSERT_ORDER = "INSERT INTO public.jc_student_order(" +
            "student_order_status, student_order_date, h_first_name," +
            " h_second_name, h_patronymic, h_date_of_birth, h_passport_number," +
            " h_passport_serial, h_issue_data_passport, h_issue_department," +
            " h_student_number, h_university_id, h_city," +
            " h_area, h_street, h_building, h_apartment, h_post_code, " +
            "h_index_street, w_first_name, w_second_name, w_patronymic," +
            " w_date_of_birth, w_passport_number, w_passport_serial," +
            " w_issue_data_passport, w_issue_department, w_student_number," +
            " w_university_id, w_city, w_area, w_street," +
            " w_building, w_apartment, w_post_code, w_index_street," +
            " marriage_certificate_id, marriage_date, department_marriage)" +
            "VALUES (?, ?, ?," +
            " ?, ?, ?, ?, " +
            "?, ?, ?," +
            " ?, ?, ?," +
            " ?, ?, ?, ?, ?," +
            " ?, ?, ?, ?," +
            " ?, ?, ?," +
            " ?, ?, ?, " +
            "?, ?, ?, ?," +
            " ?, ?, ?, ?, " +
            "?, ?, ?);";

    private static final String INSERT_CHILD = "INSERT INTO jc_child(" +
            "student_order_id, c_first_name, c_second_name, c_patronymic," +
            " c_date_of_birth, c_passport_number, c_passport_serial," +
            " c_issue_data_passport, c_city, c_area, c_street, c_building," +
            " c_apartment, c_post_code, c_index_street, c_certificate_number," +
            " c_issue_date_certificate, c_issue_department)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_ORDERS = "SELECT * FROM jc_student_order " +
            "WHERE student_order_status = 0 ORDER BY student_order_date";

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
            stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));

            setParamsForAdult(stmt, 3, so.getHusband());
            setParamsForAdult(stmt, 20, so.getWife());

            stmt.setString(37, so.getMarriageCertificateId());
            stmt.setDate(38, Date.valueOf(so.getMarriageDate()));
            stmt.setLong(39, so.getDepartmentMarriage().getRegisterId());

            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                result = generatedKeys.getLong(1);
            }

            saveChildren(con, so, result);
        } catch (SQLException e) {
            throw new DaoException(e);

        }
        return result;
    }

    @Override
    public List<StudentOrder> getStudentOrders() throws DaoException {
        List<StudentOrder> result = new LinkedList<>();
        try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(SELECT_ORDERS)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                StudentOrder so = new StudentOrder();
                fillStudentOrder(so, rs);
                fillWedding(so,rs);
               Adult husband =  fillAdult(rs, "h_");
                Adult wife = fillAdult(rs,"w_");
                so.setHusband(husband);
                so.setWife(wife);
                result.add(so);
            }
            rs.close();
        }catch (SQLException ex){
            throw new DaoException(ex);
        }
        return result;
    }

    private Adult fillAdult(ResultSet rs, String prefix) throws SQLException {
         Adult adult = new Adult();
         adult.setFirstName(rs.getString(prefix + "first_name"));
        adult.setSecondName(rs.getString(prefix + "second_name"));
        adult.setPatronymic(rs.getString(prefix + "patronymic"));
        adult.setFirstName(rs.getString(prefix + "first_name"));
        adult.setDateOfBirth(rs.getDate(prefix + "date_of_birth").toLocalDate());
        adult.setPassportNumber(rs.getString(prefix + "passport_number"));
        adult.setPassportSerial(rs.getString(prefix + "passport_serial"));
        adult.setIssueDatePassport(rs.getDate(prefix + "issue_data_passport").toLocalDate());

        PassportOffice ro = new PassportOffice(1L, "", "");
        ro.getpOfficeId();
        adult.setIssueDepartment(ro);

        University un = new University(1L, "");
        adult.setStudentNumber(rs.getString(prefix + "student_number"));
        adult.setUniversity(un);

        Address address = new Address();
        Street str = new Street();
        address.setCity(prefix + "city");
        address.setStreet(str);
        address.setBuilding(rs.getString(prefix + "building"));
        address.setApartment(rs.getString(prefix + "apartment"));
        address.setPostcode(rs.getString(prefix + "post_code"));
        return adult;
    }

    private void fillWedding(StudentOrder so, ResultSet rs) throws SQLException{
        so.setMarriageCertificateId(rs.getString("marriage_certificate_id"));
        so.setMarriageDate(rs.getDate("marriage_date").toLocalDate());

        Long roID = rs.getLong("department_marriage");
        RegisterOffice ro = new RegisterOffice(roID,"", "");
        so.setDepartmentMarriage(ro);
    }

    private static void fillStudentOrder(StudentOrder so, ResultSet rs) throws SQLException {
        so.setStudentOrderId(rs.getLong("student_order_id"));
        so.setDateOfApplication(rs.getTimestamp("student_order_date").toLocalDateTime());
        so.setStudentOrderStatus(StudentOrderStatus.getStatus(rs.getInt("student_order_status")));
    }

    private void saveChildren(Connection con, StudentOrder so, long childID) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement(INSERT_CHILD)) {
            // int counter = 0;
            for (Child child : so.getChildren()) {
                stmt.setLong(1, childID);
                setParamsForChild(stmt, child);
                stmt.addBatch();
                // algorithm for big data
//                //counter++;
//              //  if(counter > 10000){
//                    stmt.executeBatch();
//                    counter = 0;
//                } if (counter >0) {
//                    stmt.executeBatch();
//                }
            }
            stmt.executeBatch();
        }
    }

    private void setParamsForChild(PreparedStatement stmt, Child child) throws SQLException {
        setParamsForPerson(stmt, 2, child);
        stmt.setString(6, child.getPassportNumber());
        stmt.setString(7, child.getPassportSerial());
        stmt.setDate(8, Date.valueOf(child.getIssueDatePassport()));
        setParamsForAddress(stmt, 9, child);
        stmt.setString(16, child.getCertificateNumber());
        stmt.setDate(17, Date.valueOf(child.getIssueDatePassport()));
        stmt.setLong(18, child.getIssueDepartment().getpOfficeId());

    }

    private static void setParamsForAdult(PreparedStatement stmt, int start, Adult adult) throws SQLException {
        setParamsForPerson(stmt, start, adult);
        stmt.setString(start + 4, adult.getPassportNumber());
        stmt.setString(start + 5, adult.getPassportSerial());
        stmt.setDate(start + 6, Date.valueOf(adult.getIssueDatePassport()));
        stmt.setLong(start + 7, adult.getIssueDepartment().getpOfficeId());
        stmt.setString(start + 8, adult.getStudentNumber());
        stmt.setLong(start + 9, adult.getUniversity().getUniversityId());
        setParamsForAddress(stmt, start + 10, adult);
    }

    private static void setParamsForAddress(PreparedStatement stmt, int start, Person person) throws SQLException {
        Address adult_address = person.getAddress();
        stmt.setString(start, adult_address.getCity());
        stmt.setString(start + 1, adult_address.getStreet().getStreet_area());
        stmt.setString(start + 2, adult_address.getStreet().getStreet_name());
        stmt.setString(start + 3, adult_address.getBuilding());
        stmt.setString(start + 4, adult_address.getApartment());
        stmt.setString(start + 5, adult_address.getPostcode());
        stmt.setInt(start + 6, adult_address.getStreet().getStreet_code());
    }

    private static void setParamsForPerson(PreparedStatement stmt, int start, Person person) throws SQLException {
        stmt.setString(start, person.getFirstName());
        stmt.setString(start + 1, person.getSecondName());
        stmt.setString(start + 2, person.getPatronymic());
        stmt.setDate(start + 3, Date.valueOf(person.getDateOfBirth()));
    }
}

