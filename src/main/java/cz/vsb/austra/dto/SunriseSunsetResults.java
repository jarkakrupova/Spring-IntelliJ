package cz.vsb.austra.dto;

public class SunriseSunsetResults {
    private String date;
    private String sunrise;
    private String sunset;
    private String first_light;
    private String last_light;
    private String dawn;
    private String dusk;
    private String solar_noon;
    private String golden_hour;
    private String day_length;
    private String timezone;
    private int utc_offset;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getFirst_light() {
        return first_light;
    }

    public void setFirst_light(String first_light) {
        this.first_light = first_light;
    }

    public String getLast_light() {
        return last_light;
    }

    public void setLast_light(String last_light) {
        this.last_light = last_light;
    }

    public String getDawn() {
        return dawn;
    }

    public void setDawn(String dawn) {
        this.dawn = dawn;
    }

    public String getDusk() {
        return dusk;
    }

    public void setDusk(String dusk) {
        this.dusk = dusk;
    }

    public String getSolar_noon() {
        return solar_noon;
    }

    public void setSolar_noon(String solar_noon) {
        this.solar_noon = solar_noon;
    }

    public String getGolden_hour() {
        return golden_hour;
    }

    public void setGolden_hour(String golden_hour) {
        this.golden_hour = golden_hour;
    }

    public String getDay_length() {
        return day_length;
    }

    public void setDay_length(String day_length) {
        this.day_length = day_length;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getUtc_offset() {
        return utc_offset;
    }

    public void setUtc_offset(int utc_offset) {
        this.utc_offset = utc_offset;
    }
}
