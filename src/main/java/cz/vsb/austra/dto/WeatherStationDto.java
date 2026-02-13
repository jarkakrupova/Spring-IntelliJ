package cz.vsb.austra.dto;

import java.time.LocalDate;

public class WeatherStationDto {
    //Weather.com
    private String stationId;
    private LocalDate obsTimeUtc;
    private String obsTimeLocal;
    private String neighborhood;
    private String country;
    private Double solarRadiation;
    private Double longitude;
    private Integer updateIntervalMinutes;
    private Double latitude;
    private Double uv;
    private Integer windDir;
    private Double temperature;
    private Integer heatIndex;
    private Integer dewpt;
    private Integer windChill;
    private Integer windSpeed;
    private Integer windGust;
    private Double pressure;
    private Double precipRate;
    private Double precipTotal; //od pulnoci
    private Double humidity;

    //Netatmo
    // Měření deště
    private Double rain60min; // Déšť za 60 minut
    private Double rain24h; // Déšť za 24 hodin
    private Double rainLive; // Aktuální déšť
    private String rainTimeutc; // Čas měření deště (UTC)
    // Měření větru
    private Double windStrength; // Síla větru
    private Double gustAngle; // Úhel poryvu

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getUpdateIntervalMinutes() {
        return updateIntervalMinutes;
    }

    public void setUpdateIntervalMinutes(Integer updateIntervalMinutes) {
        this.updateIntervalMinutes = updateIntervalMinutes;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
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

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getRain60min() {
        return rain60min;
    }

    public void setRain60min(Double rain60min) {
        this.rain60min = rain60min;
    }

    public Double getRain24h() {
        return rain24h;
    }

    public void setRain24h(Double rain24h) {
        this.rain24h = rain24h;
    }

    public Double getRainLive() {
        return rainLive;
    }

    public void setRainLive(Double rainLive) {
        this.rainLive = rainLive;
    }

    public String getRainTimeutc() {
        return rainTimeutc;
    }

    public void setRainTimeutc(String rainTimeutc) {
        this.rainTimeutc = rainTimeutc;
    }

    public Double getWindStrength() {
        return windStrength;
    }

    public void setWindStrength(Double windStrength) {
        this.windStrength = windStrength;
    }

    public Double getGustAngle() {
        return gustAngle;
    }

    public void setGustAngle(Double gustAngle) {
        this.gustAngle = gustAngle;
    }
}
