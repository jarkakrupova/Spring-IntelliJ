package cz.vsb.austra.controller;

import cz.vsb.austra.City;
import cz.vsb.austra.dto.WeatherDto;
import cz.vsb.austra.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    WeatherService service;
    @CrossOrigin
    @RequestMapping("/weather/{city}")
    public WeatherDto getWeatherForCity(@PathVariable("city") String city){
        City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getWeatherForCity(cityEnum);
    }
    @CrossOrigin
    @RequestMapping("/weather")
    public Collection<WeatherDto> getWeather() {
        List<WeatherDto> weatherList = new ArrayList<>();
        //service = new WeatherService();
        for(City city: City.values()) {
            WeatherDto weatherDto = service.getWeatherForCity(city);
            weatherList.add(weatherDto);
        }
        return weatherList;
    }

}
