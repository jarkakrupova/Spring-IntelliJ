package cz.vsb.austra.dto.openmeteo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HourlyForecastDto {
    @JsonProperty("latitude")
    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    Double latitude;

    @JsonProperty("longitude")
    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    Double longitude;

    @JsonProperty("generationtime_ms")
    public Double getGenerationtime_ms() {
        return this.generationtime_ms;
    }

    public void setGenerationtime_ms(Double generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }

    Double generationtime_ms;

    @JsonProperty("utc_offset_seconds")
    public Integer getUtc_offset_seconds() {
        return this.utc_offset_seconds;
    }

    public void setUtc_offset_seconds(Integer utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }

    Integer utc_offset_seconds;

    @JsonProperty("timezone")
    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    String timezone;

    @JsonProperty("timezone_abbreviation")
    public String getTimezone_abbreviation() {
        return this.timezone_abbreviation;
    }

    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }

    String timezone_abbreviation;

    @JsonProperty("elevation")
    public Double getElevation() {
        return this.elevation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    Double elevation;

    @JsonProperty("hourly_units")
    public HourlyUnits getHourly_units() {
        return this.hourly_units;
    }

    public void setHourly_units(HourlyUnits hourly_units) {
        this.hourly_units = hourly_units;
    }

    HourlyUnits hourly_units;

    @JsonProperty("hourly")
    public Hourly getHourly() {
        return this.hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    Hourly hourly;
}
