package edu.javaCourse.studentOrder.domian;

import java.time.LocalDate;

public class Person {
    protected String firstName;
    protected String secondName;
    protected String patronymic;
    private LocalDate dateOfBirth;
    private String passportNumber;
    private String passportSerial;
    private LocalDate issueDatePassport;
    private PassportOffice issueDepartment;
    private RegisterOffice registerDepartment;
    private Address address;


    public Person(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PassportOffice getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(PassportOffice issueDepartment) {
        this.issueDepartment = issueDepartment;
    }

    public LocalDate getIssueDatePassport() {
        return issueDatePassport;
    }

    public void setIssueDatePassport(LocalDate issueDatePassport) {
        this.issueDatePassport = issueDatePassport;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public RegisterOffice getRegisterDepartment() {
        return registerDepartment;
    }

    public void setRegisterDepartment(RegisterOffice registerDepartment) {
        this.registerDepartment = registerDepartment;
    }
}
