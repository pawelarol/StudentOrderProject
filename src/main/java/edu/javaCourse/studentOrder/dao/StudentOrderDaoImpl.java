package edu.javaCourse.studentOrder.dao;

import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.Interfaces.StudentOrderDao;
import edu.javaCourse.studentOrder.config.Config;
import edu.javaCourse.studentOrder.domian.*;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
            " c_issue_date_certificate, c_issue_department, c_register_office)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_ORDERS =
            "SELECT ro.r_office_area_id, ro.r_office_name, " +
                    " po_h.p_office_area_id AS h_p_office_area_id, " +
                    " po_h.p_office_name AS h_p_office_name, " +
                    " po_w.p_office_area_id AS w_p_office_area_id, " +
                    " po_w.p_office_name AS w_p_office_name, " +
                    " so. * FROM jc_student_order so " +
                    "INNER JOIN jc_register_office ro ON ro.r_office_id = so.department_marriage " +
                    "INNER JOIN jc_passport_office po_h ON po_h.p_office_id = so.h_issue_department " +
                    "INNER JOIN jc_passport_office po_w ON po_w.p_office_id = so.w_issue_department " +
                    "WHERE so.student_order_status = ? ORDER BY so.student_order_date LIMIT ?; ";
    private static final String SELECT_CHILD =
            "SELECT soc.*, ro.r_office_area_id, ro.r_office_name " +
                    "FROM jc_child soc " +
                    "INNER JOIN jc_register_office ro ON ro.r_office_id = soc.c_register_office " +
                    "WHERE soc.student_order_id IN ";

    private static final String SELECT_ORDER_FULL =
            "SELECT so.*, ro.r_office_area_id, ro.r_office_name, "+
                    "    po_h.p_office_area_id AS h_p_office_area_id, " +
                    "    po_h.p_office_name AS h_p_office_name, " +
                    "    po_w.p_office_area_id AS w_p_office_area_id, " +
                    "    po_w.p_office_name AS w_p_office_name, " +
                    "    soc.*, " +
                    "    ro_child.r_office_area_id AS child_r_office_area_id, " +
                    "    ro_child.r_office_name AS child_r_office_name " +
                    "FROM jc_student_order so " +
                    "INNER JOIN jc_register_office ro ON ro.r_office_id = so.department_marriage " +
                    "INNER JOIN jc_passport_office po_h ON po_h.p_office_id = so.h_issue_department " +
                    "INNER JOIN jc_child soc ON soc.student_order_id = so.student_order_id " +
                    "INNER JOIN jc_register_office ro_child ON ro_child.r_office_id = soc.c_register_office " +
                    "INNER JOIN jc_passport_office po_w ON po_w.p_office_id = so.w_issue_department " +
                    "WHERE so.student_order_status = ? " +
                    "ORDER BY so.student_order_date LIMIT ?; ";

    private Connection getConnection() throws SQLException {
        return BuilderConnection.getConnect();
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
       return getStudentOrderOneSelect();
      //return getStudentOrderTwoSelect();
    }


    private List<StudentOrder> getStudentOrderOneSelect() throws DaoException {
        List<StudentOrder> result = new LinkedList<>();
        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ORDER_FULL)){
            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            int limit = Integer.parseInt(Config.getProperties(Config.BD_LIMIT));
            stmt.setInt(2, limit);
            Map<Long,StudentOrder> filter = new HashMap<>();
            ResultSet rs = stmt.executeQuery();
            int counter = 0;
            while(rs.next()) {
                Long soID = rs.getLong("student_order_id");
                if (!filter.containsKey(soID)) {
                    StudentOrder so = getFullStudentOrder(rs);
                    result.add(so);
                    filter.put(soID,so);
                    counter++;
                }
                if(counter>=limit){
                    result.remove(result.size()-1);
                }
                StudentOrder so = filter.get(soID);
                so.addChild(fillChild(rs));
            }
            rs.close();
        }catch (SQLException ex){
            throw new DaoException(ex);
        }
        return result;
    }

    @NotNull
    private StudentOrder getFullStudentOrder(ResultSet rs) throws SQLException {
        StudentOrder so = new StudentOrder();
        fillStudentOrder(so, rs);
        fillWedding(so, rs);
        so.setHusband(fillAdult(rs, "h_"));
        so.setWife(fillAdult(rs, "w_"));
        return so;
    }

    @NotNull
    private List<StudentOrder> getStudentOrderTwoSelect() throws DaoException {
        List<StudentOrder> result = new LinkedList<>();
        try(Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(SELECT_ORDERS)){
            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setInt(2, Integer.parseInt(Config.getProperties(Config.BD_LIMIT)));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                StudentOrder so = getFullStudentOrder(rs);
                result.add(so);
            }
             findChildren(con,result);
            rs.close();
        }catch (SQLException ex){
            throw new DaoException(ex);
        }
        return result;
    }

    private void findChildren(Connection con, List<StudentOrder> result) throws SQLException{
        String cl = "(" + result.stream().map(so-> String.valueOf(so.getStudentOrderId())).collect(Collectors.joining(",")) + ")";
        try(PreparedStatement stmt = con.prepareStatement(SELECT_CHILD + cl)){
            ResultSet rs = stmt.executeQuery();
            Map<Long, StudentOrder> maps = result.stream().collect(Collectors.toMap(so -> so.getStudentOrderId(), so -> so));
            while (rs.next()){
                Child child = fillChild(rs);
                StudentOrder so = maps.get(rs.getLong("student_order_id"));
                so.addChild(child);
            }
        }
    }

    private Child fillChild(ResultSet rs) throws SQLException {
        String surName = rs.getString("c_first_name");
        String givenName = rs.getString("c_second_name");
        String patronymic = rs.getString("c_patronymic");
        LocalDate dateOfBirth = rs.getDate("c_date_of_birth").toLocalDate();
        Child child = new Child(surName,givenName,patronymic,dateOfBirth);
        child.setPassportNumber(rs.getString("c_passport_number"));
        child.setPassportSerial(rs.getString("c_passport_serial"));
        child.setIssueDate(rs.getDate("c_issue_data_passport").toLocalDate());
        Address adChild = new Address();
        adChild.setCity(rs.getString("c_city"));
        Street strChild = new Street();
        strChild.setStreet_area(rs.getString("c_area"));
        strChild.setStreet_code(rs.getInt("c_index_street"));
        adChild.setStreet(strChild);
        adChild.setBuilding(rs.getString("c_building"));
        adChild.setApartment(rs.getString("c_apartment"));
        adChild.setPostcode(rs.getString("c_post_code"));
        child.setAddress(adChild);
        child.setCertificateNumber(rs.getString("c_certificate_number"));
        RegisterOffice roChild = new RegisterOffice();
        roChild.setRegisterId(rs.getInt("c_register_office"));
      //  child.setIssueDepartment(roChild);
        return child;
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

        Long poId = rs.getLong("department_marriage");
        String areaId = rs.getString(prefix + "p_office_area_id");
        String area_name = rs.getString(prefix + "p_office_name");
        PassportOffice ro = new PassportOffice(poId, areaId , area_name);
        adult.setIssueDepartment(ro);

        University un = new University(1L, "");
        adult.setStudentNumber(rs.getString(prefix + "student_number"));
        adult.setUniversity(un);

        Address address = new Address();
        Street str = new Street();
        address.setCity(prefix + "city");
        str.setStreet_area(prefix + "area");
        str.setStreet_name(prefix + "street");
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
        String areaID = rs.getString("r_office_area_id");
        String area_name = rs.getString("r_office_name");
        RegisterOffice ro = new RegisterOffice(roID,areaID, area_name);
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
        stmt.setLong(19, child.getRegisterDepartment().getRegisterId());

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

