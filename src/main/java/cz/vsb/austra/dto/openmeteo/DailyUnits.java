package cz.vsb.austra.dto.openmeteo;

public class DailyUnits {
    private String time;
    private String weather_code;
    private String temperature_2m_max;
    private String temperature_2m_min;
    private String temperature_2m_mean;
    private String apparent_temperature_max;
    private String apparent_temperature_min;
    private String apparent_temperature_mean;
    private String sunrise;
    private String sunset;
    private String daylight_duration;
    private String sunshine_duration;
    private String precipitation_sum;
    private String rain_sum;
    private String snowfall_sum;
    private String precipitation_hours;
    private String wind_speed_10m_max;
    private String wind_gusts_10m_max;
    private String wind_direction_10m_dominant;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(String weather_code) {
        this.weather_code = weather_code;
    }

    public String getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public void setTemperature_2m_max(String temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }

    public String getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public void setTemperature_2m_min(String temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }

    public String getTemperature_2m_mean() {
        return temperature_2m_mean;
    }

    public void setTemperature_2m_mean(String temperature_2m_mean) {
        this.temperature_2m_mean = temperature_2m_mean;
    }

    public String getApparent_temperature_max() {
        return apparent_temperature_max;
    }

    public void setApparent_temperature_max(String apparent_temperature_max) {
        this.apparent_temperature_max = apparent_temperature_max;
    }

    public String getApparent_temperature_min() {
        return apparent_temperature_min;
    }

    public void setApparent_temperature_min(String apparent_temperature_min) {
        this.apparent_temperature_min = apparent_temperature_min;
    }

    public String getApparent_temperature_mean() {
        return apparent_temperature_mean;
    }

    public void setApparent_temperature_mean(String apparent_temperature_mean) {
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

    public String getDaylight_duration() {
        return daylight_duration;
    }

    public void setDaylight_duration(String daylight_duration) {
        this.daylight_duration = daylight_duration;
    }

    public String getSunshine_duration() {
        return sunshine_duration;
    }

    public void setSunshine_duration(String sunshine_duration) {
        this.sunshine_duration = sunshine_duration;
    }

    public String getPrecipitation_sum() {
        return precipitation_sum;
    }

    public void setPrecipitation_sum(String precipitation_sum) {
        this.precipitation_sum = precipitation_sum;
    }

    public String getRain_sum() {
        return rain_sum;
    }

    public void setRain_sum(String rain_sum) {
        this.rain_sum = rain_sum;
    }

    public String getSnowfall_sum() {
        return snowfall_sum;
    }

    public void setSnowfall_sum(String snowfall_sum) {
        this.snowfall_sum = snowfall_sum;
    }

    public String getPrecipitation_hours() {
        return precipitation_hours;
    }

    public void setPrecipitation_hours(String precipitation_hours) {
        this.precipitation_hours = precipitation_hours;
    }

    public String getWind_speed_10m_max() {
        return wind_speed_10m_max;
    }

    public void setWind_speed_10m_max(String wind_speed_10m_max) {
        this.wind_speed_10m_max = wind_speed_10m_max;
    }

    public String getWind_gusts_10m_max() {
        return wind_gusts_10m_max;
    }

    public void setWind_gusts_10m_max(String wind_gusts_10m_max) {
        this.wind_gusts_10m_max = wind_gusts_10m_max;
    }

    public String getWind_direction_10m_dominant() {
        return wind_direction_10m_dominant;
    }

    public void setWind_direction_10m_dominant(String wind_direction_10m_dominant) {
        this.wind_direction_10m_dominant = wind_direction_10m_dominant;
    }
}
