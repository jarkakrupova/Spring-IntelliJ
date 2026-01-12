package cz.vsb.austra.dto;

public class NetatmoStationDto {
    private String id;
    private String city;
    private String street;
    private String lat;
    private String lon;
    private String tempHumModuleId;
    private String presModuleId;
    private Double temperature;
    private Double humidity;
    private Double pressure;
    private String tempHumTimestamp;
    private String presTimestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getTempHumModuleId() {
        return tempHumModuleId;
    }

    public void setTempHumModuleId(String tempHumModuleId) {
        this.tempHumModuleId = tempHumModuleId;
    }

    public String getPresModuleId() {
        return presModuleId;
    }

    public void setPresModuleId(String presModuleId) {
        this.presModuleId = presModuleId;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public String getTempHumTimestamp() {
        return tempHumTimestamp;
    }

    public void setTempHumTimestamp(String tempHumTimestamp) {
        this.tempHumTimestamp = tempHumTimestamp;
    }

    public String getPresTimestamp() {
        return presTimestamp;
    }

    public void setPresTimestamp(String presTimestamp) {
        this.presTimestamp = presTimestamp;
    }
}
