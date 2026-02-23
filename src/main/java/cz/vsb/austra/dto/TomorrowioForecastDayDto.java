package cz.vsb.austra.dto;

import java.util.ArrayList;

public class TomorrowioForecastDayDto {
    private MinMaxPrecipSnowDto minMaxPrecipSnowDto;
    private ArrayList<TomorrowioForecastHourDto> tomorrowioForecastHourlyData;

    public TomorrowioForecastDayDto() {
        setTomorrowioForecastHourlyData(new ArrayList<>());
    }

    public ArrayList<TomorrowioForecastHourDto> getTomorrowioForecastHourlyData() {
        return tomorrowioForecastHourlyData;
    }

    public void setTomorrowioForecastHourlyData(ArrayList<TomorrowioForecastHourDto> tomorrowioForecastHourlyData) {
        this.tomorrowioForecastHourlyData = tomorrowioForecastHourlyData;
    }
    public MinMaxPrecipSnowDto getMinMaxPrecipSnowDto() {
        return minMaxPrecipSnowDto;
    }

    public void setMinMaxPrecipSnowDto(MinMaxPrecipSnowDto minMaxPrecipSnowDto) {
        this.minMaxPrecipSnowDto = minMaxPrecipSnowDto;
    }
}
