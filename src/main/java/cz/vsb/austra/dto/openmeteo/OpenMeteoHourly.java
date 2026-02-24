package cz.vsb.austra.dto.openmeteo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class OpenMeteoHourly {
    @JsonProperty("time")
    public ArrayList<String> getTime() {
        return this.time; }
    public void setTime(ArrayList<String> time) {
        this.time = time; }
    ArrayList<String> time;
    @JsonProperty("temperature_2m")
    public ArrayList<Double> getTemperature_2m() {
        return this.temperature_2m; }
    public void setTemperature_2m(ArrayList<Double> temperature_2m) {
        this.temperature_2m = temperature_2m; }
    ArrayList<Double> temperature_2m;
    @JsonProperty("relative_humidity_2m")
    public ArrayList<Integer> getRelative_humidity_2m() {
        return this.relative_humidity_2m; }
    public void setRelative_humidity_2m(ArrayList<Integer> relative_humidity_2m) {
        this.relative_humidity_2m = relative_humidity_2m; }
    ArrayList<Integer> relative_humidity_2m;
    @JsonProperty("dew_point_2m")
    public ArrayList<Double> getDew_point_2m() {
        return this.dew_poInteger_2m; }
    public void setDew_point_2m(ArrayList<Double> dew_poInteger_2m) {
        this.dew_poInteger_2m = dew_poInteger_2m; }
    ArrayList<Double> dew_poInteger_2m;
    @JsonProperty("apparent_temperature")
    public ArrayList<Double> getApparent_temperature() {
        return this.apparent_temperature; }
    public void setApparent_temperature(ArrayList<Double> apparent_temperature) {
        this.apparent_temperature = apparent_temperature; }
    ArrayList<Double> apparent_temperature;
    @JsonProperty("precipitation_probability")
    public ArrayList<Integer> getPrecipitation_probability() {
        return this.precipitation_probability; }
    public void setPrecipitation_probability(ArrayList<Integer> precipitation_probability) {
        this.precipitation_probability = precipitation_probability; }
    ArrayList<Integer> precipitation_probability;
    @JsonProperty("precipitation")
    public ArrayList<Double> getPrecipitation() {
        return this.precipitation; }
    public void setPrecipitation(ArrayList<Double> precipitation) {
        this.precipitation = precipitation; }
    ArrayList<Double> precipitation;
    @JsonProperty("rain")
    public ArrayList<Double> getRain() {
        return this.rain; }
    public void setRain(ArrayList<Double> rain) {
        this.rain = rain; }
    ArrayList<Double> rain;
    @JsonProperty("showers")
    public ArrayList<Double> getShowers() {
        return this.showers; }
    public void setShowers(ArrayList<Double> showers) {
        this.showers = showers; }
    ArrayList<Double> showers;
    @JsonProperty("snowfall")
    public ArrayList<Double> getSnowfall() {
        return this.snowfall; }
    public void setSnowfall(ArrayList<Double> snowfall) {
        this.snowfall = snowfall; }
    ArrayList<Double> snowfall;
    @JsonProperty("snow_depth")
    public ArrayList<Double> getSnow_depth() {
        return this.snow_depth; }
    public void setSnow_depth(ArrayList<Double> snow_depth) {
        this.snow_depth = snow_depth; }
    ArrayList<Double> snow_depth;
    @JsonProperty("weather_code")
    public ArrayList<Integer> getWeather_code() {
        return this.weather_code; }
    public void setWeather_code(ArrayList<Integer> weather_code) {
        this.weather_code = weather_code; }
    ArrayList<Integer> weather_code;
    @JsonProperty("pressure_msl")
    public ArrayList<Double> getPressure_msl() {
        return this.pressure_msl; }
    public void setPressure_msl(ArrayList<Double> pressure_msl) {
        this.pressure_msl = pressure_msl; }
    ArrayList<Double> pressure_msl;
    @JsonProperty("surface_pressure")
    public ArrayList<Double> getSurface_pressure() {
        return this.surface_pressure; }
    public void setSurface_pressure(ArrayList<Double> surface_pressure) {
        this.surface_pressure = surface_pressure; }
    ArrayList<Double> surface_pressure;
    @JsonProperty("cloud_cover")
    public ArrayList<Integer> getCloud_cover() {
        return this.cloud_cover; }
    public void setCloud_cover(ArrayList<Integer> cloud_cover) {
        this.cloud_cover = cloud_cover; }
    ArrayList<Integer> cloud_cover;
    @JsonProperty("wind_speed_10m")
    public ArrayList<Double> getWind_speed_10m() {
        return this.wind_speed_10m; }
    public void setWind_speed_10m(ArrayList<Double> wind_speed_10m) {
        this.wind_speed_10m = wind_speed_10m; }
    ArrayList<Double> wind_speed_10m;
    @JsonProperty("wind_gusts_10m")
    public ArrayList<Double> getWind_gusts_10m() {
        return this.wind_gusts_10m; }
    public void setWind_gusts_10m(ArrayList<Double> wind_gusts_10m) {
        this.wind_gusts_10m = wind_gusts_10m; }
    ArrayList<Double> wind_gusts_10m;
    @JsonProperty("visibility")
    public ArrayList<Double> getVisibility() {
        return this.visibility; }
    public void setVisibility(ArrayList<Double> visibility) {
        this.visibility = visibility; }
    ArrayList<Double> visibility;
    @JsonProperty("uv_index")
    public ArrayList<Double> getUv_index() {
        return this.uv_index; }
    public void setUv_index(ArrayList<Double> uv_index) {
        this.uv_index = uv_index; }
    ArrayList<Double> uv_index;
    @JsonProperty("sunshine_duration")
    public ArrayList<Double> getSunshine_duration() {
        return this.sunshine_duration; }
    public void setSunshine_duration(ArrayList<Double> sunshine_duration) {
        this.sunshine_duration = sunshine_duration; }
    ArrayList<Double> sunshine_duration;
    @JsonProperty("cloud_cover_low")
    public ArrayList<Integer> getCloud_cover_low() {
        return this.cloud_cover_low; }
    public void setCloud_cover_low(ArrayList<Integer> cloud_cover_low) {
        this.cloud_cover_low = cloud_cover_low; }
    ArrayList<Integer> cloud_cover_low;
    @JsonProperty("cloud_cover_mid")
    public ArrayList<Integer> getCloud_cover_mid() {
        return this.cloud_cover_mid; }
    public void setCloud_cover_mid(ArrayList<Integer> cloud_cover_mid) {
        this.cloud_cover_mid = cloud_cover_mid; }
    ArrayList<Integer> cloud_cover_mid;
    @JsonProperty("cloud_cover_high")
    public ArrayList<Integer> getCloud_cover_high() {
        return this.cloud_cover_high; }
    public void setCloud_cover_high(ArrayList<Integer> cloud_cover_high) {
        this.cloud_cover_high = cloud_cover_high; }
    ArrayList<Integer> cloud_cover_high;
    @JsonProperty("wind_direction_10m")
    public ArrayList<Integer> getWind_direction_10m() {
        return this.wind_direction_10m; }
    public void setWind_direction_10m(ArrayList<Integer> wind_direction_10m) {
        this.wind_direction_10m = wind_direction_10m; }
    ArrayList<Integer> wind_direction_10m;
}

