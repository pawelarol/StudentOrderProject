package edu.javaCourse.studentOrder.domian;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class SaveStudentOrder {
    public static void main(String[] args) {
       StudentOrder so = new StudentOrder();
       buildStudentOrder(so.getStudentOrderId());

    }
   public static StudentOrder buildStudentOrder(long id) {
       StudentOrder so = new StudentOrder();
       so.setStudentOrderId(id);

       Adress adress = new Adress("Warsaw","Pulawska","81", "52", "02-595");

       Adult husband = getAdult(id, adress);
       Adult wave = getWave(id, adress);
       Child child = getChild(id, adress);

       so.setHusband(husband);
       so.setWave(wave);
       so.setChild(child);
       return so;
   }

    @NotNull
    private static Child getChild(long id, Adress adress) {
        Child child = new Child("Arol", "Oleg","Pavlovich", "3", "male", LocalDate.of(2020,4,1));
        child.setPlaceOfBirth("Belarus, Grodno");
        child.setPassportSeria("3000");
        child.setPassportNumber(" " +("300000" + id));
        child.setIssueDatePassport(LocalDate.of(2023,1,3));
        child.setIssueDepartament("ROVD Grodno" + id);
        child.setCertificateNumber("" + (30 + id));
        child.setIssueDate(LocalDate.of(2020,4,1));
        child.setIssueDepartment("ЗАГС" + id);
        child.setAdress(adress);
        return child;
    }

    @NotNull
    private static Adult getWave(long id, Adress adress) {
        Adult wave = new Adult("Arol", "Anastasia","Alexandrovna", "20", "female", LocalDate.of(2003,10,25));
        wave.setPlaceOfBirth("Ukraina, Dnepr");
        wave.setPassportSeria("2000");
        wave.setPassportNumber(" " +("20000" + id));
        wave.setIssueDatePassport(LocalDate.of(2023,3,1));
        wave.setIssueDepartament("ROVD Dnepr" + id);
        wave.setStudentNumber("" +(200000 + id));
        wave.setUniversity("Polski-Japonski");
        wave.setIssueMarried("ЗАГС города Гродно");
        wave.setMarriageCertificateId("" + (20000002 + id));
        wave.setMarriageDate(LocalDate.of(2023,11,12));
        wave.setAdress(adress);
        return wave;
    }

    @NotNull
    private static Adult getAdult(long id, Adress adress) {
        Adult husband = new Adult("Arol", "Pavel","Sergeevich", "25", "male", LocalDate.of(1998,7,12));
        husband.setPlaceOfBirth("Belarus, Grodno");
        husband.setPassportSeria("1000");
        husband.setPassportNumber(" " +("100000" + id));
        husband.setIssueDatePassport(LocalDate.of(2023,6,30));
        husband.setIssueDepartament("ROVD Grodno" + id);
        husband.setStudentNumber("" +(1000000 + id));
        husband.setUniversity("GGPEK");
        husband.setIssueMarried("ЗАГС города Гродно");
        husband.setMarriageCertificateId("" + (10000000 + id));
        husband.setMarriageDate(LocalDate.of(2023,11,12));
        husband.setAdress(adress);
        return husband;
    }
}
