package edu.javaCourse.studentOrder.domian;

public class Street {
    private int street_code;
    private String street_name;
    private String street_area;


    public Street() {

    }

    public Street(int street_code, String street_name, String street_area) {
        this.street_code = street_code;
        this.street_name = street_name;
        this.street_area = street_area;
    }

    public String getStreet_area() {
        return street_area;
    }

    public void setStreet_area(String street_area) {
        this.street_area = street_area;
    }

    public int getStreet_code() {
        return street_code;
    }

    public void setStreet_code(int street_code) {
        this.street_code = street_code;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }
}
