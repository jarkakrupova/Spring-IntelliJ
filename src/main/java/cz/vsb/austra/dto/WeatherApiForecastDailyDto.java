package cz.vsb.austra.dto;

import java.util.ArrayList;

/**
 * Output class for daily weather data from WeatherApi.com
 */
public class WeatherApiForecastDailyDto {
    private SunMoonAstroDto sunMoonData;
    private WeatherApiMinMaxPrecipSnowDto minMaxPrecipSnowData;
    private ArrayList<WeatherApiForecastHourlyDto> hourlyData;
    private ArrayList<OpenMeteoHourlyDto> openMeteoHourlyData;




    public ArrayList<OpenMeteoHourlyDto> getOpenMeteoHourlyData() {
        return openMeteoHourlyData;
    }

    public void setOpenMeteoHourlyData(ArrayList<OpenMeteoHourlyDto> openMeteoHourlyData) {
        this.openMeteoHourlyData = openMeteoHourlyData;
    }


    public WeatherApiForecastDailyDto() {
        //setSunMoonData(new ArrayList<>());
        //setMinMaxPrecipSnowData(new ArrayList<>());
        setHourlyData(new ArrayList<>());
        setOpenMeteoHourlyData(new ArrayList<>());
        //setTomorrowioForecastHourlyData(new ArrayList<>());
    }

    public SunMoonAstroDto getSunMoonData() {
        return sunMoonData;
    }

    public void setSunMoonData(SunMoonAstroDto sunMoonData) {
        this.sunMoonData = sunMoonData;
    }

    public WeatherApiMinMaxPrecipSnowDto getMinMaxPrecipSnowData() {
        return minMaxPrecipSnowData;
    }

    public void setMinMaxPrecipSnowData(WeatherApiMinMaxPrecipSnowDto minMaxPrecipSnowData) {
        this.minMaxPrecipSnowData = minMaxPrecipSnowData;
    }

    public ArrayList<WeatherApiForecastHourlyDto> getHourlyData() {
        return hourlyData;
    }

    public void setHourlyData(ArrayList<WeatherApiForecastHourlyDto> hourlyData) {
        this.hourlyData = hourlyData;
    }


}
