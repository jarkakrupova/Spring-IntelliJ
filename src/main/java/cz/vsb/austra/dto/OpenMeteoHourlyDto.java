package cz.vsb.austra.dto;

public class OpenMeteoHourlyDto {
    private String time;
    private Double temperature_2m;
    private Integer relative_humidity_2m;
    private Double dew_point_2m;
    private Double apparent_temperature;
    private Integer precipitation_probability;
    private Double precipitation;
    private Double rain;
    private Integer wind_direction_10m;
    private Integer cloud_cover_high;
    private Integer cloud_cover_mid;
    private Integer cloud_cover_low;
    private Double sunshine_duration;
    private Double uv_index;
    private Double visibility;
    private Double wind_gusts_10m;
    private Double wind_speed_10m;
    private Integer cloud_cover;
    private Double surface_pressure;
    private Double pressure_msl;
    private Integer weather_code;
    private Double snow_depth;
    private Double snowfall;
    private Double showers;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(Double temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public Integer getRelative_humidity_2m() {
        return relative_humidity_2m;
    }

    public void setRelative_humidity_2m(Integer relative_humidity_2m) {
        this.relative_humidity_2m = relative_humidity_2m;
    }

    public Double getDew_point_2m() {
        return dew_point_2m;
    }

    public void setDew_point_2m(Double dew_point_2m) {
        this.dew_point_2m = dew_point_2m;
    }

    public Double getApparent_temperature() {
        return apparent_temperature;
    }

    public void setApparent_temperature(Double apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }

    public Integer getPrecipitation_probability() {
        return precipitation_probability;
    }

    public void setPrecipitation_probability(Integer precipitation_probability) {
        this.precipitation_probability = precipitation_probability;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public Double getRain() {
        return rain;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Integer getWind_direction_10m() {
        return wind_direction_10m;
    }

    public void setWind_direction_10m(Integer wind_direction_10m) {
        this.wind_direction_10m = wind_direction_10m;
    }

    public Integer getCloud_cover_high() {
        return cloud_cover_high;
    }

    public void setCloud_cover_high(Integer cloud_cover_high) {
        this.cloud_cover_high = cloud_cover_high;
    }

    public Integer getCloud_cover_mid() {
        return cloud_cover_mid;
    }

    public void setCloud_cover_mid(Integer cloud_cover_mid) {
        this.cloud_cover_mid = cloud_cover_mid;
    }

    public Integer getCloud_cover_low() {
        return cloud_cover_low;
    }

    public void setCloud_cover_low(Integer cloud_cover_low) {
        this.cloud_cover_low = cloud_cover_low;
    }

    public Double getSunshine_duration() {
        return sunshine_duration;
    }

    public void setSunshine_duration(Double sunshine_duration) {
        this.sunshine_duration = sunshine_duration;
    }

    public Double getUv_index() {
        return uv_index;
    }

    public void setUv_index(Double uv_index) {
        this.uv_index = uv_index;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Double getWind_gusts_10m() {
        return wind_gusts_10m;
    }

    public void setWind_gusts_10m(Double wind_gusts_10m) {
        this.wind_gusts_10m = wind_gusts_10m;
    }

    public Double getWind_speed_10m() {
        return wind_speed_10m;
    }

    public void setWind_speed_10m(Double wind_speed_10m) {
        this.wind_speed_10m = wind_speed_10m;
    }

    public Integer getCloud_cover() {
        return cloud_cover;
    }

    public void setCloud_cover(Integer cloud_cover) {
        this.cloud_cover = cloud_cover;
    }

    public Double getSurface_pressure() {
        return surface_pressure;
    }

    public void setSurface_pressure(Double surface_pressure) {
        this.surface_pressure = surface_pressure;
    }

    public Double getPressure_msl() {
        return pressure_msl;
    }

    public void setPressure_msl(Double pressure_msl) {
        this.pressure_msl = pressure_msl;
    }

    public Integer getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(Integer weather_code) {
        this.weather_code = weather_code;
    }

    public Double getSnow_depth() {
        return snow_depth;
    }

    public void setSnow_depth(Double snow_depth) {
        this.snow_depth = snow_depth;
    }

    public Double getSnowfall() {
        return snowfall;
    }

    public void setSnowfall(Double snowfall) {
        this.snowfall = snowfall;
    }

    public Double getShowers() {
        return showers;
    }

    public void setShowers(Double showers) {
        this.showers = showers;
    }
}
