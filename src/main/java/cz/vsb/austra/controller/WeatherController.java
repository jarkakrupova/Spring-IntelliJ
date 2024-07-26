package cz.vsb.austra.controller;

import cz.vsb.austra.City;
import cz.vsb.austra.dto.WeatherDto;
import cz.vsb.austra.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    WeatherService service;
    @CrossOrigin
    @GetMapping("/weather/{city}")
    public WeatherDto getWeatherForCity(@PathVariable("city") String city){
        City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getWeatherForCity(cityEnum);
    }
    @CrossOrigin
    @GetMapping("/weather")
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
