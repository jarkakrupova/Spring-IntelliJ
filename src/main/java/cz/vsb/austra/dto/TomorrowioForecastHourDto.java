package cz.vsb.austra.dto;

public class TomorrowioForecastHourDto {
    private String time;
    private Double cloudCover;
    private Double dewPoint;
    private Double humidity;
    private Double temperature;
    private Double temperatureApparent;
    private Integer weatherCode;
    private Double windDirection;
    private Double windGust;
    private Double windSpeed;
    private Integer precipitationProbability;
    private Double pressureSurfaceLevel;
    private Double visibility;
    private Integer snowIntensity;
    private Integer rainIntensity;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTemperatureApparent() {
        return temperatureApparent;
    }

    public void setTemperatureApparent(Double temperatureApparent) {
        this.temperatureApparent = temperatureApparent;
    }

    public Integer getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(Integer weatherCode) {
        this.weatherCode = weatherCode;
    }

    public Double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Double windDirection) {
        this.windDirection = windDirection;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(Integer precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }

    public Double getPressureSurfaceLevel() {
        return pressureSurfaceLevel;
    }

    public void setPressureSurfaceLevel(Double pressureSurfaceLevel) {
        this.pressureSurfaceLevel = pressureSurfaceLevel;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Integer getSnowIntensity() {
        return snowIntensity;
    }

    public void setSnowIntensity(Integer snowIntensity) {
        this.snowIntensity = snowIntensity;
    }

    public Integer getRainIntensity() {
        return rainIntensity;
    }

    public void setRainIntensity(Integer rainIntensity) {
        this.rainIntensity = rainIntensity;
    }
}
