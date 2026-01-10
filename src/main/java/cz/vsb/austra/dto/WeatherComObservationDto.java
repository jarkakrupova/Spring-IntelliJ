package cz.vsb.austra.dto;

import java.time.LocalDate;

public class WeatherComObservationDto {
    private int cloudCover;
    private String cloudCoverPhrase;
    private String dayOfWeek;
    private int iconCode;
    private int iconCodeExtend;
    private double pressureChange;
    private double pressureMeanSeaLevel;
    private String pressureTendencyTrend;
    private int relativeHumidity;
    private int temperature;
    private int temperatureChange24Hour;
    private int temperatureDewPoint;
    private int temperatureFeelsLike;
    private int temperatureHeatIndex;
    private String uvDescription;
    private int uvIndex;
    private String validTimeLocal;
    private double visibility;
    private int windDirection;
    private String windDirectionCardinal;
    private Double windGust;
    private int windSpeed;
    private String wxPhraseLong;

    public int getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(int cloudCover) {
        this.cloudCover = cloudCover;
    }

    public String getCloudCoverPhrase() {
        return cloudCoverPhrase;
    }

    public void setCloudCoverPhrase(String cloudCoverPhrase) {
        this.cloudCoverPhrase = cloudCoverPhrase;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getIconCode() {
        return iconCode;
    }

    public void setIconCode(int iconCode) {
        this.iconCode = iconCode;
    }

    public int getIconCodeExtend() {
        return iconCodeExtend;
    }

    public void setIconCodeExtend(int iconCodeExtend) {
        this.iconCodeExtend = iconCodeExtend;
    }

    public double getPressureChange() {
        return pressureChange;
    }

    public void setPressureChange(double pressureChange) {
        this.pressureChange = pressureChange;
    }

    public double getPressureMeanSeaLevel() {
        return pressureMeanSeaLevel;
    }

    public void setPressureMeanSeaLevel(double pressureMeanSeaLevel) {
        this.pressureMeanSeaLevel = pressureMeanSeaLevel;
    }

    public String getPressureTendencyTrend() {
        return pressureTendencyTrend;
    }

    public void setPressureTendencyTrend(String pressureTendencyTrend) {
        this.pressureTendencyTrend = pressureTendencyTrend;
    }

    public int getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(int relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperatureChange24Hour() {
        return temperatureChange24Hour;
    }

    public void setTemperatureChange24Hour(int temperatureChange24Hour) {
        this.temperatureChange24Hour = temperatureChange24Hour;
    }

    public int getTemperatureDewPoint() {
        return temperatureDewPoint;
    }

    public void setTemperatureDewPoint(int temperatureDewPoint) {
        this.temperatureDewPoint = temperatureDewPoint;
    }

    public int getTemperatureFeelsLike() {
        return temperatureFeelsLike;
    }

    public void setTemperatureFeelsLike(int temperatureFeelsLike) {
        this.temperatureFeelsLike = temperatureFeelsLike;
    }

    public int getTemperatureHeatIndex() {
        return temperatureHeatIndex;
    }

    public void setTemperatureHeatIndex(int temperatureHeatIndex) {
        this.temperatureHeatIndex = temperatureHeatIndex;
    }

    public String getUvDescription() {
        return uvDescription;
    }

    public void setUvDescription(String uvDescription) {
        this.uvDescription = uvDescription;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getValidTimeLocal() {
        return validTimeLocal;
    }

    public void setValidTimeLocal(String validTimeLocal) {
        this.validTimeLocal = validTimeLocal;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindDirectionCardinal() {
        return windDirectionCardinal;
    }

    public void setWindDirectionCardinal(String windDirectionCardinal) {
        this.windDirectionCardinal = windDirectionCardinal;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWxPhraseLong() {
        return wxPhraseLong;
    }

    public void setWxPhraseLong(String wxPhraseLong) {
        this.wxPhraseLong = wxPhraseLong;
    }
}
