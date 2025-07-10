package cz.vsb.austra.controller;

import cz.vsb.austra.dto.GeocodingDto;
import cz.vsb.austra.dto.GeocodingList;
import cz.vsb.austra.dto.openmeteo.Geocoding;
import cz.vsb.austra.dto.openmeteo.HistoricalDailyWeatherDto;
import cz.vsb.austra.dto.openmeteo.Result;
import cz.vsb.austra.service.GeocodingService;
import cz.vsb.austra.service.HistoricalWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class GeocodingController {
    GeocodingService service;

    @Autowired
    public GeocodingController(GeocodingService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/geocoding/{city}/{count}")
    public GeocodingList getSunMoonAstroForCity(@PathVariable("city") String city, @PathVariable("count") int count){
        //City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getGeocodingForTheCity(city, count);
    }

    @CrossOrigin
    @GetMapping("/geocoding/{id}")
    public GeocodingDto getSunMoonAstroForCity(@PathVariable("id") int id){
        //City cityEnum = City.valueOf(city.toUpperCase());
        //service = new WeatherService();
        return service.getGeocodingForId(id);
    }
}
