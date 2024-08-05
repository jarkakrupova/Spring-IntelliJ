package cz.vsb.austra.service;

import cz.vsb.austra.City;
import cz.vsb.austra.connector.WeatherApiConnector;
import cz.vsb.austra.dto.weatherapi.WeatherApiDto;
import cz.vsb.austra.dto.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    WeatherApiConnector connector;

    @Autowired
    public WeatherService(WeatherApiConnector connector) {
        this.connector = connector;
    }

    public WeatherDto getWeatherForCity(City cityEnum) {
        //connector = new WeatherApiConnector();
        WeatherApiDto weatherApiDto = connector.getWeatherForCity(cityEnum);
        return transformDto(weatherApiDto);
    }

    private WeatherDto transformDto(WeatherApiDto weatherApiDto) {
        WeatherDto wDto = new WeatherDto();
        wDto.setLocation(weatherApiDto.getLocation().getName());
        wDto.setRel_humidity(weatherApiDto.getCurrent().getHumidity());
        wDto.setTemp_celsius(weatherApiDto.getCurrent().getTemp_c());
        wDto.setTimestamp(weatherApiDto.getLocation().getLocaltime());
        wDto.setWeatherDescription(weatherApiDto.getCurrent().getCondition().getText());
        wDto.setWindDirection(weatherApiDto.getCurrent().getWind_dir());
        wDto.setWindSpeed_mps(Math.round(weatherApiDto.getCurrent().getWind_kph() / 3.6));
        return wDto;
    }

}
