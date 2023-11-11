package edu.javaCourse.studentOrder.domian;

import java.time.LocalDate;

public class Person {
    protected String firstName;
    protected String secondName;
    protected String patronymic;
    private int age;
    private String male;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private long passportNumber;
    private long passportSeria;
    private String birthNumber;
    private LocalDate issueDatePassport;
    private String issueDepartament;
    private Adress adress;

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getIssueDepartament() {
        return issueDepartament;
    }

    public void setIssueDepartament(String issueDepartament) {
        this.issueDepartament = issueDepartament;
    }

    public LocalDate getIssueDatePassport() {
        return issueDatePassport;
    }

    public void setIssueDatePassport(LocalDate issueDatePassport) {
        this.issueDatePassport = issueDatePassport;
    }

    public long getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(long passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getBirthNumber() {
        return birthNumber;
    }

    public void setBirthNumber(String birthNumber) {
        this.birthNumber = birthNumber;
    }
}
