package edu.javaCourse.studentOrder.dao;

import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.domian.*;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentOrderDaoImplTest {

     @BeforeClass
     public static void testString() throws IOException, URISyntaxException, SQLException {
         DBInit.testString();
     }
    @Test
   public void saveStudentOrderTest() throws DaoException {
        StudentOrder so = buildStudentOrder(10);
        Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

    // set expected = DaoException.class()
    @Test()
    public void saveStudentOrderTestError() {
        StudentOrder so = buildStudentOrder(10);
        so.getHusband().setFirstName(null);
        // Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
         assertThrows(DaoException.class, () -> new StudentOrderDaoImpl().saveStudentOrder(so));
    }

    @Test
    public void getStudentOrders() throws DaoException {
        List<StudentOrder> list = new StudentOrderDaoImpl().getStudentOrders();
    }
    public StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();

        Street street = new Street(5, "Pulawska", "Mokotow");

        Address address = new Address("Warsaw", street, "81", "52", "02-595");

        Adult husband = new Adult("Arol", "Pavel", "Sergeevich", LocalDate.of(1998, 7, 12));
        PassportOffice po = new PassportOffice(1L, "010010000000", "");
        husband.setIssueDepartment(po);
        husband.setPassportSerial("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDatePassport(LocalDate.of(2023, 6, 30));
        husband.setStudentNumber("HH1231112");
        husband.setUniversity(new University(1L,""));
        RegisterOffice ro = new RegisterOffice(1L, "", "");
        so.setDepartmentMarriage(ro);
        so.setMarriageCertificateId("" + (10000000 + id));
        so.setMarriageDate(LocalDate.of(2023, 11, 12));
        husband.setAddress(address);

        Adult wife = new Adult("Arol", "Anastasia", "Alexandrovna", LocalDate.of(2003, 10, 25));
        PassportOffice po1 = new PassportOffice(1L, "010010000000", "");
        wife.setIssueDepartment(po1);
        wife.setPassportSerial("" + (2000 + id));
        wife.setPassportNumber("" + (20000 + id));
        wife.setIssueDatePassport(LocalDate.of(2023, 3, 1));
        wife.setStudentNumber("WW1233122");
        wife.setUniversity(new University(2L,""));
        RegisterOffice ro1 = new RegisterOffice(1L, "", "");
        so.setDepartmentMarriage(ro1);
        so.setMarriageCertificateId("" + (20000002 + id));
        so.setMarriageDate(LocalDate.of(2023, 11, 12));
        wife.setAddress(address);

        Child child = new Child("Arol", "Oleg", "Pavlovich", LocalDate.of(2020, 4, 1));
        PassportOffice po2 = new PassportOffice(3L, "010020000000", "");
        RegisterOffice roChild = new RegisterOffice(2L, "", "");
        child.setPassportSerial("" + (3000 + id));
        child.setPassportNumber("" + (300000 + id));
        child.setIssueDatePassport(LocalDate.of(2023, 1, 3));
        child.setIssueDepartment(po2);
        child.setCertificateNumber("" + (30 + id));
        child.setIssueDate(LocalDate.of(2020, 4, 1));
        child.setAddress(address);
        child.setRegisterDepartment(roChild);

        Child child1 = new Child("Arol", "Victor", "Pavlovich", LocalDate.of(2020, 4, 1));
        child1.setPassportSerial("" + (4000 + id));
        child1.setPassportNumber("" + (400000 + id));
        child1.setIssueDatePassport(LocalDate.of(2023, 1, 3));
        child1.setIssueDepartment(po2);
        child1.setCertificateNumber("" + (30 + id));
        child1.setIssueDate(LocalDate.of(2020, 4, 1));
        child1.setAddress(address);
        child1.setRegisterDepartment(roChild);

        so.setStudentOrderId(id);
        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child);
        so.addChild(child1);
        return so;
    }
}