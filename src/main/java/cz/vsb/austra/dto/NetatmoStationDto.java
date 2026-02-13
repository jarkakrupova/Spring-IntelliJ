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
    // Měření deště
    private Double rain60min; // Déšť za 60 minut
    private Double rain24h; // Déšť za 24 hodin
    private Double rainLive; // Aktuální déšť
    private String rainTimeutc; // Čas měření deště (UTC)
    // Měření větru
    private Double windStrength; // Síla větru
    private Integer windAngle; // Úhel větru
    private Double gustStrength; // Síla poryvu
    private Double gustAngle; // Úhel poryvu
    private String windTimeutc; // Čas měření větru (UTC)

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

    public Integer getWindAngle() {
        return windAngle;
    }

    public void setWindAngle(Integer windAngle) {
        this.windAngle = windAngle;
    }

    public Double getGustStrength() {
        return gustStrength;
    }

    public void setGustStrength(Double gustStrength) {
        this.gustStrength = gustStrength;
    }

    public Double getGustAngle() {
        return gustAngle;
    }

    public void setGustAngle(Double gustAngle) {
        this.gustAngle = gustAngle;
    }

    public String getWindTimeutc() {
        return windTimeutc;
    }

    public void setWindTimeutc(String windTimeutc) {
        this.windTimeutc = windTimeutc;
    }
}
