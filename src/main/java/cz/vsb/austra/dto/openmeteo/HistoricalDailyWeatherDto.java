package cz.vsb.austra.dto.openmeteo;

public class HistoricalDailyWeatherDto {
    private String time;
    private Integer weather_code;
    private Double temperature_2m_max;
    private Double temperature_2m_min;
    private Double temperature_2m_mean;
    private Double apparent_temperature_max;
    private Double apparent_temperature_min;
    private Double apparent_temperature_mean;
    private String sunrise;
    private String sunset;
    private Double daylight_duration;
    private Double sunshine_duration;
    private Double precipitation_sum;
    private Double rain_sum;
    private Double snowfall_sum;
    private Double precipitation_hours;
    private Double wind_speed_10m_max;
    private Double wind_gusts_10m_max;
    private Integer wind_direction_10m_dominant;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(Integer weather_code) {
        this.weather_code = weather_code;
    }

    public Double getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public void setTemperature_2m_max(Double temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }

    public Double getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public void setTemperature_2m_min(Double temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }

    public Double getTemperature_2m_mean() {
        return temperature_2m_mean;
    }

    public void setTemperature_2m_mean(Double temperature_2m_mean) {
        this.temperature_2m_mean = temperature_2m_mean;
    }

    public Double getApparent_temperature_max() {
        return apparent_temperature_max;
    }

    public void setApparent_temperature_max(Double apparent_temperature_max) {
        this.apparent_temperature_max = apparent_temperature_max;
    }

    public Double getApparent_temperature_min() {
        return apparent_temperature_min;
    }

    public void setApparent_temperature_min(Double apparent_temperature_min) {
        this.apparent_temperature_min = apparent_temperature_min;
    }

    public Double getApparent_temperature_mean() {
        return apparent_temperature_mean;
    }

    public void setApparent_temperature_mean(Double apparent_temperature_mean) {
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

    public Double getDaylight_duration() {
        return daylight_duration;
    }

    public void setDaylight_duration(Double daylight_duration) {
        this.daylight_duration = daylight_duration;
    }

    public Double getSunshine_duration() {
        return sunshine_duration;
    }

    public void setSunshine_duration(Double sunshine_duration) {
        this.sunshine_duration = sunshine_duration;
    }

    public Double getPrecipitation_sum() {
        return precipitation_sum;
    }

    public void setPrecipitation_sum(Double precipitation_sum) {
        this.precipitation_sum = precipitation_sum;
    }

    public Double getRain_sum() {
        return rain_sum;
    }

    public void setRain_sum(Double rain_sum) {
        this.rain_sum = rain_sum;
    }

    public Double getSnowfall_sum() {
        return snowfall_sum;
    }

    public void setSnowfall_sum(Double snowfall_sum) {
        this.snowfall_sum = snowfall_sum;
    }

    public Double getPrecipitation_hours() {
        return precipitation_hours;
    }

    public void setPrecipitation_hours(Double precipitation_hours) {
        this.precipitation_hours = precipitation_hours;
    }

    public Double getWind_speed_10m_max() {
        return wind_speed_10m_max;
    }

    public void setWind_speed_10m_max(Double wind_speed_10m_max) {
        this.wind_speed_10m_max = wind_speed_10m_max;
    }

    public Double getWind_gusts_10m_max() {
        return wind_gusts_10m_max;
    }

    public void setWind_gusts_10m_max(Double wind_gusts_10m_max) {
        this.wind_gusts_10m_max = wind_gusts_10m_max;
    }

    public Integer getWind_direction_10m_dominant() {
        return wind_direction_10m_dominant;
    }

    public void setWind_direction_10m_dominant(Integer wind_direction_10m_dominant) {
        this.wind_direction_10m_dominant = wind_direction_10m_dominant;
    }
}
