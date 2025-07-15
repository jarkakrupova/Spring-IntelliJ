package cz.vsb.austra.dto;

import java.util.ArrayList;

public class DailyDto {
    private SunMoonAstroDto sunMoonData;
    private MinMaxPrecipSnowDto minMaxPrecipSnowData;
    private ArrayList<HourlyDto> hourlyData;

    public ArrayList<OpenMeteoHourlyDto> getOpenMeteoHourlyData() {
        return openMeteoHourlyData;
    }

    public void setOpenMeteoHourlyData(ArrayList<OpenMeteoHourlyDto> openMeteoHourlyData) {
        this.openMeteoHourlyData = openMeteoHourlyData;
    }

    private ArrayList<OpenMeteoHourlyDto> openMeteoHourlyData;

    public DailyDto() {
        //setSunMoonData(new ArrayList<>());
        //setMinMaxPrecipSnowData(new ArrayList<>());
        setHourlyData(new ArrayList<>());
        setOpenMeteoHourlyData(new ArrayList<>());
    }

    public SunMoonAstroDto getSunMoonData() {
        return sunMoonData;
    }

    public void setSunMoonData(SunMoonAstroDto sunMoonData) {
        this.sunMoonData = sunMoonData;
    }

    public MinMaxPrecipSnowDto getMinMaxPrecipSnowData() {
        return minMaxPrecipSnowData;
    }

    public void setMinMaxPrecipSnowData(MinMaxPrecipSnowDto minMaxPrecipSnowData) {
        this.minMaxPrecipSnowData = minMaxPrecipSnowData;
    }

    public ArrayList<HourlyDto> getHourlyData() {
        return hourlyData;
    }

    public void setHourlyData(ArrayList<HourlyDto> hourlyData) {
        this.hourlyData = hourlyData;
    }


}
