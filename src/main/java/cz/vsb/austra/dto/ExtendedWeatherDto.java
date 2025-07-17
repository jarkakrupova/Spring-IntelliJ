package cz.vsb.austra.dto;

public class ExtendedWeatherDto {
    //_WA - WeatherApi
    //_T - Tomorrow.io
    private String location;
    private String timestamp;
    private Double temp_celsius_T;
    private String weatherDescription_T;
    private Double windSpeed_mps_T;
    private Double windDirection_T;
    private Double rel_humidity_T;
    private Double dewPoint_T;
    private Double temp_apparent_T;
    private Double visibility_T;
    private Double windGust_T;
    private Double pressure_T;
    private Integer uvIndex_T;
    private String windDirString_T;
    private Double cloudBase_T;
    private Double cloudCeiling_T;
    private Integer cloudCover_T;
    private Double rainIntensity_T;
    private Double snowIntensity_T;
    private Integer precipitationProbability_T;
    private double temp_c_WA;
    private double feelslike_c_WA;
    private double precip_mm_WA;
    private double wind_kph_WA;
    private int wind_degree_WA;
    private String wind_dir_WA;
    private double pressure_mb_WA;
    private String last_updated_WA;
    private int humidity_WA;
    private int cloud_WA;
    private double vis_km_WA;
    private double gust_kph_WA;
    private double uv_WA;
    private String weather_description_WA;

    private String weather_description_OWM;
    private int humidity_OWM;
    private double wind_speed_OWM;
    private int wind_degree_OWM;
    private double wind_gust_OWM;
    private double visibility_OWM;
    private double temp_c_OWM;
    private double feels_like_c_OWM;
    private double pressure_sea_OWM;
    private double pressure_surface_OWM;
//    private double rain_OWM;
    private int cloudCover_OWM;
    private String timestamp_OWM;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTemp_celsius_T() {
        return temp_celsius_T;
    }

    public void setTemp_celsius_T(Double temp_celsius_T) {
        this.temp_celsius_T = temp_celsius_T;
    }

    public String getWeatherDescription_T() {
        return weatherDescription_T;
    }

    public void setWeatherDescription_T(String weatherDescription_T) {
        this.weatherDescription_T = weatherDescription_T;
    }

    public Double getWindSpeed_mps_T() {
        return windSpeed_mps_T;
    }

    public void setWindSpeed_mps_T(Double windSpeed_mps_T) {
        this.windSpeed_mps_T = windSpeed_mps_T;
    }

    public Double getWindDirection_T() {
        return windDirection_T;
    }

    public void setWindDirection_T(Double windDirection_T) {
        this.windDirection_T = windDirection_T;
    }

    public Double getRel_humidity_T() {
        return rel_humidity_T;
    }

    public void setRel_humidity_T(Double rel_humidity_T) {
        this.rel_humidity_T = rel_humidity_T;
    }

    public Double getDewPoint_T() {
        return dewPoint_T;
    }

    public void setDewPoint_T(Double dewPoint_T) {
        this.dewPoint_T = dewPoint_T;
    }

    public Double getTemp_apparent_T() {
        return temp_apparent_T;
    }

    public void setTemp_apparent_T(Double temp_apparent_T) {
        this.temp_apparent_T = temp_apparent_T;
    }

    public Double getVisibility_T() {
        return visibility_T;
    }

    public void setVisibility_T(Double visibility_T) {
        this.visibility_T = visibility_T;
    }

    public Double getWindGust_T() {
        return windGust_T;
    }

    public void setWindGust_T(Double windGust_T) {
        this.windGust_T = windGust_T;
    }

    public Double getPressure_T() {
        return pressure_T;
    }

    public void setPressure_T(Double pressure_T) {
        this.pressure_T = pressure_T;
    }

    public Integer getUvIndex_T() {
        return uvIndex_T;
    }

    public void setUvIndex_T(Integer uvIndex_T) {
        this.uvIndex_T = uvIndex_T;
    }

    public String getWindDirString_T() {
        return windDirString_T;
    }

    public void setWindDirString_T(String windDirString_T) {
        this.windDirString_T = windDirString_T;
    }

    public Double getCloudBase_T() {
        return cloudBase_T;
    }

    public void setCloudBase_T(Double cloudBase_T) {
        this.cloudBase_T = cloudBase_T;
    }

    public Double getCloudCeiling_T() {
        return cloudCeiling_T;
    }

    public void setCloudCeiling_T(Double cloudCeiling_T) {
        this.cloudCeiling_T = cloudCeiling_T;
    }

    public Integer getCloudCover_T() {
        return cloudCover_T;
    }

    public void setCloudCover_T(Integer cloudCover_T) {
        this.cloudCover_T = cloudCover_T;
    }

    public Double getRainIntensity_T() {
        return rainIntensity_T;
    }

    public void setRainIntensity_T(Double rainIntensity_T) {
        this.rainIntensity_T = rainIntensity_T;
    }

    public Double getSnowIntensity_T() {
        return snowIntensity_T;
    }

    public void setSnowIntensity_T(Double snowIntensity_T) {
        this.snowIntensity_T = snowIntensity_T;
    }

    public Integer getPrecipitationProbability_T() {
        return precipitationProbability_T;
    }

    public void setPrecipitationProbability_T(Integer precipitationProbability_T) {
        this.precipitationProbability_T = precipitationProbability_T;
    }

    public double getTemp_c_WA() {
        return temp_c_WA;
    }

    public void setTemp_c_WA(double temp_c_WA) {
        this.temp_c_WA = temp_c_WA;
    }

    public double getFeelslike_c_WA() {
        return feelslike_c_WA;
    }

    public void setFeelslike_c_WA(double feelslike_c_WA) {
        this.feelslike_c_WA = feelslike_c_WA;
    }

    public double getPrecip_mm_WA() {
        return precip_mm_WA;
    }

    public void setPrecip_mm_WA(double precip_mm_WA) {
        this.precip_mm_WA = precip_mm_WA;
    }

    public double getWind_kph_WA() {
        return wind_kph_WA;
    }

    public void setWind_kph_WA(double wind_kph_WA) {
        this.wind_kph_WA = wind_kph_WA;
    }

    public int getWind_degree_WA() {
        return wind_degree_WA;
    }

    public void setWind_degree_WA(int wind_degree_WA) {
        this.wind_degree_WA = wind_degree_WA;
    }

    public String getWind_dir_WA() {
        return wind_dir_WA;
    }

    public void setWind_dir_WA(String wind_dir_WA) {
        this.wind_dir_WA = wind_dir_WA;
    }

    public double getPressure_mb_WA() {
        return pressure_mb_WA;
    }

    public void setPressure_mb_WA(double pressure_mb_WA) {
        this.pressure_mb_WA = pressure_mb_WA;
    }

    public String getLast_updated_WA() {
        return last_updated_WA;
    }

    public void setLast_updated_WA(String last_updated_WA) {
        this.last_updated_WA = last_updated_WA;
    }

    public int getHumidity_WA() {
        return humidity_WA;
    }

    public void setHumidity_WA(int humidity_WA) {
        this.humidity_WA = humidity_WA;
    }

    public int getCloud_WA() {
        return cloud_WA;
    }

    public void setCloud_WA(int cloud_WA) {
        this.cloud_WA = cloud_WA;
    }

    public double getVis_km_WA() {
        return vis_km_WA;
    }

    public void setVis_km_WA(double vis_km_WA) {
        this.vis_km_WA = vis_km_WA;
    }

    public double getGust_kph_WA() {
        return gust_kph_WA;
    }

    public void setGust_kph_WA(double gust_kph_WA) {
        this.gust_kph_WA = gust_kph_WA;
    }

    public double getUv_WA() {
        return uv_WA;
    }

    public void setUv_WA(double uv_WA) {
        this.uv_WA = uv_WA;
    }

    public String getWeather_description_WA() {
        return weather_description_WA;
    }

    public void setWeather_description_WA(String weather_description_WA) {
        this.weather_description_WA = weather_description_WA;
    }

    public String getWeather_description_OWM() {
        return weather_description_OWM;
    }

    public void setWeather_description_OWM(String weather_description_OWM) {
        this.weather_description_OWM = weather_description_OWM;
    }

    public int getHumidity_OWM() {
        return humidity_OWM;
    }

    public void setHumidity_OWM(int humidity_OWM) {
        this.humidity_OWM = humidity_OWM;
    }

    public double getWind_speed_OWM() {
        return wind_speed_OWM;
    }

    public void setWind_speed_OWM(double wind_speed_OWM) {
        this.wind_speed_OWM = wind_speed_OWM;
    }

    public int getWind_degree_OWM() {
        return wind_degree_OWM;
    }

    public void setWind_degree_OWM(int wind_degree_OWM) {
        this.wind_degree_OWM = wind_degree_OWM;
    }

    public double getWind_gust_OWM() {
        return wind_gust_OWM;
    }

    public void setWind_gust_OWM(double wind_gust_OWM) {
        this.wind_gust_OWM = wind_gust_OWM;
    }

    public double getVisibility_OWM() {
        return visibility_OWM;
    }

    public void setVisibility_OWM(double visibility_OWM) {
        this.visibility_OWM = visibility_OWM;
    }

    public double getTemp_c_OWM() {
        return temp_c_OWM;
    }

    public void setTemp_c_OWM(double temp_c_OWM) {
        this.temp_c_OWM = temp_c_OWM;
    }

    public double getFeels_like_c_OWM() {
        return feels_like_c_OWM;
    }

    public void setFeels_like_c_OWM(double feels_like_c_OWM) {
        this.feels_like_c_OWM = feels_like_c_OWM;
    }

    public double getPressure_sea_OWM() {
        return pressure_sea_OWM;
    }

    public void setPressure_sea_OWM(double pressure_sea_OWM) {
        this.pressure_sea_OWM = pressure_sea_OWM;
    }

    public double getPressure_surface_OWM() {
        return pressure_surface_OWM;
    }

    public void setPressure_surface_OWM(double pressure_surface_OWM) {
        this.pressure_surface_OWM = pressure_surface_OWM;
    }

//    public double getRain_OWM() {
//        return rain_OWM;
//    }
//
//    public void setRain_OWM(double rain_OWM) {
//        this.rain_OWM = rain_OWM;
//    }

    public int getCloudCover_OWM() {
        return cloudCover_OWM;
    }

    public void setCloudCover_OWM(int cloudCover_OWM) {
        this.cloudCover_OWM = cloudCover_OWM;
    }

    public String getTimestamp_OWM() {
        return timestamp_OWM;
    }

    public void setTimestamp_OWM(String timestamp_OWM) {
        this.timestamp_OWM = timestamp_OWM;
    }
}
