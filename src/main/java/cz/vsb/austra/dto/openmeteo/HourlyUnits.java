package cz.vsb.austra.dto.openmeteo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HourlyUnits{
    @JsonProperty("time")
    public String getTime() {
        return this.time; }
    public void setTime(String time) {
        this.time = time; }
    String time;
    @JsonProperty("temperature_2m")
    public String getTemperature_2m() {
        return this.temperature_2m; }
    public void setTemperature_2m(String temperature_2m) {
        this.temperature_2m = temperature_2m; }
    String temperature_2m;
    @JsonProperty("relative_humidity_2m")
    public String getRelative_humidity_2m() {
        return this.relative_humidity_2m; }
    public void setRelative_humidity_2m(String relative_humidity_2m) {
        this.relative_humidity_2m = relative_humidity_2m; }
    String relative_humidity_2m;
    @JsonProperty("dew_point_2m")
    public String getDew_point_2m() {
        return this.dew_point_2m; }
    public void setDew_point_2m(String dew_point_2m) {
        this.dew_point_2m = dew_point_2m; }
    String dew_point_2m;
    @JsonProperty("apparent_temperature")
    public String getApparent_temperature() {
        return this.apparent_temperature; }
    public void setApparent_temperature(String apparent_temperature) {
        this.apparent_temperature = apparent_temperature; }
    String apparent_temperature;
    @JsonProperty("precipitation_probability")
    public String getPrecipitation_probability() {
        return this.precipitation_probability; }
    public void setPrecipitation_probability(String precipitation_probability) {
        this.precipitation_probability = precipitation_probability; }
    String precipitation_probability;
    @JsonProperty("precipitation")
    public String getPrecipitation() {
        return this.precipitation; }
    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation; }
    String precipitation;
    @JsonProperty("rain")
    public String getRain() {
        return this.rain; }
    public void setRain(String rain) {
        this.rain = rain; }
    String rain;
    @JsonProperty("showers")
    public String getShowers() {
        return this.showers; }
    public void setShowers(String showers) {
        this.showers = showers; }
    String showers;
    @JsonProperty("snowfall")
    public String getSnowfall() {
        return this.snowfall; }
    public void setSnowfall(String snowfall) {
        this.snowfall = snowfall; }
    String snowfall;
    @JsonProperty("snow_depth")
    public String getSnow_depth() {
        return this.snow_depth; }
    public void setSnow_depth(String snow_depth) {
        this.snow_depth = snow_depth; }
    String snow_depth;
    @JsonProperty("weather_code")
    public String getWeather_code() {
        return this.weather_code; }
    public void setWeather_code(String weather_code) {
        this.weather_code = weather_code; }
    String weather_code;
    @JsonProperty("pressure_msl")
    public String getPressure_msl() {
        return this.pressure_msl; }
    public void setPressure_msl(String pressure_msl) {
        this.pressure_msl = pressure_msl; }
    String pressure_msl;
    @JsonProperty("surface_pressure")
    public String getSurface_pressure() {
        return this.surface_pressure; }
    public void setSurface_pressure(String surface_pressure) {
        this.surface_pressure = surface_pressure; }
    String surface_pressure;
    @JsonProperty("cloud_cover")
    public String getCloud_cover() {
        return this.cloud_cover; }
    public void setCloud_cover(String cloud_cover) {
        this.cloud_cover = cloud_cover; }
    String cloud_cover;
    @JsonProperty("wind_speed_10m")
    public String getWind_speed_10m() {
        return this.wind_speed_10m; }
    public void setWind_speed_10m(String wind_speed_10m) {
        this.wind_speed_10m = wind_speed_10m; }
    String wind_speed_10m;
    @JsonProperty("wind_gusts_10m")
    public String getWind_gusts_10m() {
        return this.wind_gusts_10m; }
    public void setWind_gusts_10m(String wind_gusts_10m) {
        this.wind_gusts_10m = wind_gusts_10m; }
    String wind_gusts_10m;
    @JsonProperty("visibility")
    public String getVisibility() {
        return this.visibility; }
    public void setVisibility(String visibility) {
        this.visibility = visibility; }
    String visibility;
    @JsonProperty("uv_index")
    public String getUv_index() {
        return this.uv_index; }
    public void setUv_index(String uv_index) {
        this.uv_index = uv_index; }
    String uv_index;
    @JsonProperty("sunshine_duration")
    public String getSunshine_duration() {
        return this.sunshine_duration; }
    public void setSunshine_duration(String sunshine_duration) {
        this.sunshine_duration = sunshine_duration; }
    String sunshine_duration;
    @JsonProperty("cloud_cover_low")
    public String getCloud_cover_low() {
        return this.cloud_cover_low; }
    public void setCloud_cover_low(String cloud_cover_low) {
        this.cloud_cover_low = cloud_cover_low; }
    String cloud_cover_low;
    @JsonProperty("cloud_cover_mid")
    public String getCloud_cover_mid() {
        return this.cloud_cover_mid; }
    public void setCloud_cover_mid(String cloud_cover_mid) {
        this.cloud_cover_mid = cloud_cover_mid; }
    String cloud_cover_mid;
    @JsonProperty("cloud_cover_high")
    public String getCloud_cover_high() {
        return this.cloud_cover_high; }
    public void setCloud_cover_high(String cloud_cover_high) {
        this.cloud_cover_high = cloud_cover_high; }
    String cloud_cover_high;
    @JsonProperty("wind_direction_10m")
    public String getWind_direction_10m() {
        return this.wind_direction_10m; }
    public void setWind_direction_10m(String wind_direction_10m) {
        this.wind_direction_10m = wind_direction_10m; }
    String wind_direction_10m;
}
