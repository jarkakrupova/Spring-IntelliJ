package cz.vsb.austra.dto;

/**
 * Output class for astro data
 */
public class SunMoonAstroDto {
    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;
    private String moon_phase;
    private String dawn;
    private String dusk;
    private String first_light;
    private String last_light;
    private String goldenHour;
    private String dayLength;
    private String timezone;

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

    public String getGoldenHour() {
        return goldenHour;
    }

    public void setGoldenHour(String goldenHour) {
        this.goldenHour = goldenHour;
    }

    public String getDayLength() {
        return dayLength;
    }

    public void setDayLength(String dayLength) {
        this.dayLength = dayLength;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
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

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public String getMoon_phase() {
        return moon_phase;
    }

    public void setMoon_phase(String moon_phase) {
        this.moon_phase = moon_phase;
    }


}
