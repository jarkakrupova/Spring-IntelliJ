package cz.vsb.austra.dto;

public class WeatherComMinMaxPrecipSnowDto {
    private Integer temperatureMax24Hour;
    private Integer temperatureMaxSince7Am;
    private Integer temperatureMin24Hour;
    private Double snow1Hour;
    private Double snow6Hour;
    private Double snow24Hour;
    private Double precip1Hour;
    private Double precip6Hour;
    private Double precip24Hour;

    public Integer getTemperatureMax24Hour() {
        return temperatureMax24Hour;
    }

    public void setTemperatureMax24Hour(Integer temperatureMax24Hour) {
        this.temperatureMax24Hour = temperatureMax24Hour;
    }

    public Integer getTemperatureMaxSince7Am() {
        return temperatureMaxSince7Am;
    }

    public void setTemperatureMaxSince7Am(Integer temperatureMaxSince7Am) {
        this.temperatureMaxSince7Am = temperatureMaxSince7Am;
    }

    public Integer getTemperatureMin24Hour() {
        return temperatureMin24Hour;
    }

    public void setTemperatureMin24Hour(Integer temperatureMin24Hour) {
        this.temperatureMin24Hour = temperatureMin24Hour;
    }

    public Double getSnow1Hour() {
        return snow1Hour;
    }

    public void setSnow1Hour(Double snow1Hour) {
        this.snow1Hour = snow1Hour;
    }

    public Double getSnow6Hour() {
        return snow6Hour;
    }

    public void setSnow6Hour(Double snow6Hour) {
        this.snow6Hour = snow6Hour;
    }

    public Double getSnow24Hour() {
        return snow24Hour;
    }

    public void setSnow24Hour(Double snow24Hour) {
        this.snow24Hour = snow24Hour;
    }

    public Double getPrecip1Hour() {
        return precip1Hour;
    }

    public void setPrecip1Hour(Double precip1Hour) {
        this.precip1Hour = precip1Hour;
    }

    public Double getPrecip6Hour() {
        return precip6Hour;
    }

    public void setPrecip6Hour(Double precip6Hour) {
        this.precip6Hour = precip6Hour;
    }

    public Double getPrecip24Hour() {
        return precip24Hour;
    }

    public void setPrecip24Hour(Double precip24Hour) {
        this.precip24Hour = precip24Hour;
    }
}
