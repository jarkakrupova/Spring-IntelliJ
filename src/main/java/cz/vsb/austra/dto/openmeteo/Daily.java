package cz.vsb.austra.dto.openmeteo;

import java.util.ArrayList;

public class Daily {
    private ArrayList<String> time;
    private ArrayList<Integer> weather_code;
    private ArrayList<Double> temperature_2m_max;
    private ArrayList<Double> temperature_2m_min;
    private ArrayList<Double> temperature_2m_mean;
    private ArrayList<Double> apparent_temperature_max;
    private ArrayList<Double> apparent_temperature_min;
    private ArrayList<Double> apparent_temperature_mean;
    private ArrayList<String> sunrise;
    private ArrayList<String> sunset;
    private ArrayList<Double> daylight_duration;
    private ArrayList<Double> sunshine_duration;
    private ArrayList<Double> precipitation_sum;
    private ArrayList<Double> rain_sum;
    private ArrayList<Double> snowfall_sum;
    private ArrayList<Double> precipitation_hours;
    private ArrayList<Double> wind_speed_10m_max;
    private ArrayList<Double> wind_gusts_10m_max;
    private ArrayList<Integer> wind_direction_10m_dominant;

    public ArrayList<String> getTime() {
        return time;
    }

    public void setTime(ArrayList<String> time) {
        this.time = time;
    }

    public ArrayList<Integer> getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(ArrayList<Integer> weather_code) {
        this.weather_code = weather_code;
    }

    public ArrayList<Double> getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public void setTemperature_2m_max(ArrayList<Double> temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }

    public ArrayList<Double> getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public void setTemperature_2m_min(ArrayList<Double> temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }

    public ArrayList<Double> getTemperature_2m_mean() {
        return temperature_2m_mean;
    }

    public void setTemperature_2m_mean(ArrayList<Double> temperature_2m_mean) {
        this.temperature_2m_mean = temperature_2m_mean;
    }

    public ArrayList<Double> getApparent_temperature_max() {
        return apparent_temperature_max;
    }

    public void setApparent_temperature_max(ArrayList<Double> apparent_temperature_max) {
        this.apparent_temperature_max = apparent_temperature_max;
    }

    public ArrayList<Double> getApparent_temperature_min() {
        return apparent_temperature_min;
    }

    public void setApparent_temperature_min(ArrayList<Double> apparent_temperature_min) {
        this.apparent_temperature_min = apparent_temperature_min;
    }

    public ArrayList<Double> getApparent_temperature_mean() {
        return apparent_temperature_mean;
    }

    public void setApparent_temperature_mean(ArrayList<Double> apparent_temperature_mean) {
        this.apparent_temperature_mean = apparent_temperature_mean;
    }

    public ArrayList<String> getSunrise() {
        return sunrise;
    }

    public void setSunrise(ArrayList<String> sunrise) {
        this.sunrise = sunrise;
    }

    public ArrayList<String> getSunset() {
        return sunset;
    }

    public void setSunset(ArrayList<String> sunset) {
        this.sunset = sunset;
    }

    public ArrayList<Double> getDaylight_duration() {
        return daylight_duration;
    }

    public void setDaylight_duration(ArrayList<Double> daylight_duration) {
        this.daylight_duration = daylight_duration;
    }

    public ArrayList<Double> getSunshine_duration() {
        return sunshine_duration;
    }

    public void setSunshine_duration(ArrayList<Double> sunshine_duration) {
        this.sunshine_duration = sunshine_duration;
    }

    public ArrayList<Double> getPrecipitation_sum() {
        return precipitation_sum;
    }

    public void setPrecipitation_sum(ArrayList<Double> precipitation_sum) {
        this.precipitation_sum = precipitation_sum;
    }

    public ArrayList<Double> getRain_sum() {
        return rain_sum;
    }

    public void setRain_sum(ArrayList<Double> rain_sum) {
        this.rain_sum = rain_sum;
    }

    public ArrayList<Double> getSnowfall_sum() {
        return snowfall_sum;
    }

    public void setSnowfall_sum(ArrayList<Double> snowfall_sum) {
        this.snowfall_sum = snowfall_sum;
    }

    public ArrayList<Double> getPrecipitation_hours() {
        return precipitation_hours;
    }

    public void setPrecipitation_hours(ArrayList<Double> precipitation_hours) {
        this.precipitation_hours = precipitation_hours;
    }

    public ArrayList<Double> getWind_speed_10m_max() {
        return wind_speed_10m_max;
    }

    public void setWind_speed_10m_max(ArrayList<Double> wind_speed_10m_max) {
        this.wind_speed_10m_max = wind_speed_10m_max;
    }

    public ArrayList<Double> getWind_gusts_10m_max() {
        return wind_gusts_10m_max;
    }

    public void setWind_gusts_10m_max(ArrayList<Double> wind_gusts_10m_max) {
        this.wind_gusts_10m_max = wind_gusts_10m_max;
    }

    public ArrayList<Integer> getWind_direction_10m_dominant() {
        return wind_direction_10m_dominant;
    }

    public void setWind_direction_10m_dominant(ArrayList<Integer> wind_direction_10m_dominant) {
        this.wind_direction_10m_dominant = wind_direction_10m_dominant;
    }
}
