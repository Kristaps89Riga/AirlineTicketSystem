package model;

public class Airport {

    private String code;
    private String city;
    private String country;

    public Airport(String code,
                   String city,
                   String country) {

        this.code = code;
        this.city = city;
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}