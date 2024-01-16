package edu.javaCourse.studentOrder.CityRegister;

import edu.javaCourse.studentOrder.domian.Person;

public class CityRegisterItem {
    public enum CityStatus {
        YES,NO,ERROR;
    }

    public static class CityError{
        private String text;
        private String code;

        public String getText() {
            return text;
        }

        public String getCode() {
            return code;
        }

        public CityError(String text, String code) {
            this.text = text;
            this.code = code;
        }
    }

    private Person person;
    private CityStatus status;
    private CityError error;

    public CityRegisterItem(Person person, CityStatus status) {
        this.person = person;
        this.status = status;
    }

    public CityRegisterItem(Person person, CityStatus status, CityError error) {
        this.person = person;
        this.status = status;
        this.error = error;
    }

    public Person getPerson() {
        return person;
    }

    public CityStatus getStatus() {
        return status;
    }

    public CityError getError() {
        return error;
    }
}
