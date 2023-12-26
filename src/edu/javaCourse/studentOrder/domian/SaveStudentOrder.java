package edu.javaCourse.studentOrder.domian;


import edu.javaCourse.studentOrder.dao.StudentOrderDaoImpl;

import java.time.LocalDate;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception{
//    List<Street> liststr = new DictionaryDaoImpl().findStreet("a");
//    for ( Street s : liststr){
//        System.out.println(s.getStreet_name());
//    }
//
//    List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffice("321098");
//    for(PassportOffice p : po){
//        System.out.println(p.getpOfficeName());
//    }
//
//        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffice("456789");
//        for(RegisterOffice r : ro){
//            System.out.println( r.getRegisterName());
//        }
//        List <CountryStruct> cs = new DictionaryDaoImpl().findArea("");
//        for(CountryStruct c : cs){
//            System.out.println(c.getArea_id() + ":" + c.getArea_name());
//        }
//        List <CountryStruct> cs1 = new DictionaryDaoImpl().findArea("0200000000");
//        for(CountryStruct c : cs1){
//            System.out.println(c.getArea_id() + ":" + c.getArea_name());
//        }
//        List <CountryStruct> cs2 = new DictionaryDaoImpl().findArea("020010000000");
//        for(CountryStruct c : cs2){
//            System.out.println(c.getArea_id() + ":" + c.getArea_name());
//        }
//        List <CountryStruct> cs3 = new DictionaryDaoImpl().findArea("020010010000");
//        for(CountryStruct c : cs3){
//            System.out.println(c.getArea_id() + ":" + c.getArea_name());
//        }

        StudentOrder so = buildStudentOrder(10);
        StudentOrderDaoImpl dao = new StudentOrderDaoImpl();
        dao.saveStudentOrder(so);

    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();

        Street street = new Street(1L, "Pulawska", "Mokotow");

        Address address = new Address("Warsaw", "Mokotow" ,street, "81", "52", "2");

        Adult husband = new Adult("Arol", "Pavel", "Sergeevich",  LocalDate.of(1998, 7, 12));
       PassportOffice po  = new PassportOffice(1L, "", "");
       husband.setIssueDepartment(po);
        husband.setPassportSerial("" + (1000 + id ));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDatePassport(LocalDate.of(2023, 6, 30));
        husband.setStudentNumber("" + (1000000 + id));
        husband.setUniversity("GGPEK");
        RegisterOffice ro = new RegisterOffice(1L, "", "");
        so.setDepartmentMarriage(ro);
        so.setMarriageCertificateId("" + (10000000 + id));
        so.setMarriageDate(LocalDate.of(2023, 11, 12));
        husband.setAdress(address);

        Adult wave = new Adult("Arol", "Anastasia", "Alexandrovna",  LocalDate.of(2003, 10, 25));
        PassportOffice po1 = new PassportOffice(1L, "", "");
        wave.setIssueDepartment(po1);
        wave.setPassportSerial("" + (2000 + id));
        wave.setPassportNumber("" + (20000 + id));
        wave.setIssueDatePassport(LocalDate.of(2023, 3, 1));
        wave.setStudentNumber("" + (200000 + id));
        wave.setUniversity("Polski-Japonski");
        RegisterOffice ro1 = new RegisterOffice(1L, "", "");
        so.setDepartmentMarriage(ro1);
        so.setMarriageCertificateId("" + (20000002 + id));
        so.setMarriageDate(LocalDate.of(2023, 11, 12));
        wave.setAdress(address);

        Child child = new Child("Arol", "Oleg", "Pavlovich",  LocalDate.of(2020, 4, 1));
        child.setPassportSerial("" + (3000 + id ));
        child.setPassportNumber("" + (300000 + id));
        child.setIssueDatePassport(LocalDate.of(2023, 1, 3));
        PassportOffice po2 = new PassportOffice(1L, "", "");
        child.setIssueDepartment(po2);
        child.setCertificateNumber("" + (30 + id));
        child.setIssueDate(LocalDate.of(2020, 4, 1));
        child.setAdress(address);

        Child child1 = new Child("Arol", "Victor", "Pavlovich",  LocalDate.of(2020, 4, 1));
        child1.setPassportSerial("" +(4000 + id));
        child1.setPassportNumber("" + (400000 + id));
        child1.setIssueDatePassport(LocalDate.of(2023, 1, 3));
        child1.setIssueDepartment(po2);
        child1.setCertificateNumber("" + (30 + id));
        child1.setIssueDate(LocalDate.of(2020, 4, 1));
        child1.setAdress(address);

        so.setStudentOrderId(id);
        so.setHusband(husband);
        so.setWife(wave);
        so.addChild(child);
        so.addChild(child1);
        return so;
    }



}