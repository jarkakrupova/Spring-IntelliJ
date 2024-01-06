package cz.vsb.austra.controller;

import cz.vsb.austra.City;
import cz.vsb.austra.dto.ForecastDto;
import cz.vsb.austra.dto.WeatherDto;
import cz.vsb.austra.service.ForecastService;
import cz.vsb.austra.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastController {
    @Autowired
    ForecastService service;

    @CrossOrigin
    @RequestMapping("/forecast/{city}")
    public ForecastDto getWeatherForCity(@PathVariable("city") String city) {
        City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getWeatherForCity(cityEnum);
    }
}
