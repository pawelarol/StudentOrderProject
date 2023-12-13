package edu.javaCourse.studentOrder.domian;


import edu.javaCourse.studentOrder.dao.DictionaryDaoImpl;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception{
    List<Street> liststr = new DictionaryDaoImpl().findStreet("a");
    for ( Street s : liststr){
        System.out.println(s.getStreet_name());
    }
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();

        Street street = new Street(1, "Pulawska", "Mokotow");

        Adress adress = new Adress("Warsaw", "Mokotow" ,street, "81", "52", "02-595");

        Adult husband = new Adult("Arol", "Pavel", "Sergeevich",  LocalDate.of(1998, 7, 12));
        husband.setPassportSerial("" + (1000 + id ));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDatePassport(LocalDate.of(2023, 6, 30));
        husband.setIssueDepartament("ROVD Grodno" + id);
        husband.setStudentNumber("" + (1000000 + id));
        husband.setUniversity("GGPEK");
        husband.setDepartmentMarriage("ЗАГС города Гродно");
        husband.setMarriageCertificateId("" + (10000000 + id));
        husband.setMarriageDate(LocalDate.of(2023, 11, 12));
        husband.setAdress(adress);

        Adult wave = new Adult("Arol", "Anastasia", "Alexandrovna",  LocalDate.of(2003, 10, 25));
        wave.setPassportSerial("" + (2000 + id));
        wave.setPassportNumber("" + (20000 + id));
        wave.setIssueDatePassport(LocalDate.of(2023, 3, 1));
        wave.setIssueDepartament("ROVD Dnepr" + id);
        wave.setStudentNumber("" + (200000 + id));
        wave.setUniversity("Polski-Japonski");
        wave.setDepartmentMarriage("ЗАГС города Гродно");
        wave.setMarriageCertificateId("" + (20000002 + id));
        wave.setMarriageDate(LocalDate.of(2023, 11, 12));
        wave.setAdress(adress);

        Child child = new Child("Arol", "Oleg", "Pavlovich",  LocalDate.of(2020, 4, 1));
        child.setPassportSerial("" + (3000 + id ));
        child.setPassportNumber("" + (300000 + id));
        child.setIssueDatePassport(LocalDate.of(2023, 1, 3));
        child.setIssueDepartament("ROVD Grodno" + id);
        child.setCertificateNumber("" + (30 + id));
        child.setIssueDate(LocalDate.of(2020, 4, 1));
        child.setIssueDepartment("ЗАГС" + id);
        child.setAdress(adress);

        Child child1 = new Child("Arol", "Victor", "Pavlovich",  LocalDate.of(2020, 4, 1));
        child1.setPassportSerial("" +(4000 + id));
        child1.setPassportNumber("" + (400000 + id));
        child1.setIssueDatePassport(LocalDate.of(2023, 1, 3));
        child1.setIssueDepartament("ROVD Grodno" + id);
        child1.setCertificateNumber("" + (30 + id));
        child1.setIssueDate(LocalDate.of(2020, 4, 1));
        child1.setIssueDepartment("ЗАГС" + id);
        child1.setAdress(adress);

        so.setStudentOrderId(id);
        so.setHusband(husband);
        so.setWave(wave);
        so.addChild(child);
        so.addChild(child1);
        return so;
    }



}