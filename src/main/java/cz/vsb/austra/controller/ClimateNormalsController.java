package cz.vsb.austra.controller;

import cz.vsb.austra.City;
import cz.vsb.austra.dto.ForecastDto;
import cz.vsb.austra.dto.meteostat.MonthlyClimateNormalDto;
import cz.vsb.austra.service.ClimateNormalsService;
import cz.vsb.austra.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimateNormalsController {
    ClimateNormalsService service;

    @Autowired
    public ClimateNormalsController(ClimateNormalsService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/normals/{city}")
    public MonthlyClimateNormalDto getWeatherForCity(@PathVariable("city") String city) {
        //City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getSunMoonAstroDataForTheCity(city);
    }
}
