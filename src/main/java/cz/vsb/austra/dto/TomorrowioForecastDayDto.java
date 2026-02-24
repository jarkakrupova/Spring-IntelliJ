package cz.vsb.austra.dto;

import java.util.ArrayList;
import java.util.List;

public class TomorrowioForecastDayDto {
    private MinMaxPrecipSnowDto minMaxPrecipSnowDto;
    private List<TomorrowioForecastHourDto> tomorrowioForecastHourlyData;

    public TomorrowioForecastDayDto() {
        setTomorrowioForecastHourlyData(new ArrayList<>());
    }

    public List<TomorrowioForecastHourDto> getTomorrowioForecastHourlyData() {
        return tomorrowioForecastHourlyData;
    }

    public void setTomorrowioForecastHourlyData(List<TomorrowioForecastHourDto> tomorrowioForecastHourlyData) {
        this.tomorrowioForecastHourlyData = tomorrowioForecastHourlyData;
    }
    public MinMaxPrecipSnowDto getMinMaxPrecipSnowDto() {
        return minMaxPrecipSnowDto;
    }

    public void setMinMaxPrecipSnowDto(MinMaxPrecipSnowDto minMaxPrecipSnowDto) {
        this.minMaxPrecipSnowDto = minMaxPrecipSnowDto;
    }
}
