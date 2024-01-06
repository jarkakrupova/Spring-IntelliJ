package cz.vsb.austra.service;

import cz.vsb.austra.City;
import cz.vsb.austra.connector.ForecastConnector;
import cz.vsb.austra.dto.ForecastApiDto;
import cz.vsb.austra.dto.ForecastDto;

public class ForecastService {
    public ForecastDto getWeatherForCity(City cityEnum) {
        ForecastConnector connector = new ForecastConnector();
        ForecastApiDto forecastApiDto = connector.getForecastForCity(cityEnum);
        return transformDto(forecastApiDto);
    }
    private ForecastDto transformDto(ForecastApiDto forecastApiDto) {
        ForecastDto forecastDto = new ForecastDto();
        return forecastDto;
    }
}
