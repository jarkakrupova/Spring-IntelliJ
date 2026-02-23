package cz.vsb.austra.controller;

import cz.vsb.austra.dto.ForecastDto;
import cz.vsb.austra.service.ForecastService;
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
        //City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getWeatherForCity(city);
    }

    @CrossOrigin
    @GetMapping("/forecast/{lat},{lon}")
    public ForecastDto getWeatherForCity(@PathVariable("lat") double lat, @PathVariable("lon") double lon) {
        //City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getWeatherForCity(lat, lon);
    }
}
