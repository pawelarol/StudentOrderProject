package edu.javaCourse.studentOrder.domian;

public class Address {
    private String city;
    private Street street;
    private String building;
    private String apartment;
    private String postcode;

    public Address(String city,  Street street, String building, String apartment, String postcode) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
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