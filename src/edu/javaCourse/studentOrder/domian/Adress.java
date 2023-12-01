package edu.javaCourse.studentOrder.domian;

import java.time.LocalDate;

public class Adress {
    private String city;
    private String area;
    private String street;
    private String building;
    private String apartment;
    private String postcode;

    public Adress(String city, String area, String street, String building, String apartment, String postcode) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.postcode = postcode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
