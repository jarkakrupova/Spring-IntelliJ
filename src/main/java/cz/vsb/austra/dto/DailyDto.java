package cz.vsb.austra.dto;

import java.util.ArrayList;

public class DailyDto {
    private ArrayList<SunMoonDto> sunMoonData;
    private ArrayList<MinMaxPrecipSnowDto> minMaxPrecipSnowData;
    private ArrayList<HourlyDto> hourlyData;

    public DailyDto() {
        setSunMoonData(new ArrayList<>());
        setMinMaxPrecipSnowData(new ArrayList<>());
        setHourlyData(new ArrayList<>());
    }

    public ArrayList<SunMoonDto> getSunMoonData() {
        return sunMoonData;
    }

    public void setSunMoonData(ArrayList<SunMoonDto> sunMoonData) {
        this.sunMoonData = sunMoonData;
    }

    public ArrayList<MinMaxPrecipSnowDto> getMinMaxPrecipSnowData() {
        return minMaxPrecipSnowData;
    }

    public void setMinMaxPrecipSnowData(ArrayList<MinMaxPrecipSnowDto> minMaxPrecipSnowData) {
        this.minMaxPrecipSnowData = minMaxPrecipSnowData;
    }

    public ArrayList<HourlyDto> getHourlyData() {
        return hourlyData;
    }

    public void setHourlyData(ArrayList<HourlyDto> hourlyData) {
        this.hourlyData = hourlyData;
    }
}
