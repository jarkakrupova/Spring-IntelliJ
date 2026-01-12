package cz.vsb.austra.dto.netatmo;

import java.util.List;

public class Place {
    private List<Double> location;
    private String timezone;
    private String country;
    private int altitude;
    private String city;
    private String street;

    // Gettery a settery
    public List<Double> getLocation() { return location; }
    public void setLocation(List<Double> location) { this.location = location; }
    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public int getAltitude() { return altitude; }
    public void setAltitude(int altitude) { this.altitude = altitude; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
}

