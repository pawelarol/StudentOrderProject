package edu.javaCourse.studentOrder.domian;

import java.time.LocalDate;
import java.util.Iterator;

public class SaveStudentOrder {
    public static void main(String[] args) {

    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();

        Adress adress = new Adress("Warsaw", "Pulawska", "81", "52", "02-595");

        Adult husband = new Adult("Arol", "Pavel", "Sergeevich", "25", "male", LocalDate.of(1998, 7, 12));
        husband.setPlaceOfBirth("Belarus, Grodno");
        husband.setPassportSeria("" + (1000 + id ));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDatePassport(LocalDate.of(2023, 6, 30));
        husband.setIssueDepartament("ROVD Grodno" + id);
        husband.setStudentNumber("" + (1000000 + id));
        husband.setUniversity("GGPEK");
        husband.setIssueMarried("ЗАГС города Гродно");
        husband.setMarriageCertificateId("" + (10000000 + id));
        husband.setMarriageDate(LocalDate.of(2023, 11, 12));
        husband.setAdress(adress);

        Adult wave = new Adult("Arol", "Anastasia", "Alexandrovna", "20", "female", LocalDate.of(2003, 10, 25));
        wave.setPlaceOfBirth("Ukraina, Dnepr");
        wave.setPassportSeria("" + (2000 + id));
        wave.setPassportNumber("" + (20000 + id));
        wave.setIssueDatePassport(LocalDate.of(2023, 3, 1));
        wave.setIssueDepartament("ROVD Dnepr" + id);
        wave.setStudentNumber("" + (200000 + id));
        wave.setUniversity("Polski-Japonski");
        wave.setIssueMarried("ЗАГС города Гродно");
        wave.setMarriageCertificateId("" + (20000002 + id));
        wave.setMarriageDate(LocalDate.of(2023, 11, 12));
        wave.setAdress(adress);

        Child child = new Child("Arol", "Oleg", "Pavlovich", "3", "male", LocalDate.of(2020, 4, 1));
        child.setPlaceOfBirth("Belarus, Grodno");
        child.setPassportSeria("" + (3000 + id ));
        child.setPassportNumber("" + (300000 + id));
        child.setIssueDatePassport(LocalDate.of(2023, 1, 3));
        child.setIssueDepartament("ROVD Grodno" + id);
        child.setCertificateNumber("" + (30 + id));
        child.setIssueDate(LocalDate.of(2020, 4, 1));
        child.setIssueDepartment("ЗАГС" + id);
        child.setAdress(adress);

        Child child1 = new Child("Arol", "Victor", "Pavlovich", "3", "male", LocalDate.of(2020, 4, 1));
        child1.setPlaceOfBirth("Belarus, Grodno");
        child1.setPassportSeria("" +(4000 + id));
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