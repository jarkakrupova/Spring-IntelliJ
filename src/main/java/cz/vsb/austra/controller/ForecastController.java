package cz.vsb.austra.controller;

import cz.vsb.austra.City;
import cz.vsb.austra.dto.ForecastDto;
import cz.vsb.austra.dto.WeatherDto;
import cz.vsb.austra.service.ForecastService;
import cz.vsb.austra.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ForecastController {
    ForecastService service;

    @Autowired
    public ForecastController(ForecastService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/forecast/{city}")
    public ForecastDto getWeatherForCity(@PathVariable("city") String city) {
        City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getWeatherForCity(cityEnum);
    }
}
