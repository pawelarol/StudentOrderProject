package edu.javaCourse.studentOrder.domian;

import java.time.LocalDate;

public class Person {
    protected String firstName;
    protected String secondName;
    protected String patronymic;
    private String age;
    private String gender;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private String passportNumber;
    private String passportSeria;
    private LocalDate issueDatePassport;
    private String issueDepartament;
    private Adress adress;


    public Person(String firstName, String secondName, String patronymic, String age, String gender, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.age = age;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

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

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

}
