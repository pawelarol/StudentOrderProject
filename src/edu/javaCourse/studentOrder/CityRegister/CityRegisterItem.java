package edu.javaCourse.studentOrder.CityRegister;

import edu.javaCourse.studentOrder.domian.Person;

public class CityRegisterItem {
    public enum StatusCheck {
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
    }

    private Person person;
    private StatusCheck status;
    private CityError error;

    public CityRegisterItem(Person person, StatusCheck status) {
        this.person = person;
        this.status = status;
    }

    public CityRegisterItem(Person person, StatusCheck status, CityError error) {
        this.person = person;
        this.status = status;
        this.error = error;
    }

    public Person getPerson() {
        return person;
    }

    public StatusCheck getStatus() {
        return status;
    }

    public CityError getError() {
        return error;
    }
}
