package cz.vsb.austra.dto;

import java.time.LocalDate;

public class WeatherComStationObservationDto {
    private String stationID;
    private LocalDate obsTimeUtc;
    private String obsTimeLocal;
    private String neighborhood;
    private String country;
    private Double solarRadiation;
    private Double lon;
    private Integer updateIntervalMinutes;
    private Double lat;
    private Double uv;
    private Integer windDir;
    private Integer humidity;
    private Integer temp;
    private Integer heatIndex;
    private Integer dewpt;
    private Integer windChill;
    private Integer windSpeed;
    private Integer windGust;
    private Double pressure;
    private Double precipRate;
    private Double precipTotal;
    private Integer elev;

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public LocalDate getObsTimeUtc() {
        return obsTimeUtc;
    }

    public void setObsTimeUtc(LocalDate obsTimeUtc) {
        this.obsTimeUtc = obsTimeUtc;
    }

    public String getObsTimeLocal() {
        return obsTimeLocal;
    }

    public void setObsTimeLocal(String obsTimeLocal) {
        this.obsTimeLocal = obsTimeLocal;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getSolarRadiation() {
        return solarRadiation;
    }

    public void setSolarRadiation(Double solarRadiation) {
        this.solarRadiation = solarRadiation;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Integer getUpdateIntervalMinutes() {
        return updateIntervalMinutes;
    }

    public void setUpdateIntervalMinutes(Integer updateIntegerervalMinutess) {
        this.updateIntervalMinutes = updateIntegerervalMinutess;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }

    public Integer getWindDir() {
        return windDir;
    }

    public void setWindDir(Integer windDir) {
        this.windDir = windDir;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(Integer heatIndex) {
        this.heatIndex = heatIndex;
    }

    public Integer getDewpt() {
        return dewpt;
    }

    public void setDewpt(Integer dewpt) {
        this.dewpt = dewpt;
    }

    public Integer getWindChill() {
        return windChill;
    }

    public void setWindChill(Integer windChill) {
        this.windChill = windChill;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindGust() {
        return windGust;
    }

    public void setWindGust(Integer windGust) {
        this.windGust = windGust;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getPrecipRate() {
        return precipRate;
    }

    public void setPrecipRate(Double precipRate) {
        this.precipRate = precipRate;
    }

    public Double getPrecipTotal() {
        return precipTotal;
    }

    public void setPrecipTotal(Double precipTotal) {
        this.precipTotal = precipTotal;
    }

    public Integer getElev() {
        return elev;
    }

    public void setElev(Integer elev) {
        this.elev = elev;
    }
}
