package cz.vsb.austra.dto.openmeteo;

public class HistoricalDailyWeatherDto {
    private String time;
    private int weather_code;
    private double temperature_2m_max;
    private double temperature_2m_min;
    private double temperature_2m_mean;
    private double apparent_temperature_max;
    private double apparent_temperature_min;
    private double apparent_temperature_mean;
    private String sunrise;
    private String sunset;
    private double daylight_duration;
    private double sunshine_duration;
    private double precipitation_sum;
    private double rain_sum;
    private double snowfall_sum;
    private double precipitation_hours;
    private double wind_speed_10m_max;
    private double wind_gusts_10m_max;
    private int wind_direction_10m_dominant;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(int weather_code) {
        this.weather_code = weather_code;
    }

    public double getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public void setTemperature_2m_max(double temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }

    public double getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public void setTemperature_2m_min(double temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }

    public double getTemperature_2m_mean() {
        return temperature_2m_mean;
    }

    public void setTemperature_2m_mean(double temperature_2m_mean) {
        this.temperature_2m_mean = temperature_2m_mean;
    }

    public double getApparent_temperature_max() {
        return apparent_temperature_max;
    }

    public void setApparent_temperature_max(double apparent_temperature_max) {
        this.apparent_temperature_max = apparent_temperature_max;
    }

    public double getApparent_temperature_min() {
        return apparent_temperature_min;
    }

    public void setApparent_temperature_min(double apparent_temperature_min) {
        this.apparent_temperature_min = apparent_temperature_min;
    }

    public double getApparent_temperature_mean() {
        return apparent_temperature_mean;
    }

    public void setApparent_temperature_mean(double apparent_temperature_mean) {
        this.apparent_temperature_mean = apparent_temperature_mean;
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

    public double getDaylight_duration() {
        return daylight_duration;
    }

    public void setDaylight_duration(double daylight_duration) {
        this.daylight_duration = daylight_duration;
    }

    public double getSunshine_duration() {
        return sunshine_duration;
    }

    public void setSunshine_duration(double sunshine_duration) {
        this.sunshine_duration = sunshine_duration;
    }

    public double getPrecipitation_sum() {
        return precipitation_sum;
    }

    public void setPrecipitation_sum(double precipitation_sum) {
        this.precipitation_sum = precipitation_sum;
    }

    public double getRain_sum() {
        return rain_sum;
    }

    public void setRain_sum(double rain_sum) {
        this.rain_sum = rain_sum;
    }

    public double getSnowfall_sum() {
        return snowfall_sum;
    }

    public void setSnowfall_sum(double snowfall_sum) {
        this.snowfall_sum = snowfall_sum;
    }

    public double getPrecipitation_hours() {
        return precipitation_hours;
    }

    public void setPrecipitation_hours(double precipitation_hours) {
        this.precipitation_hours = precipitation_hours;
    }

    public double getWind_speed_10m_max() {
        return wind_speed_10m_max;
    }

    public void setWind_speed_10m_max(double wind_speed_10m_max) {
        this.wind_speed_10m_max = wind_speed_10m_max;
    }

    public double getWind_gusts_10m_max() {
        return wind_gusts_10m_max;
    }

    public void setWind_gusts_10m_max(double wind_gusts_10m_max) {
        this.wind_gusts_10m_max = wind_gusts_10m_max;
    }

    public int getWind_direction_10m_dominant() {
        return wind_direction_10m_dominant;
    }

    public void setWind_direction_10m_dominant(int wind_direction_10m_dominant) {
        this.wind_direction_10m_dominant = wind_direction_10m_dominant;
    }
}
