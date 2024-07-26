package cz.vsb.austra.controller;

import cz.vsb.austra.City;
import cz.vsb.austra.dto.SunMoonAstroDto;
import cz.vsb.austra.service.AstroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@RestController
public class AstroController {
    @Autowired
    AstroService service;
    @CrossOrigin
    @GetMapping("/astro/{city}")
    public SunMoonAstroDto getSunMoonAstroForCity(@PathVariable("city") String city){
        City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getSunMoonAstroDataForTheCity(cityEnum);
    }
    @CrossOrigin
    @GetMapping("/astro")
    public Collection<SunMoonAstroDto> getSunMoonAstro() {
        List<SunMoonAstroDto> weatherList = new ArrayList<>();
        //service = new WeatherService();
        for(City city: City.values()) {
            SunMoonAstroDto weatherDto = service.getSunMoonAstroDataForTheCity(city);
            weatherList.add(weatherDto);
        }
        return weatherList;
    }
}
