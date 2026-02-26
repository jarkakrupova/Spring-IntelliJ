package cz.vsb.austra.dto;

import java.util.ArrayList;
import java.util.List;

public class TomorrowioForecastDayDto {
    private TomorrowioMinMaxPrecipSnowDto minMaxPrecipSnowDto;
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
    public TomorrowioMinMaxPrecipSnowDto getMinMaxPrecipSnowDto() {
        return minMaxPrecipSnowDto;
    }

    public void setMinMaxPrecipSnowDto(TomorrowioMinMaxPrecipSnowDto minMaxPrecipSnowDto) {
        this.minMaxPrecipSnowDto = minMaxPrecipSnowDto;
    }
}
