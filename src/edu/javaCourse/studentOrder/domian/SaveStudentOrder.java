package edu.javaCourse.studentOrder.domian;


import edu.javaCourse.studentOrder.Exceptions.DaoException;
import edu.javaCourse.studentOrder.dao.DictionaryDaoImpl;
import edu.javaCourse.studentOrder.dao.StudentOrderDaoImpl;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception {
        // searchStreet();
        //searchCountry();
        //searchRegister();
        //   StudentOrder so = buildStudentOrder(10);
        StudentOrderDaoImpl dao = new StudentOrderDaoImpl();
        //  Long l = dao.saveStudentOrder(so);
        //System.out.println(l);
        List<StudentOrder> ordersList = dao.getStudentOrders();
        for (StudentOrder s : ordersList) {
                 System.out.println(s.getStudentOrderId());

        }
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();

        Street street = new Street(5, "Pulawska", "Mokotow");

        Address address = new Address("Warsaw", street, "81", "52", "02-595");

        Adult husband = new Adult("Arol", "Pavel", "Sergeevich", LocalDate.of(1998, 7, 12));
        PassportOffice po = new PassportOffice(1L, "", "");
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
        PassportOffice po1 = new PassportOffice(1L, "", "");
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
        PassportOffice po2 = new PassportOffice(1L, "", "");
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

    private static void searchStreet() throws DaoException {
        List<Street> liststr = new DictionaryDaoImpl().findStreet("a");
        for (Street s : liststr) {
            System.out.println(s.getStreet_name());
        }
    }

    private static void searchRegister() throws DaoException {
        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffice("321098");
        for (PassportOffice p : po) {
            System.out.println(p.getpOfficeName());
        }

        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffice("456789");
        for (RegisterOffice r : ro) {
            System.out.println(r.getRegisterName());
        }
    }

    private static void searchCountry() throws DaoException {
        List<CountryStruct> cs = new DictionaryDaoImpl().findArea("");
        for (CountryStruct c : cs) {
            System.out.println(c.getArea_id() + ":" + c.getArea_name());
        }
        List<CountryStruct> cs1 = new DictionaryDaoImpl().findArea("0200000000");
        for (CountryStruct c : cs1) {
            System.out.println(c.getArea_id() + ":" + c.getArea_name());
        }
        List<CountryStruct> cs2 = new DictionaryDaoImpl().findArea("020010000000");
        for (CountryStruct c : cs2) {
            System.out.println(c.getArea_id() + ":" + c.getArea_name());
        }
        List<CountryStruct> cs3 = new DictionaryDaoImpl().findArea("020010010000");
        for (CountryStruct c : cs3) {
            System.out.println(c.getArea_id() + ":" + c.getArea_name());
        }
    }


}